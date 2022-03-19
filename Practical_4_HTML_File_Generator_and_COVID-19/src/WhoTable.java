public class WhoTable {
    final WhoData data;
    final Query query;

    public WhoTable(WhoData data, String[] queryData) {
        this.data = data;
        this.query = new Query(queryData);
    }

    String headerRow() {
        return HtmlFormat.thead(
                HtmlFormat.tr(
                        HtmlFormat.th("Country") +
                                HtmlFormat.th("Cases") +
                                HtmlFormat.th("Deaths"), ""));
    }

    String closeTable(String str, WhoDataItem last) {
        String caption = "";
        if(last != null && !this.query.getRegion().equals("ALL")) {
            caption = String.format("Cases and Deaths by Country <br/>Region: %s", last.getWhoRegion());
        } else if (last != null) {
            caption = "Cases and Deaths by Country";
        }
        return HtmlFormat.table(headerRow() +
                HtmlFormat.tbody(str), caption);
    }

    void setTotals(Query query, WhoDataItem data, int[] totals) {
            totals[0] += data.getNewCases();
            totals[1] += data.getNewDeaths();
    }

    String buildRow(WhoDataItem data, int[] totals, boolean isOdd) {
        String rtn;
        String body = HtmlFormat.th(data.getCountry().toString()) + HtmlFormat.td(String.valueOf(totals[0])) + HtmlFormat.td(String.valueOf(totals[1]));

        if (isOdd) {
            rtn = HtmlFormat.tr(body, "odd");
        } else {
            rtn = HtmlFormat.tr(body, "even");
        }
        return rtn;
    }
    public String render() {
        String rtn = "";
        int rowCounter = 0;
        int[] totals = new int[2];
        WhoDataItem last = null;
        WhoDataItem current = null;
        for (WhoDataItem checker:data.queryData(query)) {
            current = checker;
            if (current.getCountry().equals(last)) {
                rtn += buildRow(current, totals, rowCounter % 2 == 1);
                totals = new int[2];
            }
            setTotals(query, checker, totals);
            last = current;
        }
        rtn += buildRow(current, totals, rowCounter % 2 == 1);
        return closeTable(rtn, last);
    }
}
//Your tests incorreectly returns
// <table>
// <caption>CasesandDeathsbyCountry</caption>
// <thead>
// <trclass=""><th>Country</th><th>Cases</th><th>Deaths</th></tr></thead><tbody><trclass="even"><th>UnitedStatesofAmerica</th><td>1875250</td><td>128252</td></tr></tbody></table>

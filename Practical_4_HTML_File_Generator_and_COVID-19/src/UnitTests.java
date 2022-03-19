import java.time.LocalDate;
/**
 * Simple Unit Tests 
 * 
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class UnitTests {

    // You will want to add tests in this file
    public static void run() {
        //Tests for HtmlFormat
        System.out.println(HtmlFormat.h1("Test code for h1"));
        System.out.println(HtmlFormat.h2("Test code for h2"));
        System.out.println(HtmlFormat.h3("Test code for h3"));
        System.out.println(HtmlFormat.h4("Test code for h4"));
        System.out.println(HtmlFormat.table(
                            HtmlFormat.thead(
                             HtmlFormat.tr(
                              HtmlFormat.th("Col Header") +
                              HtmlFormat.td("Col head2") +
                              HtmlFormat.td("Col head3"), "heads"
                             )) +
                            HtmlFormat.tbody(
                            HtmlFormat.tr(
                                    HtmlFormat.th("Row Header") +
                                        HtmlFormat.td("Cool") +
                                        HtmlFormat.td("Runnings"), "odd")), "Mycaption"));
        //Tests for Query
        String[] testArr = {"spaghetti","country:US","region:AMRO","cumulative:true","hopefully skips"};
        Query test = new Query(testArr);
        System.out.println(test.getCountry());
        System.out.println(test.getRegion());
        System.out.println(test.isCumulative());

        //Tests for WhoTable
        Country testCountry = new Country("US", "United States");

        WhoData testData = new WhoData(new CSVReader("data/who-data.csv"));

        WhoDataItem testDataItem = new WhoDataItem(LocalDate.of(2001,10,31), testCountry, "AMRO", 2500, 100);

        WhoTable test2 = new WhoTable(testData, testArr);

        int[] testTotals = {2, 1};

        System.out.println(test2.buildRow(testDataItem, testTotals, false));

        int[] newTestTotals = {3000, 100};
        test2.setTotals(test, testDataItem, newTestTotals);
        System.out.println(test2.buildRow(testDataItem, newTestTotals, true));

    }
    
}

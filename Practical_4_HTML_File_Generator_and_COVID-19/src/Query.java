public class Query {
    private String region = "ALL";
    private String country = "ALL";
    private boolean cumulative = true;

    public String getRegion() {
        return region;
    }
    public String getCountry() {
        return country;
    }
    public boolean isCumulative() {
        return cumulative;
    }

    public Query(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].contains(":")) {
                String[] arr = tokens[i].split(":");
                if(arr[1] != null) {
                    if (arr[0].equalsIgnoreCase("country")) {
                        country = arr[1];
                    }
                    if (arr[0].equalsIgnoreCase("region")) {
                        region = arr[1];
                    }
                    if (arr[0].equalsIgnoreCase("cumulative")) {
                        cumulative = Boolean.parseBoolean(arr[1].toLowerCase());
                    }
                }
            }
        }
    }
}

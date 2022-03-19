import java.time.LocalDate;

/**
 * The WhoDataItem follows the data found in the standard who data for infectious diseases. The
 * WhoDataItem is immutable. 
 * 
 * @author Albert Lionelle <br> 
 *          lionelle@colostate.edu <br> 
 *          Computer Science Department <br> 
 *          Colorado State University
 * @version 202010
 */
public class WhoDataItem {
    
    private final LocalDate reported;
    private final Country country;
    private final String whoRegion;
    private final int newCases;
    private final int newDeaths;

    /**
     * All data in the WhoDataItem is final, as it is storage only. Constructor sets all the values
     * @param date  The Date the data was collected based on local date
     * @param country The country - contains both code and name. 
     * @param whoRegion The who region as a string 
     * @param newCases Number of new cases based on that date
     * @param newDeaths Number of new deaths based on that date
     */
    public WhoDataItem(LocalDate date, Country country, String whoRegion, int newCases, int newDeaths) {
        this.reported = date;
        this.country = country;
        if(whoRegion.isEmpty()) {
            this.whoRegion = "undefined";
        }else {
            this.whoRegion = whoRegion;
        }
        this.newCases = newCases;
        this.newDeaths = newDeaths;
    }

    /**
     * Accessor for reported
     */
    public LocalDate getReported() {
        return reported;
    }

    /**
     * Accessor for country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Accessor for region
     */
    public String getWhoRegion() {
        return whoRegion;
    }

    /**
     * Accessor for newCases
     */
    public int getNewCases() {
        return newCases;
    }

    /**
     * Accessor for newDeaths
     */
    public int getNewDeaths() {
        return newDeaths;
    }


    /**
     * Based on the country code passed in, determines if this item is a match. The code can be a simple code
     * or it can be 'ALL' (for all countries) or a list of countries separated by a comma and will check in the list. 
     * @param code The country code, ALL or list of codes separated by commas
     * @return true if this is a match, false otherwise. 
     */
    public boolean isCountry(String code) {
        return (code.equalsIgnoreCase("ALL") || country.equals(code) || code.contains(country.code));
    }

    /**
     * Based on the region code passed in, determines if this item is a match. The code can be a simple code
     * or it can be 'ALL' (for all regions) or a list of regions separated by a comma and will check in the list. 
     * @param region The region code, ALL or list of codes separated by commas
     * @return true if this is a match, false otherwise. 
     */
    public boolean isRegion(String region) {
        return region.equalsIgnoreCase("ALL") || whoRegion.equalsIgnoreCase(region) || region.contains(whoRegion);
    }

    /**
     * Simple toString for easy printing and debugging. For the students, this is automatically called
     * if a print is called on the object (System.out.println(whoDataItem)) 
     * @return A formatted string
     */
    @Override
    public String toString() {
        return String.format("%s, %s, Region: %s, New Cases: %d, New Deaths: %d", 
                reported, country, whoRegion, newCases, newDeaths);
    }


    
}

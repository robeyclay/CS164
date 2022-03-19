/**
 * Stores a code/name combination, meant so each country code is unique in a dataset. This class is immutable
 * 
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class Country implements  Comparable<Country>{
    public final String code;
    public final String name;

    /**
     * Stores the code and name
     * @param code country code
     * @param name name of country
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }


    /**
     * Equals helps when comparing two countries. This uses a case of comparing a string also
     * to see if it equals the country
     * @param country the country to compare again
     * @return true if equivalent. 
     */
    @Override
    public boolean equals(Object country) {
        if(country instanceof Country) 
            return this.code.equalsIgnoreCase(((Country)country).code);
        if(country instanceof String) 
            return this.code.equalsIgnoreCase((String)country);
        return false;
    }
    
    /*
    Simply prints the name of the country when doing System.out.println(country)
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * uses the country code to provide an ordered comparison for sorting
     * @param country the country to compare again
     * @return Same as String compareTo
     */
    @Override
    public int compareTo(Country country) {
        return this.code.compareTo(country.code);
    }
}

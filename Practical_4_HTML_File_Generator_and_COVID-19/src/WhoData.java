import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * 
 * Reads in the WhoData CSV file, builds List of all the data, and allows for queries of different 'views' or 'slices'
 * of that data. This class is immutable, as once the data is loaded, there is no way to change the contents of
 * this object without creating a new object. 
 * 
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br>
 *         Colorado State University
 *         
 * @version 202010
 */
public class WhoData {
    
    // placed here, so the code is more readable 
    private static int DATE_REPORTED_INDEX= 0;
    private static int COUNTRY_CODE_INDEX = 1;
    private static int COUNTRY_INDEX =2;
    private static int WHO_REGION_INDEX = 3;
    private static int NEW_CASES = 4;
    private static int NEW_DEATHS = 6;
    
    // Helps parse the date format in the file
    private static final DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);

    // A list of WhoDataItems -- primary datastructure! 
    private final List<WhoDataItem> whoData = new ArrayList<>();

    /**
     * Constructor that forces loading the data into the WhoData structure
     * @param csvData who data CSV to load
     */
    public WhoData(CSVReader csvData) {
        loadData(csvData);
    }

    /**
     * Uses a Query object to filter on country and region based on the query passed in. Returns an 
     * Array of WhoDataItems of the exact match. It could also return a List, but Lists have not 
     * been covered at this point in the class. This also makes use of Java Streams, an advanced data
     * handling feature (this isn't learned until upper division courses). 
     * Learn more at:https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
     * @param query the Query object that has getCountry() and getRegion()
     * @return an array of WhoDataItems matching that query. 
     */
   public  WhoDataItem[] queryData(Query query) {
        List<WhoDataItem> list = whoData.stream()
                 .filter(whoDataItem -> whoDataItem.isCountry(query.getCountry()))
                 .filter(whoDataItem -> whoDataItem.isRegion(query.getRegion()))
                 .collect(Collectors.toList());
        WhoDataItem[] tmp = new WhoDataItem[list.size()];
        list.toArray(tmp);
        return tmp;  // really no reason to turn it to an array, other than student's haven't learned lists yet
    }


    /**
     * Loads data from a CSV, does parsing, and skips lines if the data is invalid in that line. 
     * @param csvReader A who data csv file
     */
    private void loadData(CSVReader csvReader) {
        Country[] countries = new Country[1000]; // actually a temp array!
        
        while(csvReader.hasNext()) {
            List<String> values = csvReader.getNext();
            try { // all this validates the data before adding it
                LocalDate date = LocalDate.parse(values.get(DATE_REPORTED_INDEX), inputFormatter);
                Country country = findCountry(countries, values.get(COUNTRY_CODE_INDEX), values.get(COUNTRY_INDEX));
                int newCases = Integer.parseInt(values.get(NEW_CASES));
                int newDeaths = Integer.parseInt(values.get(NEW_DEATHS));
                if(newCases > -1 && newDeaths > -1) { // some have negative numbers, not sure the validity of reporting those days, removing
                    whoData.add(new WhoDataItem(date, country, 
                            values.get(WHO_REGION_INDEX), newCases, newDeaths));
                    //Logger.debug("Adding %s%n", whoData.get(whoData.size()-1));
                } 
            } catch(NumberFormatException nx) {
                Logger.debug("%s - ", nx.getMessage());
                Logger.logDetails("Invalid count%n");
            } catch(DateTimeParseException px) {
                Logger.debug("%s - ",values.get(DATE_REPORTED_INDEX), px.getMessage());
                Logger.logDetails("Invalid Date, skipping%n");
            }
        }
        
    }

    /**
     * Helps find the country in the countries array, so they are only created once
     */
    private Country findCountry(Country[] countries, String code, String name) {
        for(int i = 0; i < countries.length; i++) {
            if(countries[i] != null) {
                if (countries[i].code.equals(code)) return countries[i];
            }else {
                countries[i] = new Country(code, name);
                return countries[i];
            }
        }
        return null;
    }
}

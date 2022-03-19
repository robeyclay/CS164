import java.util.Arrays;

/**
 * Keeps a count for the different genders. When the dataset was pulled, the data only had two genders listed
 * but through work of Computer Science professor Dr. Bruce Draper and many others, CSU recently added other options
 * to their database. As such, this class is designed to be adapted if the data is updated in the future. 
 * 
 * @author YOUR NAME <br> 
 *         YOUR EMAIL <br> 
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 202010
 */
public class GenderCounter {
    public final static String[] OPTIONS = {"F", "M"};  // CSU just recently added non-binary as an option, 
                                                  // after this data was pulled - but class is designed to be updated
    public final static String[] FRIENDLY_NAMES = {"Female", "Male"};
    private final int[] counts = new int[OPTIONS.length]; // we only have a count for each option, so M:5, F:6, etc

    /**
     * Returns a series of pair objects based on friendlyName and percent. The percent is calculated
     * @return Pair[] of length options.length
     */
    public Pair[] getPercents() {
        int total = 0;
        for(int count : counts) {total += count;}
        Pair[] percents = new Pair[OPTIONS.length];
        for(int i = 0; i < percents.length; i++) {
            percents[i] = new Pair(FRIENDLY_NAMES[i], (((double)counts[i])/total)*100); // percents should be multipled by 100
        }
        return percents;
    }

    /**
     * increments the counter for that specific gender
     * @param gender the string value of the gender (F, M) eventually adding N and others. Matches with options
     */
    public void addCount(String gender) {
        int index = Arrays.binarySearch(OPTIONS, gender.toUpperCase()); // you will learn about BinarySearch later but it is fast
        if(index < 0) {
            Logger.logDetails("Invalid gender provided: %s%n", gender);
        } else {
            counts[index]++;
        }
    }

    /**
     * JSON (https://www.json.org/json-en.html) representation of the object and sub objects
     * @return a well formatted json string
     */
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        //STUDENT TODO
        String formatting = "";
        for (int i = 0; i < OPTIONS.length; i++) {
            formatting = String.format("\"%s\":%d,",FRIENDLY_NAMES[i], counts[i]);
            builder.append(formatting);
        }

        //END TODO
        builder.deleteCharAt(builder.length()-1); // remove last comma
        builder.append("}");
        return builder.toString();
    }
    
}

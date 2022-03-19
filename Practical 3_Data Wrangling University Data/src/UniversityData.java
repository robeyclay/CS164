import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * UniversityData is essentially a large "dataset" that reads in from a
 * CSV (Comma Separated Value) file, and stores all the data in a structured (by objects)
 * manner. 
 * 
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 202010
 */
public class UniversityData {

    // these static variables make the code more readable, as we don't just
    // see numbers when accessing the array elements. Instead we see what
    // they are supposed to be 
    public final static int PRIMARY_COLLEGE = 0;
    public final static int PRIMARY_COLLEGE_DESC = 1;
    public final static int PRIMARY_DEPARTMENT_DESC = 2;
    public final static int PRIMARY_MAJOR = 3;
    public final static int TERM = 4;
    public final static int GENDER = 5;
    
    private TermPair[] terms = new TermPair[50];
    private int termCount = 0;

    /**
     * gets the TermPair array - which is term by List of Colleges
     * @return the TermPair[] array
     */
    public TermPair[] getTerms() { 
        return terms;
    }

    /**
     * Loads the data from a given CSV file
     * @param file the filename 
     */
    public void loadData(String file) {
        CSVReader reader = new CSVReader(file);
        if(reader.hasNext()) reader.getNext(); // skip header
        while(reader.hasNext()) {
            addStudent(reader.getNext());
        }
        // done reading in all the data - time to clean the array memory allocation
        // clean up  TermPair array, so we can easily sort by terms
        cleanAndSort();
    }

    /**
     * Saves out the data in a json (https://www.json.org/json-en.html) representation
     * @param filename the file name to save out to - suggested to have .json
     */
    public void saveData(String filename) {
        try {
            PrintWriter writer = new PrintWriter(new File(filename));
            Logger.logDetails("Saved data to file: %s%n", filename);
            writer.write(this.toJson());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is one way to deal with oversized arrays on fixed data. We build an oversized
     * array, and once all data is loaded - we build a smaller array and overwrite
     * the old array. This is a cascading method that also calls cleanAndSort on all
     * colleges objects under it - basically cleaning up the array sizes
     * for the entire dataset. 
     */
    private void cleanAndSort() {
        TermPair[] pairs = new TermPair[termCount];
        System.arraycopy(terms, 0, pairs, 0, termCount);
        terms = pairs;
        Arrays.sort(terms);
        for(TermPair term : terms) {
            term.list.cleanAndSort();
        }
    }

    /**
     * Primary way to add students to the dataset, it takes in an array
     * representation of the student as strings (aka a commas separated value that is split)
     * @param values an array of strings representing the student
     */
    public void addStudent(String[] values) {
        int term = Integer.parseInt(values[TERM]);
        int index = findTermIndex(term);
        if(index < 0) {
            terms[termCount] = new TermPair(term, new CollegeList());
            index = termCount++;
        }
        terms[index].list.addStudent(values[PRIMARY_COLLEGE], 
                                         values[PRIMARY_COLLEGE_DESC], 
                                         values[PRIMARY_DEPARTMENT_DESC],
                                         values[PRIMARY_MAJOR],
                                         values[GENDER]);
    }


    /**
     * Finds the index of the term in the terms array. If the term is not found
     * returns -1
     * @param term the term represented as an int value
     * @return the TermPair object or -1 if not found
     */
    public int findTermIndex(int term) {
        for(int i = 0; i < termCount; i++) {
            if(terms[i] != null && terms[i].term == term) return i;
        }
        return -1;
    }


    /**
     * JSON (https://www.json.org/json-en.html) representation of the object and sub objects
     * @return a well formatted json string
     */
    public String toJson() {
        StringBuilder builder = new StringBuilder("{");
        for(int i = 0; i < termCount; i++) {
            builder.append("\"");
            builder.append(terms[i].term);
            builder.append("\"");
            builder.append(":");
            builder.append(terms[i].list.toJson()); // starts a series of toJson calls down the object path
            builder.append(",");
        }
        builder.deleteCharAt(builder.length()-1); // remove the trailing comma
        builder.append("}");
        return builder.toString();
    }

   


}

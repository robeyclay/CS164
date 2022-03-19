import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is a simple CSV reader, that does not take into account quoted commas (a proper one does).
 * 
 * @author YOUR NAME <br>
 *         YOUR EMAIL <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 202010
 */
public class CSVReader {
    private static final String DELIMINATOR = ",";
    // TODO by student
    private Scanner fileScanner;


    

    /**
     * A constructor that requires the name of the file to open
     * @param file filename
     */
    public CSVReader(String file) {
        try {
            //TODO by student  - initialize a new scanner with a new File, and set it to the fileScanner variable
            FileInputStream fileStream = new FileInputStream(file);
            fileScanner = new Scanner(fileStream);
            // uncomment the try catch lines after done
    
            //end todo
        }catch (FileNotFoundException io) {
            Logger.debug("File %s not found", file);
            System.exit(1);
        }
    }

    /**
     * Reads a line (nextLine()) and splits it into a String array by the DELIMINATOR, if the line is
     * empty it will also return null
     * @return a String array if a line exits or null if not
     */
    public String[] getNext() {
        //TODO by student
        if (fileScanner.hasNextLine()) {
            return fileScanner.nextLine().split(DELIMINATOR);
        } else {
            return null;
        }
    }

    /**
     * Checks to see if the fileScanner has more lines and returns the answer. 
     * @return true if the file scanner has more lines (hasNext())
     */
    public boolean hasNext() {
        if (fileScanner.hasNext()) {
            return true;
        } else {
            return false;
        } //TODO by student

    }



}

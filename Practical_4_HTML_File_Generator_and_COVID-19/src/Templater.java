
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author YOUR  NAME <br> 
 *         YOUR EMAIL <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class Templater {
     private final WhoData data;
    
    public Templater(WhoData data) {
        //STUDENT TODO
        this.data = data;
    }

    public void write(String templateFile, String outfile) {
        try {
            Scanner fileScanner = new Scanner(new File(templateFile));
            // loop
            PrintWriter output = new PrintWriter(outfile);
            while (fileScanner.hasNext()) {
                // inside the loop
                String line = fileScanner.nextLine().trim();

                if (line.startsWith("{{")) {
                    // parse the tokens by grabbing the substring between {{ and }} (Split)
                    int first = line.indexOf("{{") + 2;
                    String[] tokens = line.substring(first, line.indexOf("}}", first)).trim().split("\\s+");
                    // construct a WhoTable, set value of render to lineToWrite
                    WhoTable table = new WhoTable(data, tokens);
                    output.println(table.render());
                } else if (fileScanner.hasNextLine()) {
                    output.println(fileScanner.nextLine());
                }
            }
            output.close();
        } catch (FileNotFoundException excpt){
            System.out.println(excpt.getCause());
            System.out.println("Cannot computer templater");
        }
    }

  
}

import java.util.ArrayList;
import java.util.List;

/**
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *          Computer Science Department <br>
 *          Colorado State University
 * @version 202010
 */
public class Main {
    
    public static void main(String[] args) {
        ProgramArguments pargs = new ProgramArguments(args);
        if(pargs.runTests) UnitTests.run();
        
        if(pargs.csvData != null) { // in case tests only
            WhoData data = new WhoData(new CSVReader(pargs.csvData));
            Templater templater = new Templater(data);
            for (String template : pargs.templates) {
                templater.write(template, getFileName(template));
            }
        }
        
    }

    /**
     * Helper method to help figure out the outfile. 
     * @param templateFile the template file to match for the outfile
     * @return the file name to write out to
     */
    private static String getFileName(String templateFile) {
        String[] values = templateFile.split("\\."); // split on extension
        String first = values[0];
        if(first.contains("/")) {  // check in case the templates are stored in a template directory
            first = first.substring(first.lastIndexOf("/")+1);
        }
        return first +".html";
    }

    static class ProgramArguments {
        final String csvData;
        final List<String> templates = new ArrayList<>();
        boolean runTests = false;

        final String HELP_MESSAGE = "Missing program arguments...\n" +
                "usage: Main [-v|--verbose] [-d|--debug] [--tests] dataFile templateFiles...\n" +
                "\tdata file is required to run the program unless running tests\n" +
                "\tany file after dataFile that isn't a named argument, will be a template to be processed\n" +
                "\t-v|--verbose to enable verbose printing, add -v or --verbose\n" +
                "\t-d|--debug to enable debug printing, add -d or --debug\n" +
                "\t--tests to enable unit testing\n" +
                "Examples:\n" +
                "\tjava Main data/who-data.csv template.tmpl\n" +
                "\tjava Main --tests";


        ProgramArguments(String[] args) {

            String csvData = null;
            for (String arg : args) {
                if (arg.startsWith("-")) {
                    processFlag(arg);
                } else {
                    if (csvData == null) {
                        csvData = arg;
                    } else {
                        templates.add(arg);
                    }
                }
            }
            this.csvData = csvData;
            if(runTests) return; // no need too checks sizes if tests are being run
            if(this.csvData == null || templates.size() < 1) {
                Logger.console(HELP_MESSAGE);
                System.exit(0);
            }

        }

        /**
         * handles the various flag cases (- is a common single char flag, while -- is common for words). This only
         * works for single flags, if it is a flag with the next arg following, it won't work (though not a condition
         * for this program.. it is common to say -o outputfile )
         *
         * @param arg the flag
         */
        private void processFlag(String arg) {
            if (arg.equalsIgnoreCase("-v") || arg.equalsIgnoreCase("--verbose")) {
                Logger.setVerbose(true);
            } else if (arg.equalsIgnoreCase("-d") || arg.equalsIgnoreCase("--debug")) {
                Logger.setDebug(true);
            } else if (arg.equalsIgnoreCase("--tests")) { // allows a way to run both tests and program
                runTests = true;
            }
        }
    }
}

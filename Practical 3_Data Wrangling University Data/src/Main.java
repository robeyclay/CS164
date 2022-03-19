
/**
 * Institutional Research tracks enrollments across different majors and colleges.
 * 
 * This program looks at gender differences across majors across years. 
 * 
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class Main {


    /**
     * entry point of the program. It needs an input file for it to run the full program
     * @param args an array of program arguments
     */
    public static void main(String[] args) {
        ProgramArguments parg = new ProgramArguments(args);

        if(parg.runTests) UnitTests.runTests(); // the --tests arg is passed in
        if(parg.inputFileName != null) {
            UniversityData data = new UniversityData();
            data.loadData(parg.inputFileName);
            if (parg.outputFileName != null) {
                data.saveData(parg.outputFileName);
            }
            
            CollegeStats stats = new CollegeStats(data);
            stats.run();
        }

    }

    /**
     * This is an 'inner class', but the advantage of it, is that it helps process the command line arguments
     * so I can have optional arguments like turning on verbose printing or debug statements. It is common
     * to have a separate object to process your command line arguments, and then the main uses that object. 
     */
    static class ProgramArguments {
        final String inputFileName;
        final String outputFileName;
        boolean runTests = false;

        final String HELP_MESSAGE = "Missing program arguments...\n" + 
                "usage: Main [-v|--verbose] [-d|--debug] [--tests] inputFile  [outputFile]\n" +
                "\tinput file is required to run the program unless running tests\n" +
                "\toutput file is optional, but recommended to save out JSON structure\n" +
                "\t-v|--verbose to enable verbose printing, add -v or --verbose\n" +
                "\t-d|--debug to enable debug printing, add -d or --debug\n" +
                "\t--tests to enable unit testing\n" +
                "Examples:\n" +
                "\tjava Main data/CollegeData.csv output.json\n" +
                "\tjava Main --tests";
        
        
        ProgramArguments(String[] args) {
            String output = null;
            String input = null;
            if(args.length == 0) {
                Logger.console(HELP_MESSAGE);
                System.exit(0);
            }
            
            for(String arg : args) {
                if(arg.startsWith("-")) {
                    processFlag(arg);
                }else {
                    if (input == null) {
                        input = arg;
                    } else if (output == null) {
                        output = arg;
                    }
                }
            }
            
            this.inputFileName = input;
            this.outputFileName = output;
        }

        /**
         * handles the various flag cases (- is a common single char flag, while -- is common for words). This only works
         * for single flags, if it is a flag with the next arg following, it won't work (though not a condition for this 
         * program.. it is common to say -o outputfile )
         * @param arg the flag
         */
        private void processFlag(String arg) {
            if(arg.equalsIgnoreCase("-v") || arg.equalsIgnoreCase("--verbose")) {
                Logger.toggleVerbose();
            }else if(arg.equalsIgnoreCase("-d") || arg.equalsIgnoreCase("--debug")){
                Logger.toggleDebug();
            }else if(arg.equalsIgnoreCase("--tests")) { // allows a way to run both tests and program
                runTests = true;
            }
        }
    }
    
    
}

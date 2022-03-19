/**
 * This Logger helps log information about the process you are doing, including writing to the console. Many
 * programs write to system logs in the background, even if they are gui based programs or web based
 * programs. There is a whole suit of prebuilt loggers for Java for that reason. 
 * 
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class Logger {
    private static boolean verbose  = false;
    private static boolean debug = false;

    /**
     * Logs to System.out if verbose is set to true. Uses a parameter list (...), 
     * to allow transparent work with printf. 
     * @param toLog The string to print or the string format to evaluate
     * @param args optional arguments used in the string format 
     */
    public static void logDetails(String toLog, Object... args) { 
        if(verbose) console(toLog, args);
    }

    /**
     * Logs to System.out if debug is set to true. Uses a parameter list (...), 
     * to allow transparent work with printf. 
     * @param toLog The string to print or the string format to evaluate
     * @param args optional arguments used in the string format
     */
    public static void debug(String toLog, Object... args) {
        if(debug) console(toLog, args);
    }

    /**
     * Logs to System.out in all cases. Uses a parameter list (...), 
     * to allow transparent work with printf. 
     * @param toLog The string to print or the string format to evaluate
     * @param args optional arguments used in the string format
     */
    public static void console(String toLog, Object... args) {
        System.out.printf(toLog, args);
    }

    /**
     * Toggles verbose logging
     */
    public static void toggleVerbose() {
        verbose = !verbose;
    }

    /**
     * Toggles debug logging (which includes verbose logging)
     */
    public static void toggleDebug() {
        debug = !debug;
        toggleVerbose();
    }

    /**
     * Sets the debug value
     */
    public static void setDebug(boolean flag) {
        debug = flag;
        verbose = flag;
    }
}

/**
 * This is a simple class that stores a String with a double value.  Essentially
 * both variables become readonly, and it is a way to access things as a pair. 
 * 
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class Pair {
    public final String name;
    public final double value;

     Pair(String name, double value) {
        this.name = name;
        this.value = value;
     }
}

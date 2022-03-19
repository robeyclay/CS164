/**
 * This class holds a read only pairing of Term and CollegeList (essentially a collection
 * of colleges). By having this pairing, it is easier to sort and also
 * keep information together. 
 * 
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class TermPair implements Comparable<TermPair> {

    // by making these final, we essentially make them 'read only' after they are set in the constructor
    final Integer term; // this is a wrapper class, learned in Unit 3
    final CollegeList list;

    public TermPair(int term, CollegeList list) {
        this.term = term;   // this is allowed, and a great way to make a variable read only! 
        this.list = list;
    }

    // we will explore compareTo() in unit 3 and 4
    public int compareTo(TermPair pair) { // compareTo is used by Arrays.sort()
        return this.term.compareTo(pair.term); // making use of the wrapper class
    }
}

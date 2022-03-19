/**
 * Tracks a major within a department. This also tracks the genders across that major (really, as that is our
 * only student information for this data - ideally it would track all the student info)
 * 
 * @author YOUR NAME <br> 
 *         YOUR EMAIL <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class Major implements  Comparable<Major>{
    private final String name;
    private final GenderCounter gcounter = new GenderCounter();

    /**
     * Gets the name of the major
     * @return the name of the major
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a student, but really just tracking which gender by adding to the count of gcounter
     * @param gender student gender id 
     */
    public void addStudent(String gender) {
        gcounter.addCount(gender);
    }

    /**
     * returns the percentages values of each gender count 
     * @return an Pair[] array of String:fiendly name and double:percent 
     */
    public Pair[] getPercents() {
        return gcounter.getPercents();
    }

    /**
     * JSON (https://www.json.org/json-en.html) representation of the object and sub objects
     * @return a well formatted json string
     */
    public String toJson() {
        String formatting = String.format("{\"name\":\"%s\",\"data\":%s}", this.name, gcounter.toJson());
        return formatting;
    }

    /**
     * The name of the major must be unique
     * @param name unique name of the major
     */
    public Major(String name) {
        this.name = name;
    }
    

    @Override
    public int compareTo(Major o) {
        return this.name.compareTo(o.name);
    }
}

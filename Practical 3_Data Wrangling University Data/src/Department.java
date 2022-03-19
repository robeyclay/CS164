import java.util.Arrays;

/**
 * Colleges are split up into departments, and this class tracks the information on a department
 * level includes what majors are associated with that department. 
 * 
 * @author YOUR NAME <br> 
 *         YOUR EMAIL <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class Department implements Comparable<Department>{
    private Major[] majors = new Major[100]; // set overly large at first, fixed in cleanAndSort
    private int majorCount = 0;
    private final String name;
    private final GenderCounter gcounter = new GenderCounter(); // keep track of genders at a department level

    /**
     * gets the list of majors in the department
     * @return Major[] array of all major objects
     */
    public Major[] getMajors() {
        return majors; //TODO STUDENT
    }

    /**
     * gets the name of the department 
     * @return name of the department 
     */
    public String getName() {
        return name; //TODO STUDENT
    }

    /**
     * Adds a student to the department
     * @param major adds the major to the department based on major name
     * @param gender adds a student to the major and tracks gender splits at a department level
     */
    public void addStudent(String major,String gender) {
       //TODO STUDENT
        Major maj = findOrCreateMajor(major);
        maj.addStudent(gender);
        gcounter.addCount(gender);
    }


    /**
     * Finds a major in the majors[] or creates one if it doesn't exist
     * @param major string name of the major
     * @return the major either found or created
     */
    public Major findOrCreateMajor(String major) {
        Major tmp = findMajor(major);
        if(tmp == null) {
            tmp = createMajor(major);
        }
        return tmp;
    }

    /**
     * creates a major and adds it to the major array
     * @param major the name of the major to add
     * @return the new major that was created
     */
    public Major createMajor(String major) {
        Major tmp = new Major(major);
        majors[majorCount++] = tmp;
        return tmp;
    }
    

    /**
     * Finds the major in the major array, or returns null if not found
     * @param major the string name of the major
     * @return the major or null if not found
     */
    public Major findMajor(String major) {
       //TODO STUDENT
        for ( int i = 0; i < majors.length; i++) {
            if (majors[i] != null) {
                if (majors[i].getName().equals(major)) {
                    return majors[i];
                }
            }
        }
        return null;
    }


    /**
     * JSON (https://www.json.org/json-en.html) representation of the object and sub objects
     * @return a well formatted json string
     */
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        //TODO STUDENT
        String formatting = String.format("{\"name\":\"%s\",\"data\":%s,\"majors\":[", this.name, gcounter.toJson());
        for ( int i = 0; i < majors.length; i++)
        {
            if (majors[i] != null) {
                formatting += String.format("%s,", majors[i].toJson());
            }
        }
        builder.append(formatting);
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]"); // end department array
        builder.append("}"); // end college map
        //END TODO
        return builder.toString();
    }



    /**
     * We will explore this in the future, but allows for sorting of departments based on name
     * @param o the department to compare against
     * @return based on the name of the department 
     */
    @Override
    public int compareTo(Department o) {
        return this.name.compareTo(o.name);
    }

    /**
     * This is one way to deal with oversized arrays on fixed data. We build an oversized
     * array, and once all data is loaded - we build a smaller array and overwrite
     * the old array. It then sorts the majors in the array. 
     */
    public void cleanAndSort() {
        Major[] newMajors = new Major[majorCount];
        System.arraycopy(majors, 0, newMajors, 0, majorCount);
        majors = newMajors;
        Arrays.sort(majors);
    }


    /**
     * Constructor - the department name must be unique. 
     * @param name string name of the department
     */
    public Department(String name) {
        this.name = name;
    }

}

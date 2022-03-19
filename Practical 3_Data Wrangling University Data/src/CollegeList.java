/**
 * Keeps an array of Colleges, as there are multiple colleges at a university. For now,
 * this is a bit overkill, and you will eventually learn about ArrayLists that would
 * replace this class. 
 * 
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br>
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class CollegeList {

    private College[] colleges = new College[15];// what happens if there are more than 15??
    private int collegeCount = 0;

    /**
     * gets the array of colleges
     * @return the Colleges array
     */
    public College[] getColleges() {
        return colleges;
    }

    /**
     * adds a student to the dataset starting a chain of add student calls. 
     * @param code  code for the college
     * @param college friendly name for the college
     * @param department friendly name for the department (passed to college)
     * @param major name of the major (passed to college)
     * @param gender gender of the student (passed to college)
     */
    public void addStudent(String code, String college, String department, String major, String gender) {
        College col = findOrCreateCollege(code, college);
        col.addStudent(department, major, gender);
    }

    /**
     * searches for the college in the college array, but if not found, creates the college
     * @param code the college code string
     * @param name the friendly college name
     * @return the college object
     */
    private College findOrCreateCollege(String code, String name) {
        College tmp = findCollege(code);
        if(tmp == null) {
            tmp = createCollage(code, name);
        }
        return tmp;
    }

    /**
     * Creates a new college, and adds it to the college array
     * @param code college code
     * @param name friendly college name
     * @return a new college
     */
    private College createCollage(String code, String name) {
        College tmp = new College(code, name);
        colleges[collegeCount++] = tmp;
        return tmp;
    }

    /**
     * Finds a college in the college array based on the college code. Null if not found
     * @param code string value of the college code
     * @return the college object or null
     */
    private College findCollege(String code) {
        for(College college : colleges) { // note the short circuiting null check is required, as colleges is much larger than what is stored in it
            if(college != null && college.getCode().equalsIgnoreCase(code)) return college;
        }
       return null;
    }

    /**
     * JSON (https://www.json.org/json-en.html) representation of the object and sub objects
     * @return a well formatted json string
     */
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0; i < collegeCount; i++) {
            builder.append(colleges[i].toJson()).append(","); // you can chain append calls
        }
        builder.deleteCharAt(builder.length()-1); // remove the trailing comma
        builder.append("]");
        return builder.toString();
    }

    /**
     * This is one way to deal with oversized arrays on fixed data. We build an oversized
     * array, and once all data is loaded - we build a smaller array and overwrite
     * the old array. This is a cascading method that also calls cleanAndSort on all
     * colleges objects under it - basically cleaning up the array sizes
     * for the entire dataset. 
     */
    public void cleanAndSort() {
        College[] newCollages = new College[collegeCount];
        System.arraycopy(colleges, 0, newCollages, 0, collegeCount);
        colleges = newCollages;
        for(College college : colleges) { // this now works fine, as the size is correct
            college.cleanAndSort();
        }
        
    }
}

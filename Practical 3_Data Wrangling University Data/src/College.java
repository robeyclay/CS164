import java.util.Arrays;

/**
 * A college represents a college within the university such as Natural Sciences or Engineering. 
 * At its top level, it keeps a list of departments under it, and passes
 * also tracks the gender split at the college level. 
 * 
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class College {
    private final GenderCounter gcounter = new GenderCounter(); // looks at gender at a college level
    private final String code; // all codes have as short code
    private final String name; // this is the readable name
    private Department[] departments = new Department[30]; // list of departments, eventually we overwrite this
    private int departmentCount = 0; // help us track the number of departments. 

    /**
     * Gets the college code. Doesn't change. 
     * @return college code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the college name. Doesn't change
     * @return college name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the array of departments. 
     * @return the array of departments. 
     */
    public Department[] getDepartments() {
        return departments;
    }


    /**
     * adds a student to the college, also creates a new department if one is
     * needed, and adds that to the college. 
     * @param department  name of department
     * @param major  name of major (passed to department)
     * @param gender  gender of the student
     */
    public void addStudent(String department, String major, String gender) {
        Department dep = findOrCreateDepartment(department);
        dep.addStudent(major, gender);
        gcounter.addCount(gender);
    }

    /**
     * Looks for the department. If it is found in the department arrary, return it, else create it
     * and return it
     * @param department the department name
     * @return the department object
     */
    private Department findOrCreateDepartment(String department) {
        Department tmp = findDepartment(department);
        if(tmp == null) {
            tmp = createDepartment(department);
        }
        return tmp;
    }

    /**
     * Helps find the department in the current array. 
     * @param department the string name of the department
     * @return the department object or null if not found
     */
    public Department findDepartment(String department) {
        for(Department dep : departments) {
            if(dep != null && dep.getName().equalsIgnoreCase(department)) return dep;
        }
        return null;
    }

    /**
     * Creates and adds a department to the department array
     * @param department department name
     * @return the department created
     */
    public Department createDepartment(String department) {
        Department tmp = new Department(department);
        departments[departmentCount++] = tmp;
        return tmp;
    }


    /**
     * JSON (https://www.json.org/json-en.html) representation of the object and sub objects
     * @return a well formatted json string
     */
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("{\"code\":\"%s\",\"name\":\"%s\",\"data\":%s,\"departments\":[", 
                code, name, gcounter.toJson()));
        for(int i = 0; i < departmentCount; i++) {
            builder.append(departments[i].toJson());
            builder.append(",");
        }
        builder.deleteCharAt(builder.length()-1); // remove last comma
        builder.append("]"); // end department array
        builder.append("}"); // end college map
        return builder.toString();
    }

    /**
     * This is one way to deal with oversized arrays on fixed data. We build an oversized
     * array, and once all data is loaded - we build a smaller array and overwrite
     * the old array. This is a cascading method that also calls cleanAndSort on all
     * department objects under it - basically cleaning up the array sizes
     * for the entire dataset. 
     */
    public void cleanAndSort() {
        Department[] newDepartments = new Department[departmentCount];
        System.arraycopy(departments, 0, newDepartments, 0, departmentCount); // quick way to copy arrays
        departments = newDepartments;
        Arrays.sort(departments);
        for(Department department : departments) {
            department.cleanAndSort();
        }
    }

// constructor
    public College(String code, String name) {
        this.code = code;
        this.name = name;
    }

}

/**
 * Arrays lab for CS 1.
 *
 * This lab serves to get you familiar with the use of Arrays and practive working with arrays and classes
 *
 * @author YOUR_NAME
 *         YOUR_EMAIL
 * @version 202010
 */

public class StudentInfo {
    private String[] names;
    private double[] grades;
    private double maxGrade;

    //STEP 1
    //constructor
    //StudentInfo(double maxGrade, int totalStudents)
    public StudentInfo (double maxGrade, int totalStudents) {
        this.maxGrade = maxGrade;
        names = new String[totalStudents];
        grades = new double[totalStudents];
    }

    //Getters and setters
    //Precondition: index is valid

    //getName(int index)

    public String getName(int index) {
        return names[index];
    }
    //setName(int index, String newName)

    public void setName(int index, String newName) {
        names[index] = newName;
    }
    //getGrade(int index)

    public double getGrade(int index) {
        return grades[index];
    }
    //setGrade(int index, double newGrade)
    public void setGrade(int index, double newGrade) {
        grades[index] = newGrade;
    }


    //STEP 2
    //Precondition: all names will be unique (only in names array once)
    //Post condition: return grade of associated name,
    //				  otherwise (if name not found) return -1
    //getGradeByName(String name)
    public double getGradeByName(String name) {
        double gradeByName = -1.0;
        for ( int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                if (grades[i] > 0) {
                     return grades[i];
                }
            }
        }
        return gradeByName;
    }

    //STEP 3
    //Precondition: names are unique (only in names array once)
    //setGradeByName(double grade, String name)
    public void setGradeByName(double grade, String name) {
        for ( int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                grades[i] = grade;
            }
        }
    }

    //STEP 4
    //return number of students with grades between (and including) 50 and maxGrade
    //Precondition: no grade will be greater than maxGrade,
    //				and maxGrade will be greater than or equal to 50
    //numBestGrades()
    public int numBestGrades() {
        int count = 0;
        for ( int i = 0; i < grades.length; i++) {
            if (grades[i] >= 50 && grades[i] <= maxGrade) {
                count++;
            }
        }
        return count;
    }

    //STEP 5
    //return a list of names of students with grades between (and including) 50 and maxGrade
    //Precondition: no grade will be greater than maxGrade,
    //				and maxGrade will be greater than or equal to 50
    //Hint: what methods have we written above to make this easier?
    //findBestStudents()
    public String[] findBestStudents() {
        String[] bestStudents = new String[numBestGrades()];
        int count = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 50 && grades[i] <= maxGrade) {
                bestStudents[count] = names[i];
                count++;
            }
        }
        return bestStudents;
    }
}

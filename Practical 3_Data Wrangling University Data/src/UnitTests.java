import java.util.Arrays;

/**
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class UnitTests {
    
    public static void runTests() {
        Logger.setDebug(true);
        
        testJson();
        testCSVReader();
        testDataLoading();
        
    }

    private static void testDataLoading() {
        UniversityData data = new UniversityData();
        data.loadData("CollegeData10sample.csv");
        Logger.debug("%s%n", data.toJson());
        data.saveData("testOut.json");  // use https://jsonlint.com/  to help make sure format is correct
    }

    private static void testCSVReader() {
        CSVReader reader = new CSVReader("test.csv");
        while(reader.hasNext()) {
            Logger.debug("%s%n", Arrays.toString(reader.getNext()));
        }

        Logger.debug("\n");
        Logger.debug("\n");
    }

    private static void testJson() {
        GenderCounter counter = new GenderCounter();
        Major studentAddition = new Major("test");
        counter.addCount("F");
        counter.addCount("F");
        counter.addCount("F");
        counter.addCount("M");
        counter.addCount("M");
        studentAddition.addStudent("M");
        studentAddition.addStudent("F");
        studentAddition.addStudent("M");
        Logger.debug("%s%n", counter.toJson());
        Logger.debug("%s%n", studentAddition.toJson());// use https://jsonlint.com/  to help make sure format is correct
        
        Major m1 = new Major("Astronomy");
        Major m2 = new Major("Basket Weaving");
        m1.addStudent("F");
        m2.addStudent("M");
        m2.addStudent("F");
        Logger.debug("%s%n", m1.toJson());
        Logger.debug("%s%n", m2.toJson());
        
        
        Department department = new Department("Frivolities");
        department.addStudent("Astronomy", "F");
        department.addStudent("Basket Weaving", "M");
        department.addStudent("Basket Weaving", "F");
        department.addStudent("Child Juggling", "F");
        department.addStudent("Child Juggling", "M");

        Logger.debug("%s%n", department.toJson());

        Logger.debug("\n");
        Logger.debug("\n");

        Department newMajor = new Department("test");
        newMajor.addStudent("New Major", "F");
        newMajor.addStudent("New Major2", "M");
        Logger.debug("%s%n", newMajor.getMajors());
    }

}

/**
 *
 * Main Program to use CarMain.java
 *
 * @author YOUR NAME <br> 
 *         YOUR EMAIL <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */

public class CarMain{
    public static void gettersTests() {
        Car vw = new Car(1969, "Volkswagon Beetle", 200000, 56.8);
        System.out.println("Running gettersTest:");
        System.out.println("getYear() \t Expecting: 1969\t Actual: " + vw.getYear());
        System.out.println("getModel() \t Expecting: Volkswagon Beetle\t Actual: " + vw.getModel());
        System.out.println("getMiles() \t Expecting: 200000\t Actual: " + vw.getMiles());
        System.out.println("getFuelTankLevel() \t Expecting: 56.8\t Actual: " + vw.getFuelTankLevel());
        //ADD TESTS HERE
        System.out.println();
        System.out.println();
    }

    public static void addMilesTests() {
        Car vw = new Car(1969, "Volkswagon Beetle", 200000, 56.8);
        System.out.println("Testing addMiles method: ");
        vw.addMiles(150);
        System.out.println("Input: 150 \t Expecting: 200150\t Actual: " + vw.getMiles());
        vw.addMiles(300);
        System.out.println("Input: 300 \t Expecting: 200450\t Actual: " + vw.getMiles());
        //ADD TESTS HERE
        System.out.println();
        System.out.println();

    }

    public static void isFuelTankEmptyTests() {
        Car vw = new Car(1969, "Volkswagon Beetle", 200000, 0);
        System.out.println("Testing isFuelTankEmpty method: ");
        System.out.println("Expecting: true\t Actual: " + vw.isFuelTankEmpty());
        Car bmw = new Car(1969, "BMW X5", 200, 56.8);
        System.out.println("Expecting: false\t Actual: " + bmw.isFuelTankEmpty());
        //ADD TESTS HERE
        System.out.println();
        System.out.println();
    }

    public static void milesToFuelLevelTests() {
        Car vw = new Car(1969, "Volkswagon Beetle", 200000, 0);
        System.out.println("Testing milesToFuelLevel method: ");
        System.out.println("Input: 300 \t Expecting: 75.0\t Actual: " + vw.milesToFuelLevel(300));
        System.out.println("Input: 155 \t Expecting: 38.75\t Actual: " + vw.milesToFuelLevel(155));
        //ADD TESTS HERE
        System.out.println();
        System.out.println();

    }

    public static void modifyFuelTankLevelTests() {
        Car vw = new Car(1969, "Volkswagon Beetle", 200000, 56);
        System.out.println("Testing modifyFuelTankLevel method: ");
        vw.modifyFuelTankLevel(150);
        System.out.println("Input: 150 \t Expecting: 18.5\t Actual: " + vw.getFuelTankLevel());
        //ADD TESTS HERE
        System.out.println();
        System.out.println();

    }

    public static void driveTests() {
        Car vw = new Car(1969, "Volkswagon Beetle", 200000, 100);
        System.out.println("Testing drive method: ");
        System.out.println("Input: 200\t Expecting: \"The 1969 Volkswagon Beetle drove 200 miles, for a total mileage of 200200 and a fuel tank level of 50.0%.\"\t Actual: " + '"' + vw.drive(200) +'"');
        Car bmw = new Car(1969, "BMW X5", 200, 0);
        System.out.println("Input: 200\t Expecting: \"The 1969 BMW X5's fuel tank is empty!\"\t Actual: " + '"' + bmw.drive(200) +'"');
        //ADD TESTS HERE
    }

    public static void main(String args[]) {

        gettersTests();
        addMilesTests();
        isFuelTankEmptyTests();
        milesToFuelLevelTests();
        modifyFuelTankLevelTests();
        driveTests();

    }
}
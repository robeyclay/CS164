/**
 *
 * Main Program to use Car.java
 *
 * @author YOUR NAME <br> 
 *         YOUR EMAIL <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */

public class Car {
    private int year;
    private String model;
    private int miles;
    private double fuelTankLevel;

    //Part 1
    //This is the Constructor
    public Car(int year, String model, int miles, double fuelTankLevel){
        //Student Code Here
        this.year = year;
        this.model = model;
        this.miles = miles;
        this.fuelTankLevel = fuelTankLevel;
    }

    //Part 2
    public int getYear(){
        //Student Code Here
        return this.year;
    }

    public String getModel(){
        //Student Code Here
        return this.model;
    }

    public int getMiles(){
        //Student Code Here
        return this.miles;
    }

    public double getFuelTankLevel() {
        //Student Code Here
        return this.fuelTankLevel;
    }

    //Part 3
    public void addMiles(int milesToAdd){
        //Student Code Here
        this.miles += milesToAdd;
    }

    //Part 4
    public boolean isFuelTankEmpty() {
        //Student Code Here
        return this.fuelTankLevel == 0;
    }

    //Part 5
    //Assume that a fuelTankLevel has a max capacity 400miles.
    //The fuel level is represented as a percentage. (i.e. 60.25%)
    public double milesToFuelLevel(int miles) {
        //Student Code Here
        return (miles / 400.0) * 100;
    }

    //Part 6
    public void modifyFuelTankLevel(int miles) {
        //Student Code Here

        if (!isFuelTankEmpty()) {
            if (fuelTankLevel - milesToFuelLevel(miles) > 0) {
                this.fuelTankLevel -= milesToFuelLevel(miles);
            }
            else {
                this.fuelTankLevel = 0;
            }
        }
        else {
            this.fuelTankLevel = 0;
        }
    }


    //Part 7
    public String drive(int miles) {
        if (!isFuelTankEmpty()) {
            if (fuelTankLevel - milesToFuelLevel(miles) > 0) {
                modifyFuelTankLevel(miles);
                addMiles(miles);
                return String.format("The %d %s drove %d miles, for a total mileage of %d and a fuel tank level of %.1f%%.", getYear(), getModel(), miles, getMiles(), getFuelTankLevel());
            }
            else
            {
                return String.format("The %d %s's fuel tank is empty", getYear(), getModel());
            }
        }
        else {
            return String.format("The %d %s's fuel tank is empty", getYear(), getModel());
        }

        //Student Code Here
    }

    //Easter Egg
    //toString is a more advanced topic and will be talked about later in the course.
    //It is put here to get familiar with the syntax. You wil NOT be graded on this.
    public String toString(){
        String output = "";
        output += "Model: " + model + '\n';
        output += "Year: " + year + '\n';
        output += "Miles: " + miles + '\n';
        output += "Fuel Tank Level: " + fuelTankLevel + "%\n";
        return output;
    }
}
/**
 * Inheritance lab for CS 1.
 *
 * In this lab you will be complete multiple classes using inheritance
 *
 * @author YOUR_NAME
 *         YOUR_EMAIL
 * @version 202010
 */

/*Complete the extends statement*/
public class Employee extends Person{
    //Create private class variables id (int) and hourlyPay (double)
    private int id;
    private double hourlyPay;
    /*constructor: (int id, double hourlyPay, String firstName, String lastName, int height)
    	Don't forget your call to super!
    */
    public Employee (int id, double hourlyPay, String firstName, String lastName, int height) {
        super(firstName, lastName, height);
        this.id = id;
        this.hourlyPay = hourlyPay;

    }

    /*Write Getters and Setters for both of the class variables.
    	getHourlyPay
    	getId
    	setHourlyPay
    	setId
    */

    public double getHourlyPay() {
        return hourlyPay;
    }

    public int getId() {
        return id;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*payDay(int hours): This method calculates how much the employee earned for the week.
    	First calculate their pay, if the employee worked more than 40 hours, then any hour OVER 40 is worth 1.5 times their normal pay,
    	this is considered overtime pay, otherwise their pay is as normal.

    	Return their total pay for the week (double).

    	Example: if I worked 45 hours this week, I would get 5 hours of overtime pay and 40 hours of normal pay.
    */

    public double payDay(int hoursWorked){
        //TODO
        double pay = 0;
        if (hoursWorked > 40) {
            pay += 40 * hourlyPay;
            pay += (hoursWorked - 40) * (hourlyPay * 1.5);
        } else {
            pay += hoursWorked * hourlyPay;
        }
        return pay;
    }

    /* getRaise: This method gives a raise to the user, increasing their pay by 15%.
     	Return the value of the employee's new hourlyPay (double)
    */

    public double getRaise(){
        hourlyPay *= 1.15;
        return hourlyPay;
    }

    //override the toString method
    public String toString(){
        String out = super.toString();
        out += String.format("They make $%.2f\n" +
                             "They have the employee ID %d\n", hourlyPay, id);
        return out;
    }

    //override the equals method
    public boolean equals(Object otherObject){
        boolean rtn = false;
        if (otherObject instanceof Employee) {
            Employee compareTo = (Employee) otherObject;
            if (compareTo.id == this.id && compareTo.getLastName().equals(getLastName())){
                rtn = true;
            }
            else {
                rtn = false;
            }
        }
        return rtn;
    }

}

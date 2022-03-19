import javax.swing.text.html.ObjectView;

/**
 * Abstract Classes lab for CS 1.
 *
 * In this lab you will be complete multiple classes using Abstract inheritance
 *
 * @author YOUR_NAME
 *         YOUR_EMAIL
 * @version 202010
 */

public class Triangle extends Shape {

    private double height;
    private double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
    @Override
    public double calculateArea() {
        return (base * height) / 2.0;
    }

    @Override
    public double calculateCircumference() {
        return (base * 3.0);
    }
    // You will be creating a class for an Equilateral Triangle
    // This triangle will need 2 double variables, height and base and getters and setter for both
    // You will also need a simple constructor that takes 2 doubles for height and base.

    // Complete the methods for calculateArea and Circumference
    // Both calculations can be found easily online, but you might have to be clever due to int division. 
}
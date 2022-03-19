/**
 * Abstract Classes lab for CS 1.
 *
 * In this lab you will be complete multiple classes using Abstract inheritance
 *
 * @author YOUR_NAME
 *         YOUR_EMAIL
 * @version 202010
 */

public class Circle extends Shape {

    private double radius;

    public Circle (double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return (Math.PI * Math.pow(radius, 2));
    }

    @Override
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }


    // Circle will need a single double for radius and a getter and setter for it
    // You will also need to define a simple constructor for the circle that takes a double for a radius

    // For calculateArea and calculateCircumference you should be able to find the formula online easilly
    // For the value of pie you will need to use the Math.PI.
}
/**
 * Abstract Classes lab for CS 1.
 *
 * In this lab you will be complete multiple classes using Abstract inheritance
 *
 * @author YOUR_NAME
 *         YOUR_EMAIL
 * @version 202010
 */

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
    @Override
    public double calculateArea(){
        return height * width;
    }
    @Override
    public double calculateCircumference() {
        return 2 * height + 2 * width;
    }

    // For Rectangles you will need 2 double variables height and width plus getters and setter for both
    // you will also need a simple constructor that takes two doubles, height and width.

    // For calculateArea and calculateCircumference you should be able to find the formula online easily
    // Remember this is a rectangle not a square, be careful when looking for formulas
}
public class Circle extends Shape {
    public double radius;

    public Circle(double radius, double X, double Y){
        this.radius = radius;
        this.setX(X);
        this.setY(Y);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateArea(){
        return (Math.PI * radius * radius);
    }
    public double calculateCircumference(){
        return (2 * Math.PI * radius);
    }
    public String toString() {
        return String.format("Circle with radius: %.2f, Centered at X: %.2f Y: %.2f%n",
                this.getRadius(), this.getX(), this.getY());
    }
}
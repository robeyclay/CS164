public class Rectangle extends Shape {
    public double height;
    public double width;

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(double height, double width, double X, double Y){
        this.height = height;
        this.width = width;
        this.setX(X);
        this.setY(Y);
    }
    public double calculateArea(){
        return (height*width);
    }
    public double calculateCircumference(){
        return (height*2) + (width*2);
    }
    public String toString() {
        return String.format("Rectangle with height: %.2f and width: %.2f, " +
                        "Centered at X: %.2f Y: %.2f%n",
                this.getHeight(), this.getWidth(), this.getX(), this.getY());
    }
}
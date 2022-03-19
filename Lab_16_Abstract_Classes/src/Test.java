
public class Test {

    public static void main(String[] args) {
        //Example of Testing
        Circle c = new Circle(12);
        System.out.println("Testing Circle Class");
        System.out.println("Circle Accessor, expecting: 12.0\tgot: " + c.getRadius());
        c.setRadius(10);
        System.out.println("Circle Mutator, expecting: 10.0\tgot: " + c.getRadius());
        System.out.println("Circle Area, expecting: 314.16\tgot: " + String.format("%.2f",c.calculateArea()));
        System.out.println("Circle Circumference, expecting: 62.83\tgot: " + String.format("%.2f",c.calculateCircumference()));


        Rectangle r = new Rectangle(10.0, 20.0);
        System.out.println("Testing Rectangle Class");
        System.out.println("Rectangle Height Accessor, expecting: 10.0\tgot: " + r.getHeight());
        r.setHeight(20);
        System.out.println("Rectangle Height Mutator, expecting: 20.0\tgot: " + r.getHeight());
        System.out.println("Rectangle Width Accessor, expecting: 20.0\tgot: " + r.getWidth());
        r.setWidth(10);
        System.out.println("Rectangle Width Mutator, expecting: 10.0\tgot: " + r.getWidth());
        System.out.println("Circle Area, expecting: 200.00\tgot: " + String.format("%.2f",r.calculateArea()));
        System.out.println("Circle Circumference, expecting: 60.00\tgot: " + String.format("%.2f",r.calculateCircumference()));


        Triangle t = new Triangle(10.0, 20.0);
        System.out.println("Testing Triangle Class");
        System.out.println("Triangle Height Accessor, expecting: 10.0\tgot: " + t.getHeight());
        t.setHeight(20);
        System.out.println("Rectangle Height Mutator, expecting: 20.0\tgot: " + t.getHeight());
        System.out.println("Rectangle Width Accessor, expecting: 20.0\tgot: " + t.getBase());
        t.setBase(10);
        System.out.println("Rectangle Width Mutator, expecting: 10.0\tgot: " + t.getBase());
        System.out.println("Circle Area, expecting: 100.00\tgot: " + String.format("%.2f",t.calculateArea()));
        System.out.println("Circle Circumference, expecting: 30.00\tgot: " + String.format("%.2f",t.calculateCircumference()));

    }

}

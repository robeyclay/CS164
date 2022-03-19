/**
 * Polymorphism lab for CS 1.
 *
 * In this lab you will be practicing with simple polymorphism
 *
 * @author YOUR_NAME
 *         YOUR_EMAIL
 * @version 202010
 */
import java.util.ArrayList;

public class PolymorphismPractice {
    public static void main(String[] args) {
        //Step 1 Initialize an Array list of type Shape
        ArrayList<Shape>  list = new ArrayList<Shape>();
        //Step 2 initialize the ArrayList with 5 circles and squares (10 total) with random X and Y values and random length width
        //Hint You can make this easier using a for loop, also try using Math.random()

        for (int i = 0; i < 5; i++) {
            double rand = Math.random() * 100;
            double rand1 = Math.random() * 100;
            double rand2 = Math.random() * 100;
            double rand3 = Math.random() * 100;
            Circle tempCircle = new Circle(rand, rand1, rand2);
            Rectangle tempRect = new Rectangle(rand, rand1, rand2, rand3);
            list.add(tempCircle);
            list.add(tempRect);
        }
        //Test your methods here!
        for (Shape checker : list) {
            System.out.println(checker);
        }
        System.out.println(list.size());
        System.out.println(getInfo(list));
        System.out.println(findCircles(list));

    }


    //Step 3 complete getInfo method as shown in instructions
    public static String getInfo(ArrayList<Shape> arr){
        StringBuilder string = new StringBuilder();
        for (Shape check : arr) {
            string.append(check.toString());
            String formatArea = String.format("Has area: %.2f%n", check.calculateArea());
            String formatCircum = String.format("Has circumference: %.2f%n", check.calculateCircumference());
            string.append(formatArea);
            string.append(formatCircum);
            string.append("\n");
            }
        return string.toString();
    }

    //Step 4 complete findCircles method as shown in instructions
    public static String findCircles(ArrayList<Shape> arr) {
        StringBuilder string = new StringBuilder();
        for (Shape check : arr) {
            if (check instanceof Circle) {
                string.append(check.toString());
                string.append("\n");
            }
        }
        return string.toString();
    }
}

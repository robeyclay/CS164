import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Order {
    /*
     * STEP 2: Declare two enums, types, and sizes, in each class.
     * Types should have the following possible values: HOT, ICED, BLENDED
     * Sizes should have the following possible values: SMALL, MEDIUM, LARGE
     */
    // STUDENT CODE HERE
    public enum types {HOT, ICED, BLENDED}
    public enum sizes {SMALL, MEDIUM, LARGE}

    Coffee[] drinks = new Coffee[10];
    int numDrinks = 0;
    String[] orderFlavors = new String[20];
    int numFlavors = 0;
    double totalPrice;

    /*
     * readOrder reads the drink orders from a file, given by the fileName as a string parameter.
     *
     * STEP 1: Declare a scanner that reads from a file named by the string parameter.
     * Then, use a while loop to loop through every line of the file, and create a Coffee object based on each line.
     *
     */
    public void readOrder(String fileName) {
        try {
            Scanner scnr = new Scanner(new File(fileName));
            while (scnr.hasNextLine()) {

                Coffee c = new Coffee(scnr.nextLine());

                // Declare scanner
                // while loop to loop through file
                // in while loop, create coffee object by passing the current line to the coffee constructor
                // include the following code in the while loop after creating the coffee object, then uncomment it
                drinks[numDrinks] = c;
                numDrinks++;

                for (String f : c.flavors) {
                    if (!containsFlavor(f) && !f.isEmpty()) {
                        orderFlavors[numFlavors] = f;
                        numFlavors++;
                    }
                }
            }

            scnr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // This method is a helper method used to determine whether or not the flavor is already in the order object's flavor array.
    public boolean containsFlavor(String flavor) {
        for (int i = 0; i < numFlavors; i++) {
            if (orderFlavors[i].compareTo(flavor) == 0) return true;
        }
        return false;
    }

    /*
     * Similar to a toString, this will return a string that gives the information about the order.
     * It includes:
     * 		a chart of the counts of each size and type of drink.
     * 		flavors needed for creating the drink
     * 		total price of all drinks in order
     *
     */

    public String orderInfo() {
        /* counts will store the number of each type/size of drink in a two dimensional array, like the following table format:
         * 			HOT		ICED	BLENDED
         * SMALL
         * MEDIUM
         * LARGE
         */
        int[][] counts = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        for (int i = 0; i < numDrinks; i++) {
            Coffee c = drinks[i];
            counts[c.getSizeIndex(c.size)][c.getTypeIndex(c.type)] += 1;
            totalPrice += c.price;
        }
        StringBuilder info = new StringBuilder();
        info.append(String.format("\tHot\tIced\tBlended\n"));
        info.append(String.format("Small\t%d\t%d\t%d\n", counts[0][0], counts[0][1], counts[0][2]));
        info.append(String.format("Medium\t%d\t%d\t%d\n", counts[1][0], counts[1][1], counts[1][2]));
        info.append(String.format("Large\t%d\t%d\t%d\n", counts[2][0], counts[2][1], counts[2][2]));
        info.append("Flavors: ");
        for (int i = 0; i < numFlavors; i++) {
            info.append(orderFlavors[i] + " ");
        }

        info.append(String.format("\nPrice: $%.2f", totalPrice));
        return info.toString();

    }

    public static void main(String[] args) {
        Order order1 = new Order();
        order1.readOrder("order1.txt");
        System.out.println(order1.orderInfo());
    }

}

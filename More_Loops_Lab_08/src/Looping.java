/**
 * Loops lab for CS 1.
 *
 * In this lab, you will write various methods that involve numbers to practice skills with loops.
 *
 * @author Clay_Roberson
 *         clayroby@colostate.edu
 * @version 202010
 */

import java.util.Random;
import java.util.Scanner;

public class Looping {
    public static void main(String[] args) {
        // call test methods here after completing each method
        //Looping.testAreaCode();
        //Looping.testMT();
        Looping.testBFES();
    }
    // STEP one - getAreaCode method
    public static int getAreaCode(String phoneNumber)
    {
        int index1 = phoneNumber.indexOf('-');
        if (phoneNumber.length() == 12) {
            String areaCode = phoneNumber.substring(0, index1);
            return Integer.parseInt(areaCode);
        } else {
            return 970;
        }
    }

    // STEP two
    public static String multiplicationTable(int rows, int columns) {
        // student code here
        String multiTable = "";
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                int multiple = i * j;
                multiTable += String.format("%s\t", multiple);
            }
            multiTable += "\n";
        }
        return multiTable; // this should be changed
    }

    // STEP three
    public static String bruteForceEquationSolver(int one, int two, int three, int constant) {
        // student code here
        for(int x = 1; x <= 10; x++) {
            for ( int y = 1; y <= 10; y++) {
                for (int z = 1; z <= 10; z++) {
                    if ((x * one) + (y * two) + (z * three) == constant) {
                        return "x: " + x + " y: " + y + " z: " + z;
                    }
                }
            }
        }
        return "Solution not found."; // this should be changed
    }

    public static void testBFES() {
        System.out.println("Testing Brute Force Equation Solver");
        String expected = "x: 2 y: 3 z: 4";
        System.out.println("Expecting: " + expected);

        String actual = bruteForceEquationSolver(3, 4, 6, 42);
        System.out.println("Actual: " + actual);

        boolean correct = expected.equals(actual);
        System.out.println("Outputs equal? " + correct);
    }

    public static void testMT() {
        System.out.println("Testing Multiplication Table");

        String expected = "1\t2\t3\t4\t\n2\t4\t6\t8\t\n3\t6\t9\t12\t\n";
        System.out.print("Expecting:\n" + expected);

        String actual = multiplicationTable(3, 4);
        System.out.print("Actual:\n" + actual);

        boolean correct = expected.equals(actual);
        System.out.println("Outputs equal? " + correct);
    }

    public static void testAreaCode() {
        System.out.println("Testing Get Area Code with area code given");
        int expected = 719;
        System.out.println("Expecting: " + expected);

        int actual = getAreaCode("719-133-2986");
        System.out.println("Actual: " + actual);

        boolean correct = expected == actual;
        System.out.println("Outputs equal? " + correct);
        System.out.println();
        System.out.println("Testing Get Area Code without area code");

        System.out.println("Testing Get Area Code");
        expected = 970;
        System.out.println("Expecting: " + expected);

        actual = getAreaCode("133-2986");
        System.out.println("Actual: " + actual);

        correct = expected == actual;
        System.out.println("Outputs equal? " + correct);
    }
}
/**
 * Passwords lab for CS 1.
 *
 * In this lab, you will write methods that will simulate account creation and passwords in order to practice working with classes and branching.
 *
 * @author Clay_Roberson
 *         clayroby@rams.colostate.edu
 * @version 202010
 */

import java.util.Random;
import java.util.Scanner;

public class Account {

    // STEP one: Declare the class variables and constructor here
    private String password;
    public String username;
    public boolean verified;

    public Account(String username, String password) {
        this.password = password;
        this.username = username;
        this.verified = false;
    }

    public String getPassword() {
        return password;
    }

    // STEP two - confirmAccount method
    public void confirmAccount(String confirmedPassword) {
        this.verified = this.password.equals(confirmedPassword);
    }


    // STEP three: check strength of password and modify if weak
    public String checkPasswordStrength() {
        Random rand = new Random();

        //student code here
        String passStrength = "";
        if (this.password.length() > 16) {
            passStrength = "Password strength: strong";
        } else if (this.password.length() > 8) {
            passStrength = "Password strength: moderate";
        } else {
            password = this.password.replace('a', '@');
            password = this.password.replace('o', '0');
            password = this.password.replace('s', '$');
            password = this.password.concat("" + rand.nextInt(10));
            passStrength = "Password weak, strengthening now.";
        }
        return passStrength; //  this line will need to be changed
    }

    // STEP four:
    public int corruptedData(String corrupted, char delimiter) {
        // student code here
        String keyOne = corrupted.substring(0, corrupted.indexOf(delimiter));
        String firstDelimiter = corrupted.substring(corrupted.indexOf(delimiter) + 1);
        String username = firstDelimiter.substring(0, firstDelimiter.indexOf(delimiter));
        String secondDelimiter = firstDelimiter.substring(firstDelimiter.indexOf(delimiter) + 1);
        String password = secondDelimiter.substring(0, secondDelimiter.indexOf(delimiter));
        String keyTwo = corrupted.substring(corrupted.lastIndexOf(delimiter) + 1);
        this.password = password;
        this.username = username;
        int key = Integer.parseInt(keyOne + keyTwo);
        return key; // this line will need to be changed
    }

    public static void testMethod() {
       Account acc1 = new Account("myUsername", "myPassword");
        acc1.confirmAccount("myPassword");
        System.out.println(acc1.checkPasswordStrength());
        System.out.println(acc1.printAccountInfo());
        System.out.println();

        Account acc2 = new Account("user2", "pass");
        System.out.println(acc2.checkPasswordStrength());
        System.out.println(acc2.printAccountInfo());

        Account acc3 = new Account("user3", "pass");
        System.out.println(acc3.corruptedData("1234!username!password!5678", '!'));
        System.out.println(acc3.printAccountInfo());

    }
    // this method is given to help test your code. It returns a string with the class variables for an object.
    public String printAccountInfo() {
        return String.format("Username: %s\nPassword: %s\nVerfied? %s", username, password, verified);
    }
    public static void main(String [] args) {
        testMethod();
    }

}
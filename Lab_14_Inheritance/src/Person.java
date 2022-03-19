/**
 * Inheritance lab for CS 1.
 *
 * In this lab you will be complete multiple classes using inheritance
 *
 * @author YOUR_NAME
 *         YOUR_EMAIL
 * @version 202010
 */


public class Person {
    private String firstName;
    private String lastName;
    private int height;

    public Person(String firstName, String lastName, int height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString(){
        String out = "Name: " + firstName + " " + lastName + "\n";
        out += "They are " + (height/12) + "\'"+(height%12)+"\"\n";
        return out;
    }

    public boolean equals(Object anotherObject){
        if(anotherObject instanceof Person){
            Person anotherPerson = (Person) anotherObject;
            return this.getFirstName().equals(anotherPerson.getFirstName()) &&
                    this.getLastName().equals(anotherPerson.getLastName());
        }
        return false;
    }
}

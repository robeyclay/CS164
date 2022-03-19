import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Roster {

    ArrayList<Person> people;

    public Roster(String filename) {
        people = new ArrayList<Person>();
        initializeListFromFile(filename);
    }

    public void initializeListFromFile(String filename) {
        try {
            Scanner scnr = new Scanner(new File(filename));
            String[] temp;
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                temp = line.split(" ");
                if (temp.length < 3) {
                    Person tempPerson = new Person(temp[0], temp[1]);
                    people.add(tempPerson);
                } else {
                    int tempInt = Integer.parseInt(temp[2]);
                    Student tempStudent = new Student(temp[0], temp[1], tempInt);
                    people.add(tempStudent);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File Not Found");
        }
    }

    public static void main(String [] args) {
        Roster r = new Roster("test");
        System.out.println(r.people);
    }

}
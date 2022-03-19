public class Person {
    String firstName;
    String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return "Person: " + firstName + " " + lastName;
    }

    public boolean equals(Object obj) {
        if (obj.equals(firstName) && obj.equals(lastName)) {
            return true;
        } else {
            return false;
        }
    }
}
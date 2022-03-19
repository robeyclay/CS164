public class Student extends Person {
    static int idNum;

    public Student(String firstName, String lastName, int id) {
        super(firstName, lastName);
        idNum = id;
    }

    @Override
    public String toString() {
        return super.toString() + " " + idNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.equals(idNum) && obj.equals(firstName) && obj.equals(lastName)) {
            return true;
        } else {
            return false;
        }
    }
}
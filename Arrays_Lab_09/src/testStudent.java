import java.util.Arrays;

public class testStudent {

    public static void main(String[] args) {
          StudentInfo student = new StudentInfo(100, 10);
          fillStudent(student);

        //Testing getName
          System.out.println("Expecting: Matthew\nYour answer: " + student.getName(2));
          System.out.println();

        //Testing setName
          student.setName(0, "John");
          System.out.println("Expecting: John\nYour answer: " + student.getName(0));
          System.out.println();

        //Testing getGrade
          System.out.println("Expecting: 2.0\nYour answer: " + student.getGrade(5));
          System.out.println();

        //Testing setGrade
          student.setGrade(8, 9.5);
          System.out.println("Expecting: 9.5\nYour answer: " + student.getGrade(8));
          System.out.println();

        //Testing getGradeByName
          System.out.println("Expecting: -1.0\nYour answer: " + student.getGradeByName("Audrey"));
          System.out.println();

        //Testing setGradeByName
          student.setGradeByName(44.7, "Audrey");
          System.out.println("Expecting: 44.7\nYour answer: " + student.getGrade(1));
          System.out.println();

        //Testing numBestGrades
          System.out.println("Expecting: 4\nyour answer: " + student.numBestGrades());
          System.out.println();

        //Testing findBestStudents
          System.out.println("Expecting: [John, Matthew, Isabella, Albert]\nYour answer: " + Arrays.toString(student.findBestStudents()));
    }

    public static void fillStudent(StudentInfo student) {
        String[] names = {"J. Doe", "Audrey", "Matthew", "Isabella", "Albert", "Sampson", "Cleopatra", "Henry", "Maggie", "Saddie"};
        double[] grades = {100.0, 23.4, 70.6, 80.9, 99.9, 2.0, 15.7, 49.9, 5.9, 20.7};

        for(int i = 0; i<names.length; i++) {
            student.setName(i, names[i]);
            student.setGrade(i, grades[i]);
        }
    }
}

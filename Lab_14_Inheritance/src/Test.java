
public class Test {

    public static void main(String[] args) {
        Employee e1 = new Employee (555, 101.0, "First1", "Last1", 80);
        Employee e2 = new Employee (000, 101.0, "First1", "Last1", 80);

        System.out.println("TESTING toString\n" + e1);
        System.out.println();
        System.out.printf("TESTING payDay - Expecting: 4797.50 Your answer: %.2f%n", e1.payDay(45));
        System.out.printf("TESTING getRaise - Expecting: 116.15 Your answer: %.2f%n", e1.getRaise());
        System.out.printf("TESTING getHourlyPay - Expecting: 116.15 Your answer: %.2f%n", e1.getHourlyPay());
        System.out.printf("TESTING equals - Expecting: true Your answer: %b%n", e1.equals(e2));

        /*WRITE YOUR OWN TESTS BELOW*/

    }

}

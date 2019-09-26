import java.util.function.Predicate;

public class TestTest {
    public static void main(String[] args) {
        Predicate<Integer> p1 = x -> x > 7;
        if (p1.test(9))
            System.out.println("Predicate x > 7 is true for x==9.");
        else
            System.out.println("Predicate x > 7 is false for x==9.");

        if (p1.test(3))
            System.out.println("Predicate x > 7 is true for x==3.");
        else
            System.out.println("Predicate x > 7 is false for x==3.");
    }
}

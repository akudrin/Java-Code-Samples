import java.util.function.Predicate;

public class PredicateMethods {

    public static void result(Predicate<Integer> p, Integer arg) {
        if (p.test(arg))
            System.out.println("The Predicate is true for " + arg);
        else
            System.out.println("The Predicate is false for " + arg);
    }

    public static void main(String[] args) {

        Predicate<Integer> p1 = x -> x == 5;
        result(p1,5);
        result(y -> y%2 == 0, 5);
    }
}

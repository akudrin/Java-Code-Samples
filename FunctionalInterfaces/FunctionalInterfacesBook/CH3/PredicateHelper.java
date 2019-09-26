import java.util.function.*;

public class PredicateHelper {

        public static <X> void result(Predicate<X> p, X arg)
        {
            if (p.test(arg))
                System.out.println("The Predicate is true for " + arg);
            else
                System.out.println("The Predicate is false for " + arg);
        }

}

class TestPredicateHelper
{
    public static void main(String[] args)
    {
        Predicate<Integer> p1 = x -> x > 2;
        Predicate<String> p2 = s -> s.charAt(0) == 'H';
        PredicateHelper.result(p1, 6);
        PredicateHelper.result(p2, "Hello");
        //PredicateHelper.result(x->x>4,"Hello"); //Error
    }
}
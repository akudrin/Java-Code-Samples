import java.util.function.*;
class PredicateMethodsMR
{
    public static boolean myTest(Integer x)
    { return (x > 7)? true : false; }

    public static void result(Predicate<Integer> p, Integer arg)
    {
        if (p.test(arg))
            System.out.println("The Predicate is true for " + arg);
        else
            System.out.println("The Predicate is false for " + arg);
    }
    public static void main(String[] args)
    {
        result(PredicateMethodsMR::myTest,5);
    }
}
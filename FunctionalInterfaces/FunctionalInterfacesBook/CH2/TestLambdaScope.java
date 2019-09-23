public class TestLambdaScope
{
    private static int myField = 2;
    public static void main(String[] args)
    {
        int myLocal = 7;
        //myLocal++; Error
        //local variables used in lambdas must be
        //final or effectively final
        FIVoid lambdaVoid = x -> System.out.println(
                                   x + myField + myLocal);
        
        lambdaVoid.method1(5);
    }
}


import java.util.function.Predicate;


public class TestOr {
    public static void main(String[] args) {
        //Chains Involving the OR Operation
        Predicate<Integer> p1 = x -> x > 7;
        PredicateHelper.result(p1.or(x -> x < 3), 9);
        PredicateHelper.result(p1.or(x -> x < 3), 2);
        PredicateHelper.result(p1.or(x -> x < 3), 5);

        //Chains Involving the AND Operation
        Predicate<Integer> p2 = x -> x > 7;
        PredicateHelper.result(p2.and(y -> y%2 ==1), 3);
        PredicateHelper.result(p2.and(y -> y%2 ==1), 4);
        PredicateHelper.result(p2.and(y -> y%2 ==1), 9);
        PredicateHelper.result(p2.and(y -> y%2 ==1), 10);

        //Chains Involving the ! Operation
        Predicate<Integer> p3 = x -> x > 7;
        System.out.println(p3.and(x -> x%2 == 1)
                .negate()
                .test(8) );
        System.out.println(p3.negate()
                .and(x -> x%2 == 1)
                .test(8) );

        //Using Predicate.isEqual
        Predicate<Integer> p4 = Predicate.isEqual(3);
        if (p4.test(3))
            System.out.println("The Predicate is true");

        Predicate<Integer> p5 = x -> x > 7;
        System.out.println (p5.or(Predicate.isEqual(3))
                .test(3));

        //Using Predicate.not [JAVA 11]
        Predicate<Integer> p6 = x -> x > 7;
        System.out.println(p6.and(Predicate.not(x -> x%2 == 1))
                .test(8) );

        //Overriding Predicate Default Methods
        Predicate<String> lengthGr4 = x -> x.length() > 4;
        Predicate<String> char0isA = x -> x.charAt(0) == 'a';
        System.out.println(lengthGr4.and(char0isA)
                .test("alpha"));

        try {
            System.out.println(lengthGr4.and(char0isA)
                    .test(null));
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }


        Predicate<String> nullProtectedLengthGr4 = new Predicate<String> () {
            @Override
            public boolean test(String x)
            {
                return x.length() > 4;
            }
            @Override
            public Predicate<String> and(Predicate<? super String> p)
            {
                return x -> x == null? false: test(x) && p.test(x);
            }
        };

        System.out.println(nullProtectedLengthGr4.and(char0isA)
                .test("alpha"));
        System.out.println(nullProtectedLengthGr4.and(char0isA)
                .test(null));


    }
}

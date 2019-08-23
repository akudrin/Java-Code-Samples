import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams16 {
    public static void main(String[] args) {
        Function<Integer, Integer> add2 = x -> x + 2;
        Function<Integer, Integer> mult3 = x -> x * 3;

        Function<Integer, Integer> mult3add2 = add2.compose(mult3);
        Function<Integer, Integer> add2mmult3 = add2.andThen(mult3);

        System.out.println("mult3add2(1): " + mult3add2.apply(1));
        System.out.println("add2mult3(1): " + add2mmult3.apply(1));


        Function<Integer, Integer> addTwo = x -> x + 2;
        Function<String, Integer> parseThenAdd2 = addTwo.compose(Integer::parseInt);
        System.out.println(parseThenAdd2.apply("1"));

        Function<Integer, Integer> addA = x -> x + 2;
        Function<Integer, String> plus2toString = addA.andThen(Object::toString);
        System.out.println(plus2toString.apply(1));

        Logger log = Logger.getLogger(Streams16.class.getName());
        Consumer<String> printer = System.out::println;
        Consumer<String> logger = log::info;
        Consumer<String> printThenLog = printer.andThen(logger);
        Stream.of("this", "is", "a", "stream", "of", "strings").forEach(printThenLog);

        IntPredicate triangular = Streams16::isTriangular;
        IntPredicate perfect = Streams16::isPerfect;
        IntPredicate both = triangular.and(perfect);

        IntStream.rangeClosed(1, 10_000)
                .filter(both)
                .forEach(System.out::println);


    }

    public static boolean isPerfect(int x) {
        return Math.sqrt(x) % 1 == 0;
    }
    public static boolean isTriangular(int x) {
        double val = (Math.sqrt(8 * x + 1) - 1) / 2;
        return val % 1 == 0;
    }
}

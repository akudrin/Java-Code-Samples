import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class Optionals2 {
    public static void main(String[] args) {
        Optional<String> firstEven =
                Stream.of("five", "even", "length", "string", "values")
                        .filter(s -> s.length() % 2 == 0)
                        .findFirst();
        System.out.println(
                firstEven.isPresent() ? firstEven.get() : "No even length strings");


        Optional<String> firstOdd =
                Stream.of("five", "even", "length", "string", "values")
                        .filter(s -> s.length() % 2 != 0)
                        .findFirst();
        System.out.println(firstOdd.orElse("No odd length strings"));

        Optional<String> firstA =
                Stream.of("five", "even", "length", "string", "values")
                        .filter(s -> s.length() % 2 == 0)
                        .findFirst();
        System.out.println(firstA.orElseThrow(NoSuchElementException::new));

        Optional<String> firstB =
                Stream.of("five", "even", "length", "string", "values")
                        .filter(s -> s.length() % 2 == 0)
                        .findFirst();
        firstB.ifPresent(val -> System.out.println("Found an even-length string"));

        firstB = Stream.of("five", "even", "length", "string", "values")
                .filter(s -> s.length() % 2 != 0)
                .findFirst();
        firstB.ifPresent(val -> System.out.println("Found an odd-length string"));

    }
}

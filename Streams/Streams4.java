import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams4 {
    public static void main(String[] args) {
        sumDoublesDivisibleBy3V3(100,200);
    }

    public static int sumDoublesDivisibleBy3V1(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .map(n -> n * 2)
                .filter(n -> n % 3 == 0)
                .sum();
    }

    public static int sumDoublesDivisibleBy3V2(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .map(n -> {
                    System.out.println(n);
                    return n;
                })
                .map(n -> n * 2)
                .filter(n -> n % 3 == 0)
                .sum();
    }

    //Using multiple peek methods
    public static int sumDoublesDivisibleBy3V3(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .peek(n -> System.out.printf("original: %d%n", n))
                .map(n -> n * 2)
                .peek(n -> System.out.printf("doubled : %d%n", n))
                .filter(n -> n % 3 == 0)
                .peek(n -> System.out.printf("filtered: %d%n", n))
                .sum();
    }
}

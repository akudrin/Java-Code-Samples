import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams8 {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(7));
        System.out.println();

        IntStream.range(2, 3).peek(System.out::println).forEach((x)->System.out.println(x));

        Streams8 calculator = new Streams8();

        IntStream.of(2, 3, 5, 7, 11, 13, 17, 19)
                .allMatch(calculator::isPrime);

        Stream.of(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20)
                .anyMatch(calculator::isPrime);

    }

    public boolean isPrime(int num) {
        int limit = (int) (Math.sqrt(num) + 1);
        return num == 2 || num > 1 && IntStream.range(2, limit)
                .noneMatch(divisor -> num % divisor == 0);
    }
}

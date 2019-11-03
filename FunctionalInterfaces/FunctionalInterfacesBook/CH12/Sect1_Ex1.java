import java.util.Random;
import java.util.stream.Stream;

public class Sect1_Ex1 {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4);

        Stream<Integer> tenRandomNumbers =
                Stream.generate( () -> (new Random()).nextInt(100))
                        .limit(10);
    }
}

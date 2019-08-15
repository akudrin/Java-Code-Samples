import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Streams11 {
    public static void main(String[] args) {
        OptionalInt firstEvenDoubleDivBy3 = IntStream.range(100, 200)
                .map(n -> n * 2)
                .filter(n -> n % 3 == 0)
                .findFirst();
        System.out.println(firstEvenDoubleDivBy3);

        firstEvenDoubleDivBy3 = IntStream.range(100, 200)
                .map(new Streams11()::multByTwo)
                .filter(new Streams11()::divByThree)
                .findFirst();
    }

    public int multByTwo(int n) {
        System.out.printf("Inside multByTwo with arg %d%n", n);
        return n * 2;
    }
    public boolean divByThree(int n) {
        System.out.printf("Inside divByThree with arg %d%n", n);
        return n % 3 == 0;
    }
}

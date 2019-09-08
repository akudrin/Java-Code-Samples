import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

public class ParallelismConcurrency2 {
    public static void main(String[] args) {

        Instant beforeA = Instant.now();
       int  totalA = IntStream.of(3, 1, 4, 1, 5, 9)
                .map(ParallelismConcurrency2::doubleIt)
                .sum();
        Instant afterA = Instant.now();
        Duration durationA = Duration.between(beforeA, afterA);
        System.out.println("Total of doubles = " + totalA);
        System.out.println("time = " + durationA.toMillis() + " ms");

        Instant beforeB = Instant.now();
        int  totalB = IntStream.of(3, 1, 4, 1, 5, 9)
                .parallel()
                .map(ParallelismConcurrency2::doubleIt)
                .sum();
        Instant afterB = Instant.now();
        Duration durationB = Duration.between(beforeB, afterA);
        System.out.println("Total of doubles = " + totalB);
        System.out.println("time = " + durationB.toMillis() + " ms");

    }

    public static int doubleIt(int n) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignore) {
        }
        return n * 2;
        }
}

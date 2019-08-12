import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Streams7 {
    public static void main(String[] args) {
        DoubleSummaryStatistics stats = DoubleStream.generate(Math::random)
                .limit(1_000_000)
                .summaryStatistics();

        System.out.println(stats);

        System.out.println("count: " + stats.getCount());
        System.out.println("min : " + stats.getMin());
        System.out.println("max : " + stats.getMax());
        System.out.println("sum : " + stats.getSum());
        System.out.println("ave : " + stats.getAverage());

        Optional<Integer> firstEven = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .filter(n -> n % 2 == 0).findFirst();
        System.out.println(firstEven);

        Optional<Integer> firstEvenGT10 = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .filter(n -> n > 10)
                .filter(n -> n % 2 == 0)
                .findFirst();
        System.out.println(firstEvenGT10);

        Optional<Integer> any = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .unordered()
                .map(new Streams7()::delay)
                .findAny();
        System.out.println("Sequential Any: " + any);

        any = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .unordered()
                .parallel()
                .map(new Streams7()::delay)
                .findAny();
        System.out.println("Parallel Any: " + any);

        Optional<Integer> any1 = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .unordered()
                .map(new Streams7()::delay)
                .findAny();
        System.out.println("Sequential Any: " + any);
        any1 = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .unordered()
                .parallel()
                .map(new Streams7()::delay)
                .findAny();
        System.out.println("Parallel Any: " + any);

    }

    public Integer delay(Integer n) {
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException ignored) {
        }
        return n;
    }


}

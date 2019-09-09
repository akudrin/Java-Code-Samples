import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelismConcurrency3 {

    int N = 10000000;

    public static void main(String[] args) {

    }

    public long iterativeSum() {
        long result = 0;
        for (long i = 1L; i <= N; i++) {
            result += i;
        }
        return result;
    }

    public long sequentialStreamSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .reduce(0L, Long::sum);
    }
    public long parallelStreamSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public long sequentialLongStreamSum() {
        return LongStream.rangeClosed(1, N)
                .sum();
    }
    public long parallelLongStreamSum() {
        return LongStream.rangeClosed(1, N)
                .parallel()
                .sum();
    }

}

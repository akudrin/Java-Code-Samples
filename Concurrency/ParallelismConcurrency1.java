import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelismConcurrency1 {
    public static void main(String[] args) {
        Stream.of(3, 1, 4, 1, 5, 9).isParallel();
        Stream.iterate(1, n -> n + 1).isParallel();

        Stream.generate(Math::random).isParallel();
        List<Integer> numbersA = Arrays.asList(3, 1, 4, 1, 5, 9);
       numbersA.stream().isParallel();

        List<Integer> numbersB = Arrays.asList(3, 1, 4, 1, 5, 9);
        numbersB.parallelStream().isParallel();

        Stream.of(3, 1, 4, 1, 5, 9)
                .parallel()
                .isParallel();

        List<Integer> numbersC = Arrays.asList(3, 1, 4, 1, 5, 9);
        numbersC.parallelStream()
                .sequential()
                .isParallel();


        List<Integer> numbersD = Arrays.asList(3, 1, 4, 1, 5, 9);
        List<Integer> nums = numbersD.parallelStream()
                .map(n -> n * 2)
                .peek(n -> System.out.printf("%s processing %d%n",
                        Thread.currentThread().getName(), n))
                .sequential()
                .sorted()
                .collect(Collectors.toList());

        

    }
}

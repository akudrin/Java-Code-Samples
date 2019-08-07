/*
• Stream.of(T... values) and Stream.of(T t)
• Arrays.stream(T[] array), with overloads for int[], double[], and long[]
• Stream.iterate(T seed, UnaryOperator<T> f)
• Stream.generate(Supplier<T> s)
• Collection.stream()
• Using range and rangeClosed:
—IntStream.range(int startInclusive, int endExclusive)
—IntStream.rangeClosed(int startInclusive, int endInclusive)
—LongStream.range(long startInclusive, long endExclusive)
—LongStream.rangeClosed(long startInclusive, long endInclusive)
 */

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams1 {
    public static void main(String[] args) {

        //Stream.of
        String names = Stream.of("Gomez", "Morticia", "Wednesday", "Pugsley")
                .collect(Collectors.joining(","));
        System.out.println(names);

        String[] munsters = { "Herman", "Lily", "Eddie", "Marilyn", "Grandpa" };
        names = Arrays.stream(munsters)
                .collect(Collectors.joining(","));
        System.out.println(names);

        //Stream.iterate
        List<BigDecimal> nums =
                Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE) )
                        .limit(10)
                        .collect(Collectors.toList());
        System.out.println(nums);

        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1L))
                .limit(10)
                .forEach(System.out::println);

        //Stream.generate
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        //IntStream and LongStream range() and rangeClosed()
        List<Integer> ints = IntStream.range(10, 15)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);
        // prints [10, 11, 12, 13, 14]
        List<Long> longs = LongStream.rangeClosed(10, 15)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(longs);
    }
}


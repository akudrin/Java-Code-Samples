
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class Streams19 {
    public static void main(String[] args) {

        Random randomA = new Random();
        List<Integer> numsA = randomA.ints(50, 0, 100)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .takeWhile(n -> n > 90)
                .collect(Collectors.toList());

        Random randomB = new Random();
        List<Integer> numsB = randomB.ints(50, 0, 100)
                .sorted()
                .dropWhile(n -> n < 90)
                .boxed()
                .collect(Collectors.toList());

    }

    @Test
    public void ofNullable() throws Exception {
        Stream<String> stream = Stream.ofNullable("abc");
        assertEquals(1, stream.count());
        stream = Stream.ofNullable(null);
        assertEquals(0, stream.count());
    }

    @Test
    public void iterate() throws Exception {
        List<BigDecimal> bigDecimals =
                Stream.iterate(BigDecimal.ZERO, bd -> bd.add(BigDecimal.ONE))
                        .limit(10)
                        .collect(Collectors.toList());
        assertEquals(10, bigDecimals.size());
        bigDecimals = Stream.iterate(BigDecimal.ZERO,
                bd -> bd.longValue() < 10L,
                bd -> bd.add(BigDecimal.ONE))
                .collect(Collectors.toList());
        assertEquals(10, bigDecimals.size());
    }

    @Test
    public void takeWhile() throws Exception {
        List<String> strings = Stream.of("this is a list of strings".split(" "))
                .takeWhile(s -> !s.equals("of"))
                .collect(Collectors.toList());
        List<String> correct = Arrays.asList("this", "is", "a", "list");
        assertEquals(correct, strings);
    }
    @Test
    public void dropWhile() throws Exception {
        List<String> strings = Stream.of("this is a list of strings".split(" "))
                .dropWhile(s -> !s.equals("of"))
                .collect(Collectors.toList());
        List<String> correct = Arrays.asList("of", "strings");
        assertEquals(correct, strings);
    }
}

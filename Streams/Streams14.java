import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Streams14 {

    private Map<Long, BigInteger> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fibA(7));

        String passage = "NSA agent walks into a bar. Bartender says, " +
                "'Hey, I have a new joke for you.' Agent says, 'heard it'.";
        Map<String, Integer> counts = countWords(passage, "NSA", "agent", "joke");
        counts.forEach((word, count) -> System.out.println(word + "=" + count));

    }

    //recursive
    static long fibA(long i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fibA(i - 1) + fibA(i - 2);
    }


    public BigInteger fibB(long i) {
        if (i == 0) return BigInteger.ZERO;
        if (i == 1) return BigInteger.ONE;
        return cache.computeIfAbsent(i, n -> fibB(n - 2).add(fibB(n - 1)));
    }

    public static Map<String, Integer> countWords(String passage, String... strings) {
        Map<String, Integer> wordCounts = new HashMap<>();
        Arrays.stream(strings).forEach(s -> wordCounts.put(s, 0));
        Arrays.stream(passage.split(" ")).forEach(word ->
                wordCounts.computeIfPresent(word, (key, val) -> val + 1));
        return wordCounts;
    }

    public static Map<String, Integer> fullWordCounts(String passage) {
        Map<String, Integer> wordCounts = new HashMap<>();
        String testString = passage.toLowerCase().replaceAll("\\W"," ");
        Arrays.stream(testString.split("\\s+")).forEach(word ->
                wordCounts.merge(word, 1, Integer::sum));
        return wordCounts;
    }
}

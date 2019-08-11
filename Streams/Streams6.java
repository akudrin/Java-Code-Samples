import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams6 {
    public static void main(String[] args) {

        long count = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5).count();
        System.out.printf("There are %d elements in the stream%n", count);
        count = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .collect(Collectors.counting());
        System.out.printf("There are %d elements in the stream%n", count);

        List<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("abcd");
        strings.add("ab");
        Map<Boolean, Long> numberLengthMap = strings.stream()
                .collect(Collectors.partitioningBy(
                        s -> s.length() % 2 == 0,
                        Collectors.counting()));
        numberLengthMap.forEach((k,v) -> System.out.printf("%5s: %d%n", k, v));
    }
}

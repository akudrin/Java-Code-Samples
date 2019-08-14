import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams10 {
    public static void main(String[] args) {
        Stream<String> first = Stream.of("a", "b", "c").parallel();
        Stream<String> second = Stream.of("X", "Y", "Z");
        List<String> strings = Stream.concat(first, second)
                .collect(Collectors.toList());
        List<String> stringList = Arrays.asList("a", "b", "c", "X", "Y", "Z");

        System.out.println(strings.equals(stringList));

        Stream<String> firstA = Stream.of("a", "b", "c").parallel();
        Stream<String> secondA = Stream.of("X", "Y", "Z");
        Stream<String> thirdA = Stream.of("alpha", "beta", "gamma");
        Stream<String> fourthA = Stream.empty();
        List<String> stringsA = Stream.of(firstA, secondA, thirdA, fourthA)
                .reduce(Stream.empty(), Stream::concat).collect(Collectors.toList());


        Stream<String> firstB = Stream.of("a", "b", "c").parallel();
        Stream<String> secondB = Stream.of("X", "Y", "Z");
        Stream<String> thirdB = Stream.of("alpha", "beta", "gamma");
        Stream<String> totalB = Stream.concat(Stream.concat(firstB, secondB), thirdB);
        System.out.println(totalB.isParallel());

        Stream<String> firstC = Stream.of("a", "b", "c").parallel();
        Stream<String> secondC = Stream.of("X", "Y", "Z");
        Stream<String> thirdC = Stream.of("alpha", "beta", "gamma");
        Stream<String> fourthC = Stream.empty();
        Stream<String> totalC = Stream.of(firstC, secondC, thirdC, fourthC)
                .flatMap(Function.identity());
        System.out.println(totalC.isParallel());

        //we can always make the stream parallel if you want by calling the parallel method
        totalC = totalC.parallel();

        System.out.println(totalC.isParallel());

    }

}

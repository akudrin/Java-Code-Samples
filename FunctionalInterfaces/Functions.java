import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Functions {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoë", "Jayne", "Simon", "River", "Shepherd Book");

        //Anonymous inner class
        List<Integer> nameLengths = names.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                })
                .collect(Collectors.toList());
        //Lambda
        nameLengths = names.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());

        //Method reference
        nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.printf("nameLengths = %s%n", nameLengths);
        // nameLengths == [3, 4, 6, 5, 3, 5, 5, 5, 13]
    }
}
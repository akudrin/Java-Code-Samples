import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collections3 {
    public static void main(String[] args) {
        System.out.println("\nNumber of words of each length:");
        Path dictionary = Paths.get("/usr/share/dict/words");
        try (Stream<String> lines = Files.lines(dictionary)) {
            lines.filter(s -> s.length() > 20)
                    .collect(Collectors.groupingBy(
                            String::length, Collectors.counting()))
                    .forEach((len, num) -> System.out.printf("%d: %d%n", len, num));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nNumber of words of each length (desc order):");
        try (Stream<String> lines = Files.lines(dictionary)) {
            Map<Integer, Long> map = lines.filter(s -> s.length() > 20)
                    .collect(Collectors.groupingBy(
                            String::length, Collectors.counting()));
            map.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .forEach(e -> System.out.printf("Length %d: %2d words%n",
                            e.getKey(), e.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

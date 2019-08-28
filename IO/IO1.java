import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IO1 {
    public static void main(String[] args) {
        //Finding the 10 longest words in the web2 dictionary
        try (Stream<String> linesA = Files.lines(Paths.get("/usr/share/dict/web2"))) {
            linesA.filter(s -> s.length() > 20)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .limit(10)
                    .forEach(w -> System.out.printf("%s (%d)%n", w, w.length()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Determining number of words of each length
        try (Stream<String> linesB = Files.lines(Paths.get("/usr/share/dict/web2"))) {
            linesB.filter(s -> s.length() > 20)
                    .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                    .forEach((len, num) -> System.out.println(len + ": " + num));
         } catch (IOException e) {
        e.printStackTrace();
    }

        //Number of words of each length, in descending order (for files)
        try (Stream<String> linesC = Files.lines(Paths.get("/usr/share/dict/web2"))) {
            Map<Integer, Long> map = linesC.filter(s -> s.length() > 20)
                    .collect(Collectors.groupingBy(String::length, Collectors.counting()));
            map.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .forEach(e -> System.out.printf("Length %d: %d words%n",
                            e.getKey(), e.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Using BufferedReader.lines method
        try (Stream<String> linesD =
                     new BufferedReader(
                             new FileReader("/usr/share/dict/words")).lines()) {
            Map<Integer, Long> map = linesD.filter(s -> s.length() > 20)
                    .collect(Collectors.groupingBy(String::length, Collectors.counting()));
            map.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .forEach(e -> System.out.printf("Length %d: %d words%n",
                            e.getKey(), e.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

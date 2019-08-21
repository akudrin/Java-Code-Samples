import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Streams12 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "this", null, "is", "a", null, "list", "of", "strings", null);
        List<String> nonNullStrings = strings.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9);
        int total = 0;
        for (int n : nums) {
            total += n;
        }

        total = 0;
        //nums.forEach(n -> total += n);
        total = nums.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}

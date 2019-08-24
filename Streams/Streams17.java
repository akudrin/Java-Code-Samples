import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams17 {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(30, 10, 40, 10, 50, 90);
        List<Integer> scaled = new Streams17().div(values, 10);
        System.out.println(scaled);
        // prints: [3, 1, 4, 1, 5, 9]
        scaled = new Streams17().div(values, 0);
        System.out.println(scaled);
        // throws ArithmeticException: / by zero

    }

    public List<Integer> div(List<Integer> values, Integer factor) {
        return values.stream()
                .map(n -> n / factor)
                .collect(Collectors.toList());
    }

    public List<Integer> divWithException(List<Integer> values, Integer factor) {
        return values.stream()
                .map( n -> {
                    try {
                        return n / factor;
                    } catch (ArithmeticException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());

    }

    private Integer divide(Integer value, Integer factor) {
        try {
            return value / factor;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return value;
    }

    public List<Integer> divUsingMethod(List<Integer> values, Integer factor) {
        return values.stream()
                .map(n -> divide(n, factor))
                .collect(Collectors.toList());
    }



}

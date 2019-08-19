import java.util.*;
import java.util.stream.Collectors;

public class Collections7 {
    public static void main(String[] args) {

        Map<String, Integer> map = Collections.unmodifiableMap(
                new HashMap<String, Integer>() {{
                    put("have", 1);
                    put("the", 2);
                    put("high", 3);
                    put("ground", 4);
                }});

    }


    public final <T> List<T> createImmutableList(T... elements) {
        return Arrays.stream(elements)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }
    
    public final <T> Set<T> createImmutableSet(T... elements) {
        return Arrays.stream(elements)
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        Collections::unmodifiableSet));
    }
}

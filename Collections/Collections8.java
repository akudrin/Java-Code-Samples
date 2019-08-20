import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Collections8 {
    public static void main(String[] args) {

    }

    public SortedSet<String> oddLengthStringSet(String... strings) {
        Collector<String, ?, SortedSet<String>> intoSet =
                Collector.of(TreeSet<String>::new,
                        SortedSet::add,
                        (left, right) -> {
                            left.addAll(right);
                            return left;
                        },
                        Collections::unmodifiableSortedSet);
        return Stream.of(strings)
                .filter(s -> s.length() % 2 != 0)
                .collect(intoSet);
    }
}

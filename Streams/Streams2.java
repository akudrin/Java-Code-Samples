import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams2 {
    public static void main(String[] args) {

        //Converts int to Integer
        List<Integer> ints1 = IntStream.of(3, 1, 4, 1, 5, 9)
                .boxed()
                .collect(Collectors.toList());
        //mapToObj method
        List<Integer> ints2 = IntStream.of(3, 1, 4, 1, 5, 9)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());

        //three-argument version of collect
        List<Integer> ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);

        //Convert an IntStream to an int array
        int[] intArray1 = IntStream.of(3, 1, 4, 1, 5, 9).toArray();


    }
}

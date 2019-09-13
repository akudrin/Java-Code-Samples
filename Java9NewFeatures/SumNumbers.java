import java.util.function.IntPredicate;
import java.util.stream.IntStream;
public interface SumNumbers {
    default int addEvens(int... nums) {
        return add(n -> n % 2 == 0, nums);
    }
    default int addOdds(int... nums) {
        return add(n -> n % 2 != 0, nums);
    }
    private int add(IntPredicate predicate, int... nums) {
        return IntStream.of(nums)
                .filter(predicate)
                .sum();
    }
}

class PrivateDemo implements SumNumbers {

    public static void main(String[] args) {
        SumNumbers demo = new PrivateDemo();
        //Invoking public methods that delegate to the private method
        demo.addEvens(1, 2, 3, 4, 5, 6);
        demo.addOdds(1, 2, 3, 4, 5, 6);
    }
}
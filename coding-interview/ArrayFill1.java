import java.util.Arrays;

public class ArrayFill1 {
    public static void main(String[] args) {
        int[] intArray = new int[10];

        Arrays.fill(intArray, 123);

        System.out.println(Arrays.toString(intArray));

        Arrays.fill(intArray, 3, 5, 0);

        System.out.println(Arrays.toString(intArray));
    }

}

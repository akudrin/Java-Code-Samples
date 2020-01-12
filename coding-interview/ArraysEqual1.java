import java.util.Arrays;

public class ArraysEqual1 {
    public static void main(String[] args) {
        int[] ints1 = {0,2,4,6,8,10};
        int[] ints2 = {0,2,4,6,8,10};
        int[] ints3 = {10,8,6,4,2,0};

        boolean ints1EqualsInts2 = Arrays.equals(ints1, ints2);
        boolean ints1EqualsInts3 = Arrays.equals(ints1, ints3);

        System.out.println(ints1EqualsInts2);
        System.out.println(ints1EqualsInts3);
    }
}

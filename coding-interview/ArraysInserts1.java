import java.util.Arrays;

public class ArraysInserts1 {
    public static void main(String[] args) {
        int[] ints1   = { 0, 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19 };
        System.out.println(Arrays.toString(ints1));
        int[] ints   = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20 };
        int insertIndex = 10;
        int newValue    = 123;
        //move elements below insertion point.
        for(int i=ints.length-1; i > insertIndex; i--){
            ints[i] = ints[i-1];
        }
        //insert new value
        ints[insertIndex] = newValue;
        System.out.println(Arrays.toString(ints));

        System.out.println("*****************************");
        System.out.println(Arrays.toString(ints1));
        int[] ints2   = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20 };
        int removeIndex = 10;

        for(int i = removeIndex; i < ints2.length -1; i++){
            ints2[i] = ints2[i + 1];
        }
        System.out.println(Arrays.toString(ints2));
    }
}

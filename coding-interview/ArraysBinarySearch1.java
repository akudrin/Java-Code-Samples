import java.util.Arrays;

public class ArraysBinarySearch1 {
    public static void main(String[] args) {
        //The array must first be sorted
        int[] ints = {0,2,4,6,8,10};
        int indexA = Arrays.binarySearch(ints, 6);
        System.out.println(indexA);

        //If no element is found with the given value, a negative number will be returned.
        int indexB = Arrays.binarySearch(ints, 7);
        System.out.println(indexB);

        //If all elements in the array are smaller than t
        // he sought value, then binarySearch() will return - length of the array - 1.

        int indexC = Arrays.binarySearch(ints, 12);
        System.out.println(indexC);

        //The following example searches the array for the value 2 but only between index 0 and 4 (without 4).
        int indexD = Arrays.binarySearch(ints, 0, 4, 2);
        System.out.println(indexD);

        //if all values in the interval are smaller than the sought value, binarySearch()
        // will return -toIndex -1 , and not -array length - 1.
        int indexE = Arrays.binarySearch(ints, 0, 4, 12);
        System.out.println(indexE);
    }
}

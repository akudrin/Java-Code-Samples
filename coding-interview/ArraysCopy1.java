import java.util.Arrays;

public class ArraysCopy1 {
    public static void main(String[] args) {
        //Copying an Array by Iterating the Array
        int[] source = new int[10];
        int[] dest   = new int[10];
        for(int i=0; i < source.length; i++) {
            source[i] = i;
        }
        for(int i=0; i < source.length; i++) {
            dest[i] = source[i];
        }

        //Copying an Array Using Arrays.copyOf()
        int[] sourceA = new int[10];
        for(int i=0; i < sourceA.length; i++) {
            sourceA[i] = i;
        }
        int[] destA = Arrays.copyOf(sourceA, sourceA.length);

        //Copying an Array Using Arrays.copyOfRange()
        int[] sourceB = new int[10];
        for(int i=0; i < sourceB.length; i++) {
            sourceB[i] = i;
        }
        int[] destB = Arrays.copyOfRange(sourceB, 0, sourceB.length);

    }
}

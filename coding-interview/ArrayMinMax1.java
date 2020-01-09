public class ArrayMinMax1 {
    public static void main(String[] args) {
        int[] ints = {0,2,4,6,8,10};
        findMax(ints);
        findMin(ints);
        System.out.println(0>Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static void findMax (int[] ints) {
        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i < ints.length; i++){
            if(ints[i] > maxVal){
                maxVal = ints[i];
            }
        }
        System.out.println("maxVal = " + maxVal);
    }

    public static void findMin(int[] ints) {
        int minVal = Integer.MAX_VALUE;

        for(int i=0; i < ints.length; i++){
            if(ints[i] < minVal){
                minVal = ints[i];
            }
        }
        System.out.println("minVal = " + minVal);

    }
}

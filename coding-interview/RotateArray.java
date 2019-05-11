public class RotateArray {

    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotate(arr,8);

    }
    //Space is O(n) and time is O(n).
    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        if (k > nums.length)
            k = k % nums.length;
        int[] result = new int[nums.length];
        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }
        int j = 0;
        for (int i = k; i < nums.length; i++) {
            result[i] = nums[j];
            j++;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
        
        String newLine = System.getProperty("line.separator");
        System.out.println(newLine);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

}
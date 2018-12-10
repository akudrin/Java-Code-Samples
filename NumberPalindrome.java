public class NumberPalindrome {

    public static boolean isPalindrome(int number) {
        int r, sum = 0, temp;
        int n = Math.abs(number);//It is the number variable to be checked for palindrome  

        temp = n;
        while (n > 0) {
            r = n % 10;  //getting remainder  
            sum = (sum * 10) + r;
            n = n / 10;
        }
        if (temp == sum) {
            return true;
        } else {
            return false;
        }
    }

}

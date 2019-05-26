public class StringExample3 {

    public static void main(String[] args) {

        String one = "1";
        String two = "2";
        int result1 = Integer.valueOf(one) + Integer.valueOf(two);
        System.out.println(result1);
        int result2 = Integer.parseInt(one) + Integer.parseInt(two);
        System.out.println(result2);
        // One of the biggest differences between parseInt() and valueOf() is that
        // parseInt() returns an int and
        // valueOf() returns an Integer from the cache.

        String str = "Break down into chars";
        System.out.println(str);
        for (char chr : str.toCharArray()) {
            System.out.println(chr);
        }

        for (int x = 0; x <= str.length() - 1; x++) {
            System.out.println(str.charAt(x));
        }

    }
}
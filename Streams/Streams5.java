public class Streams5 {
    public static void main(String[] args) {
        System.out.println(isPalindromeNonFunctional("madam"));
        System.out.println(isPalindromeFunctional("Madam, in Eden, I'm Adam"));

    }

    public static boolean isPalindromeNonFunctional(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String forward = sb.toString().toLowerCase();
        String backward = sb.reverse().toString().toLowerCase();
        return forward.equals(backward);
    }

    public static boolean isPalindromeFunctional(String s) {
        String forward = s.toLowerCase().codePoints()
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        String backward = new StringBuilder(forward).reverse().toString();
        return forward.equals(backward);
    }
}

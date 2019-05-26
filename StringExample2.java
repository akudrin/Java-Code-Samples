public class StringExample2 {

    public static void main(String[] args) {
        String myString = " This is a String that contains whitespace. ";
        System.out.println(myString);
        System.out.println(myString.trim());

        String str = "This String will change case.";
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase(Locale.ITALIAN));
        System.out.println(str.toUpperCase(new Locale("it", "US")));
        System.out.println(str.toLowerCase(new Locale("fr", "CA")));

        String one = "Hello";
        String two = "Java9";
        String result1 = one.concat(" ".concat(two));
        String result2 = one + " " + two;

        StringBuffer buffer = new StringBuffer();
        buffer.append(one).append(" ").append(two);
        String result3 = buffer.toString();
        System.out.println(result3);

    }

}
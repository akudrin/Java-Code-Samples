public class TextMatchesExample1 {

    public static void main(String[] args) {

        String str = "Here is a long String...let's find a match!";
        // This will result in a "true" since it is an exact match
        boolean result = str.matches("Here is a long String...let's find a match!");
        System.out.println(result);
        // This will result iin "false" since the entire String does not match
        result = str.matches("Here is a long String...");
        System.out.println(result);
        str = "true";
        // This will test against both upper & lower case "T"...this will be TRUE
        result = str.matches("[Tt]rue");
        System.out.println(result);
        // This will test for one or the other
        result = str.matches("[Tt]rue|[Ff]alse]");
        System.out.println(result);
        // This will test to see if any numbers are present, in this case the
        // person writing this String would be able to like any Java release!
        str = "I love Java 8!";
        result = str.matches("I love Java [0-9]!");
        System.out.println(result);
        // This will test TRUE as well...
        str = "I love Java 7!";
        result = str.matches("I love Java [0-9]!");
        System.out.println(result);
        // The following will test TRUE for any language that contains
        // only one word for a name. This is because it tests for
        // any alphanumeric combination. Notice the space character
        // between the numeric sequence...
        result = str.matches("I love .*[ 0-9]!");
        System.out.println(result);

        // The following String also matches.
        str = "I love Jython 2.5.4!";
        result = str.matches("I love .*[ 0-9]!");
        System.out.println(result);

        // solution 2
        //In the following example code, the Pattern and Matcher technique is demonstrated

        String strNew = "I love Java 9!";
        boolean resultNew = false;
        Pattern pattern = Pattern.compile("I love .*[ 0-9]!");
        Matcher matcher = pattern.matcher(strNew);
        result = matcher.matches();
        System.out.println(resultNew);

    }

}
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

public class DateTimeExample5 {

    public static void main(String[] args) {
        // Parse a String to form a Date-Time object
        LocalDate ld = LocalDate.parse("2014-12-28");
        LocalDateTime ldt = LocalDateTime.parse("2014-12-28T08:44:00");
        System.out.println("Parsed Date: " + ld);
        System.out.println("Parsed Date-Time: " + ldt);
        // Using a different Parser
        LocalDate ld2 = LocalDate.parse("2014-12-28", DateTimeFormatter.ISO_DATE);
        System.out.println("Different Parser: " + ld2);
        // Custom Parser
        String input = "12/28/2013";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate ld3 = LocalDate.parse(input, formatter);
            System.out.println("Custom Parsed Date: " + ld3);
        } catch (DateTimeParseException ex) {
            System.out.println("Not parsable: " + ex);
        }

        // Utilize the DateTimeFormatter class, part of the Date-Time API, to format
        // dates and times according to the
        // pattern you want to use.
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd yyyy");
        LocalDateTime now = LocalDateTime.now();
        String output = now.format(dateFormatter);
        System.out.println(output);
        DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("MM/dd/YY HH:mm:ss");
        String output2 = now.format(dateFormatter2);
        System.out.println(output2);
        DateTimeFormatter dateFormatter3 = DateTimeFormatter.ofPattern("hh 'o''clock' a, zzzz");
        ZonedDateTime zdt = ZonedDateTime.now();
        String output3 = zdt.format(dateFormatter3);
        System.out.println(output3);

        // Create new calendar
        Calendar cal = Calendar.getInstance();
        // Create instance of SimpleDateFormat class using pattern
        SimpleDateFormat dateFormatter1 = new SimpleDateFormat("MMMMM dd yyyy");
        String result = null;
        result = dateFormatter1.format(cal.getTime());
        System.out.println(result);
        dateFormatter1.applyPattern("MM/dd/YY hh:mm:ss");
        result = dateFormatter1.format(cal.getTime());
        System.out.println(result);
        dateFormatter1.applyPattern("hh 'o''clock' a, zzzz");
        result = dateFormatter1.format(cal.getTime());
        System.out.println(result);

    }
}
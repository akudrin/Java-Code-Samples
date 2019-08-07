import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;

public class DataScience1 {
    public static void main(String[] args) {

        System.out.println(parseToDouble("22"));
        System.out.println(parseToOffsetDateTime("2007-12-03T10:15:30+01:00"));

    }

    public static double parseToDouble(String value) {
        double d = 0;
        try {
            d = Double.parseDouble(value);
            // handle d

        } catch (NumberFormatException e) {
            // increment parse error counter etc.
        } finally {

        }
        return d;
    }

    public static OffsetDateTime parseToOffsetDateTime(String value) {
        OffsetDateTime odt = null;
        try {
            odt = OffsetDateTime.parse(value);
            // handle odt
        } catch (
                DateTimeParseException e) {
        // increment parse error counter etc.
        }
        return odt;
    }


    public static boolean checkBlank(String value) {
        return value.trim().isEmpty();
    }

    private static boolean checkNull(String value) {
        return value == null || "null".equalsIgnoreCase(value);
    }


}

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTime10 {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        String text = now.format(DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime dateTime = LocalDateTime.parse(text);

        LocalDate date = LocalDate.of(2017, Month.MARCH, 13);
        System.out.println("Full : " +
                date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println("Long : " +
                date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println("Medium : " +
                date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println("Short : " +
                date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        System.out.println("France : " +
                date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                        .withLocale(Locale.FRANCE)));
        System.out.println("India : " +
                date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                        .withLocale(new Locale("hin", "IN"))));
        System.out.println("Brazil : " +
                date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                        .withLocale(new Locale("pt", "BR"))));
        System.out.println("Japan : " +
                date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                        .withLocale(Locale.JAPAN)));
        Locale loc = new Locale.Builder()
                .setLanguage("sr")
                .setScript("Latn")
                .setRegion("RS")
                .build();
        System.out.println("Serbian: " +
                date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                        .withLocale(loc)));

        ZonedDateTime zdt = ZonedDateTime.of(2018, 3, 11, 2, 30, 0, 0,
                ZoneId.of("America/New_York"));
        System.out.println(
                zdt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));

    }
}

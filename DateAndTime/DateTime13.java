import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTime13 {
    public static void main(String[] args) {

        LocalDate electionDayA = LocalDate.of(2020, Month.NOVEMBER, 3);
        LocalDate todayA = LocalDate.now();
        System.out.printf("%d day(s) to go...%n",
                ChronoUnit.DAYS.between(todayA, electionDayA));

        LocalDate electionDay = LocalDate.of(2020, Month.NOVEMBER, 3);
        LocalDate today = LocalDate.now();
        Period until = today.until(electionDay);
        int years = until.getYears();
        int months = until.getMonths();
        int days = until.getDays();
        System.out.printf("%d year(s), %d month(s), and %d day(s)%n",
                years, months, days);

        Instant start = Instant.now();
        // ... call method to be timed ...
        Instant end = Instant.now();
        System.out.println(getTiming(start, end) + " seconds");

    }

    public static double getTiming(Instant start, Instant end) {
        return Duration.between(start, end).toMillis() / 1000.0;
    }
}

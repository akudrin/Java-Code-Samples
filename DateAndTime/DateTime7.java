import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTime7 {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2017, Month.FEBRUARY, 2);
        LocalDate end = start.plusDays(3);
        end = start.plusWeeks(5);
        end = start.plusMonths(7);
        end = start.plusYears(2);

        LocalTime startA = LocalTime.of(11, 30, 0, 0);
        LocalTime endA = startA.plusNanos(1_000_000);
        endA = startA.plusSeconds(20);
        endA = startA.plusMinutes(45);
        endA = startA.plusHours(5);

        Period period = Period.of(2, 3, 4); // 2 years, 3 months, 4 days
        LocalDateTime startB = LocalDateTime.of(2017, Month.FEBRUARY, 2, 11, 30);
        LocalDateTime endB = startB.plus(period);

        endB = startB.plus(3, ChronoUnit.HALF_DAYS);
        endB = startB.minus(period);
        endB = startB.minus(2, ChronoUnit.CENTURIES);
        endB= startB.plus(3, ChronoUnit.MILLENNIA);


        LocalDateTime startC = LocalDateTime.of(2017, Month.FEBRUARY, 2, 11, 30);
        LocalDateTime endC = startC.withMinute(45);

        endC = startC.withHour(16);
        endC = startC.withDayOfMonth(28);
        endC = startC.withDayOfYear(300);
        endC = startC.withYear(2020);

        LocalDateTime startD = LocalDateTime.of(2017, Month.JANUARY, 31, 11, 30);
        LocalDateTime endD = startD.with(ChronoField.MONTH_OF_YEAR, 2);

        LocalDateTime startE = LocalDateTime.of(2017, Month.FEBRUARY, 2, 11, 30);
        startE.withDayOfMonth(29);

    }
}

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.IntStream;

public class DateTime8 {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2017, Month.FEBRUARY, 2, 11, 30);
        LocalDateTime end = start.with(TemporalAdjusters.firstDayOfNextMonth());

        end = start.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        end = start.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));

        TemporalAdjuster adjuster = new PaydayAdjuster();
        IntStream.rangeClosed(1, 14)
                .mapToObj(day -> LocalDate.of(2017, Month.JULY, day))
                .forEach(date ->
                        date.with(adjuster).getDayOfMonth());

        IntStream.rangeClosed(15, 31)
                .mapToObj(day -> LocalDate.of(2017, Month.JULY, day))
                .forEach(date ->
                        date.with(adjuster).getDayOfMonth());

        IntStream.rangeClosed(1, 14)
                .mapToObj(day -> LocalDate.of(2017, Month.JULY, day))
                .forEach(date ->
                                date.with(Adjusters::adjustInto).getDayOfMonth());

        IntStream.rangeClosed(15, 31)
                .mapToObj(day -> LocalDate.of(2017, Month.JULY, day))
                .forEach(date ->
                                date.with(Adjusters::adjustInto).getDayOfMonth());


    }
}

class PaydayAdjuster implements TemporalAdjuster {
    public Temporal adjustInto(Temporal input) {
        LocalDate date = LocalDate.from(input);
        int day;
        if (date.getDayOfMonth() < 15) {
            day = 15;
        } else {
            day = date.with(TemporalAdjusters.lastDayOfMonth())
                    .getDayOfMonth();
        }
        date = date.withDayOfMonth(day);
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }
        return input.with(date);
    }
}

class Adjusters {
    public static Temporal adjustInto(Temporal input) {
        LocalDate date = LocalDate.from(input);
        int day;
        if (date.getDayOfMonth() < 15) {
            day = 15;
        } else {
            day = date.with(TemporalAdjusters.lastDayOfMonth())
                    .getDayOfMonth();
        }
        date = date.withDayOfMonth(day);
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }
        return input.with(date);
    }
}
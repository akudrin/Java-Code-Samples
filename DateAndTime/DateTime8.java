import java.time.*;
import java.time.temporal.*;
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

        System.out.println(LocalDate.now().query(TemporalQueries.precision()));
        System.out.println(LocalTime.now().query(TemporalQueries.precision()));
        System.out.println(ZonedDateTime.now().query(TemporalQueries.zone()));
        System.out.println(ZonedDateTime.now().query(TemporalQueries.zoneId()));

        IntStream.range(10, 19)
                .mapToObj(n -> LocalDate.of(2017, Month.SEPTEMBER, n))
                .forEach(date ->
                        System.out.println(date.query(new DateTime8()::daysUntilPirateDay)) );
        IntStream.rangeClosed(20, 30)
                .mapToObj(n -> LocalDate.of(2017, Month.SEPTEMBER, n))
                .forEach(date -> {
                    Long days = date.query(new DateTime8()::daysUntilPirateDay);
                    System.out.println(days);
                });

    }

    private long daysUntilPirateDay(TemporalAccessor temporal) {
        int day = temporal.get(ChronoField.DAY_OF_MONTH);
        int month = temporal.get(ChronoField.MONTH_OF_YEAR);
        int year = temporal.get(ChronoField.YEAR);
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate tlapd = LocalDate.of(year, Month.SEPTEMBER, 19);
        if (date.isAfter(tlapd)) {
            tlapd = tlapd.plusYears(1);
        }
        return ChronoUnit.DAYS.between(date, tlapd);
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
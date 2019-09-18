import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class DateTimeExample6 {
    public static void main(String[] args) {
        LocalDate startA = LocalDate.of(2017, Month.JUNE, 10);
        LocalDate endA = LocalDate.of(2017, Month.JUNE, 17);
        System.out.println(new DateTimeExample6().getDays_java8Wrong(startA, endA));

        LocalDate startB = LocalDate.of(2017, Month.JUNE, 10);
        LocalDate endB = LocalDate.of(2017, Month.JULY, 10);
        //Empty output
        System.out.println(new DateTimeExample6().getDays_java8Wrong(startB, endB));

        //Works
        System.out.println(new DateTimeExample6().getDays_java8Works(startB, endB));

        //Java9
        System.out.println(new DateTimeExample6().getDays_java9(startB, endB));
        System.out.println(new DateTimeExample6().getMonths_java9(startB, endB));

    }

    //Days between two dates (WARNING: BUG!)
    public List<LocalDate> getDays_java8Wrong(LocalDate start, LocalDate end) {
        Period period = start.until(end);
        return IntStream.range(0, period.getDays())
                .mapToObj(start::plusDays)
        .collect(Collectors.toList());
    }

    //Days between two dates (WORKS)
    public List<LocalDate> getDays_java8Works(LocalDate start, LocalDate end) {
        Period period = start.until(end);
        return LongStream.range(0, ChronoUnit.DAYS.between(start, end))
                .mapToObj(start::plusDays)
        .collect(Collectors.toList());
    }

    //Iterating on LocalDate
    public List<LocalDate> getDaysByIterate(LocalDate start, int days) {
        return Stream.iterate(start, date -> date.plusDays(1))
                .limit(days)
                .collect(Collectors.toList());
    }

    //Date ranges in Java 9
    public List<LocalDate> getDays_java9(LocalDate start, LocalDate end) {
        return start.datesUntil(end)
                .collect(Collectors.toList());
    }
    public List<LocalDate> getMonths_java9(LocalDate start, LocalDate end) {
        return start.datesUntil(end, Period.ofMonths(1))
                .collect(Collectors.toList());
    }
}

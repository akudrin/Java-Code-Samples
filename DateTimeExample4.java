import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class DateTimeExample4 {

    public static void main(String[] args) {
        LocalDate anniversary = LocalDate.of(2000, Month.NOVEMBER, 11);
        LocalDate today = LocalDate.now();
        Period period = Period.between(anniversary, today);
        System.out.println("Number of Days Difference: " + period.getDays());
        System.out.println("Number of Months Difference: " + period.getMonths());
        System.out.println("Number of Years Difference: " + period.getYears());

        // Obtain two instances of the Calendar class
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        // Set the date to 01/01/2010:12:00
        cal2.set(2010, 0, 1, 12, 0);
        Date date1 = cal2.getTime();
        System.out.println(date1);
        long mill = Math.abs(cal1.getTimeInMillis() - date1.getTime());
        // Convert to hours
        long hours = TimeUnit.MILLISECONDS.toHours(mill);
        // Convert to days
        Long days = TimeUnit.HOURS.toDays(hours);
        String diff = String.format("%d hour(s) %d min(s)", hours,
        TimeUnit.MILLISECONDS.toMinutes(mill) - TimeUnit.HOURS.toMinutes(hours));
        System.out.println(diff);
        diff = String.format("%d days", days);
        System.out.println(diff);
        // Divide the number of days by seven for the weeks
        int weeks = days.intValue() / 7;
        diff = String.format("%d weeks", weeks);
        System.out.println(diff);

        LocalDate anniversary1 = LocalDate.of(2000, Month.NOVEMBER, 11);
        LocalDate today1 = LocalDate.now();
        long yearsBetween = ChronoUnit.YEARS.between(anniversary1, today1);
        System.out.println("Years between dates: " + yearsBetween);
        long daysBetween = ChronoUnit.DAYS.between(anniversary1, today1);
        System.out.println("Days between dates:" + daysBetween);

    }

    public static void compareDates(LocalDate ldt1, LocalDate ldt2) {
        int comparison = ldt1.compareTo(ldt2);
        if (comparison > 0) {
            System.out.println(ldt1 + " is larger than " + ldt2);
        } else if (comparison < 0) {
            System.out.println(ldt1 + " is smaller than " + ldt2);
        } else {
            System.out.println(ldt1 + " is equal to " + ldt2);
        }
    }

    public static void compareDates2(LocalDate ldt1, LocalDate ldt2) {
        if (ldt1.isAfter(ldt2)) {
            System.out.println(ldt1 + " is after " + ldt2);
        } else if (ldt1.isBefore(ldt2)) {
            System.out.println(ldt1 + " is before " + ldt2);
        } else if (ldt1.isEqual(ldt2)) {
            System.out.println(ldt1 + " is equal to " + ldt2);
        }
    }

}
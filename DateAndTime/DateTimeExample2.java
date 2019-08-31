public class DateTimeExample2 {

    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("Local Date and Time: " + ldt);

        // Obtain the LocalDateTime object of the date 11/11/2000 at 12:00
        LocalDateTime ldt2 = LocalDateTime.of(2000, Month.NOVEMBER, 11, 12, 00);

        // Obtain the month from LocalDateTime object
        Month month = ldt.getMonth();
        int monthValue = ldt.getMonthValue();
        System.out.println("Month: " + month);
        System.out.println("Month Value: " + monthValue);
        // Obtain day of Month, Week, and Year
        int day = ldt.getDayOfMonth();
        DayOfWeek dayWeek = ldt.getDayOfWeek();
        int dayOfYr = ldt.getDayOfYear();
        System.out.println("Day: " + day);
        System.out.println("Day Of Week: " + dayWeek);
        System.out.println("Day of Year: " + dayOfYr);
        // Obtain year
        int year = ldt.getYear();
        System.out.println("Date: " + monthValue + "/" + day + "/" + year);
        int hour = ldt.getHour();
        int minute = ldt.getMinute();
        int second = ldt.getSecond();
        System.out.println("Current Time: " + hour + ":" + minute + ":" + second);
        // Calculation of Months, etc.
        LocalDateTime currMinusMonths = ldt.minusMonths(12);
        LocalDateTime currMinusHours = ldt.minusHours(10);
        LocalDateTime currPlusDays = ldt.plusDays(30);
        System.out.println("Current Date and Time Minus 12 Months: " + currMinusMonths);
        System.out.println("Current Date and Time MInus 10 Hours: " + currMinusHours);
        System.out.println("Current Date and Time Plus 30 Days:" + currPlusDays);

        Date date = new Date();
        System.out.println("Using java.util.Date(): " + date);
        System.out.println("Getting time from java.util.Date(): " + date.getTime());

        Date date1 = new Date();
        System.out.println("Using java.util.Date(): " + date1);
        System.out.println("Getting time from java.util.Date(): " + date1.getTime());

        String[] days = symbols.getWeekdays();
        System.out.println(days[dayOfWeek]);
        // Get crazy with the date!
        int dayOfYear = gCal.get(Calendar.DAY_OF_YEAR);
        System.out.println(dayOfYear);
        // Print the number of days left in the year
        System.out.println("Days left in " + yr + ": " + (365 - dayOfYear));
        int week = gCal.get(Calendar.WEEK_OF_YEAR);
        // Print the week of the year
        System.out.println(week);
    }

}
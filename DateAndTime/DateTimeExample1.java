public class DateTimeExample1 {

    public static void main(String[] args) {

        // the current date, not including the time
        LocalDate date = LocalDate.now();
        System.out.println("Current Date:" + date);

        Clock clock = Clock.systemUTC();
        LocalDate date1 = LocalDate.now(clock);
        System.out.println("Current Date:" + date1);

        // date object, given a year-month-day specification
        LocalDate date2 = LocalDate.of(2000, Month.NOVEMBER, 11);
        System.out.println("Date from specified date: " + date2);

        // the year, year-month, or month of a specified date
        YearMonth yearMo = YearMonth.now();
        System.out.println("Current Year and month:" + yearMo);
        YearMonth specifiedDate = YearMonth.of(2000, Month.NOVEMBER);
        System.out.println("Specified Year-Month: " + specifiedDate);

        MonthDay monthDay = MonthDay.now();
        System.out.println("Current month and day: " + monthDay);
        MonthDay specifiedDate1 = MonthDay.of(Month.NOVEMBER, 11);
        System.out.println("Specified Month-Day: " + specifiedDate1);

        // obtain the current time
        LocalTime time = LocalTime.now();
        System.out.println("Current Time: " + time);

        // atDate(LocalDate): obtain the local date and time
        LocalDateTime ldt = time.atDate(LocalDate.of(2011, Month.NOVEMBER, 11));
        System.out.println("Local Date Time object: " + ldt);
        // of(int hours, int min): obtain a specific time
        LocalTime pastTime = LocalTime.of(1, 10);
        // compareTo(LocalTime): compare two times. Positive
        // return value returned if greater
        System.out.println("Comparing times: " + time.compareTo(pastTime));
        // getHour(): return hour in int value (24-hour format)
        int hour = time.getHour();
        System.out.println("Hour: " + hour);
        // isAfter(LocalTime): return Boolean comparison
        System.out.println("Is local time after pastTime? " + time.isAfter(pastTime));
        // minusHours(int): Subtract Hours from LocalTime
        LocalTime minusHrs = time.minusHours(5);
        System.out.println("Time minus 5 hours: " + minusHrs);
        // plusMinutes(int): Add minutes to LocalTime
        LocalTime plusMins = time.plusMinutes(30);
        System.out.println("Time plus 30 mins: " + plusMins);

    }

}
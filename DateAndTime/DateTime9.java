import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTime9 {
    public static void main(String[] args) {


    }

    public LocalDate convertFromUtilDateUsingInstant(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDate convertFromSqlDatetoLD(java.sql.Date sqlDate) {
        return sqlDate.toLocalDate();
    }
    public java.sql.Date convertToSqlDateFromLD(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }

    public LocalDateTime convertFromTimestampToLDT(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }
    public Timestamp convertToTimestampFromLDT(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }

    public LocalDate convertUtilDateToLocalDate(java.util.Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate()
    }

    public ZonedDateTime convertFromCalendar(Calendar cal) {
        return ZonedDateTime.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId());
    }

    public LocalDateTime convertFromCalendarUsingGetters(Calendar cal) {
        return LocalDateTime.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR),
                cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
    }

    public LocalDateTime convertFromUtilDateToLDUsingString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return LocalDateTime.parse(df.format(date),
                DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public ZonedDateTime convertFromGregorianCalendar(Calendar cal) {
        return ((GregorianCalendar) cal).toZonedDateTime();
    }

    public LocalDate convertFromUtilDateJava9(Date date) {
        return LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

}

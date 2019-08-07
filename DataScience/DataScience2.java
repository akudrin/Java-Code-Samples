import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DataScience2 {
    public static void main(String[] args) {
        System.out.println(checkRangeDouble(2));
        System.out.println(checkRangeString("element 2"));
        System.out.println(checkRangeOffsetDateTime(OffsetDateTime.of(LocalDateTime.of(2017, 05, 12, 05, 45),
                ZoneOffset.ofHoursMinutes(4, 30))));

    }

    public static boolean checkRangeDouble(double value) {
        double minValue = 1.0;
        boolean minValueInclusive = true;
        double maxValue = 10.0;
        boolean maxValueInclusive = true;
        boolean minBit = (minValueInclusive) ? value >= minValue : value > minValue;
        boolean maxBit = (maxValueInclusive) ? value <= maxValue : value < maxValue;
        return minBit && maxBit;
    }

    private static boolean checkRangeString(String value) {
        Set validItems = new TreeSet();

        validItems.add("element 1");
        validItems.add("element 2");
        validItems.add("element 3");

        Iterator iterator = validItems.iterator();

        while(iterator.hasNext()){
            String element = (String) iterator.next();
            System.out.print(element + "\t");
        }

        return validItems.contains(value);
    }

    private static boolean checkRangeOffsetDateTime(OffsetDateTime odt) {
        OffsetDateTime minDate = OffsetDateTime.of(LocalDateTime.of(2016, 05, 12, 05, 45),
                ZoneOffset.ofHoursMinutes(6, 30));
                OffsetDateTime maxDate = OffsetDateTime.now();
        return odt.isAfter(minDate) && odt.isBefore(maxDate);
    }

}


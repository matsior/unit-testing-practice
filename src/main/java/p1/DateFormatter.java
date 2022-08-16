package p1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

    public static String format(LocalDate date) {
        return date.format(dateTimeFormatter);
    }
}

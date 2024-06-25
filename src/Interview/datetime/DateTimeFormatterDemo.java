package Interview.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterDemo {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        System.out.println(localDate.format(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
        ));

        System.out.println(localDate.format(
                DateTimeFormatter.ofPattern("MMMM d")
        ));
    }
}

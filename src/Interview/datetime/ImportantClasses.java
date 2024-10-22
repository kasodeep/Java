package Interview.datetime;

import java.time.*;

public class ImportantClasses {

    public static void main(String[] args) {
        // LocalDate example
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        LocalDate specificDate = LocalDate.of(2024, 10, 22);
        System.out.println("Specific Date: " + specificDate);

        LocalDate modifiedDate = currentDate.plusDays(5).plusMonths(2).plusYears(1);
        System.out.println("Modified Date: " + modifiedDate);

        // LocalTime example
        LocalTime currentTime = LocalTime.now();
        System.out.println("\nCurrent Time: " + currentTime);

        LocalTime specificTime = LocalTime.of(14, 30, 15);
        System.out.println("Specific Time: " + specificTime);

        LocalTime modifiedTime = currentTime.plusHours(2).plusMinutes(30);
        System.out.println("Modified Time: " + modifiedTime);

        // LocalDateTime example
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("\nCurrent Date and Time: " + currentDateTime);

        LocalDateTime specificDateTime = LocalDateTime.of(2024, 10, 22, 14, 30);
        System.out.println("Specific Date and Time: " + specificDateTime);

        LocalDateTime modifiedDateTime = currentDateTime.plusDays(5).plusHours(3);
        System.out.println("Modified Date and Time: " + modifiedDateTime);

        // ZonedDateTime example
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        System.out.println("\nCurrent Zoned Date and Time: " + currentZonedDateTime);

        ZonedDateTime zonedDateTimeInNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("New York Zoned Date and Time: " + zonedDateTimeInNewYork);

        ZonedDateTime modifiedZonedDateTime = currentZonedDateTime.plusDays(1).withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
        System.out.println("Modified Zoned Date and Time: " + modifiedZonedDateTime);

        // OffsetDateTime example
        OffsetDateTime currentOffsetDateTime = OffsetDateTime.now();
        System.out.println("\nCurrent Offset Date and Time: " + currentOffsetDateTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.of(2024, 10, 22, 14, 30, 0, 0, ZoneOffset.of("+02:00"));
        System.out.println("Specific Offset Date and Time: " + offsetDateTime);

        // Period example
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.now();

        Period period = Period.between(startDate, endDate);
        System.out.println("\nPeriod between " + startDate + " and " + endDate + ": "
                + period.getYears() + " years, "
                + period.getMonths() + " months, "
                + period.getDays() + " days");

        // Duration example
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(12, 30);

        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Duration between " + startTime + " and " + endTime + ": "
                + duration.toHours() + " hours and "
                + duration.toMinutesPart() + " minutes");
    }
}
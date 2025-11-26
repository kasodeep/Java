package Basics;

public class SwitchExpression {

    public static int getDaysInMonth(Month month, boolean isLeapYear) {
        return switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
            case APRIL, JUNE, SEPTEMBER -> 30;
            case FEBRUARY -> isLeapYear ? 29 : 28;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        Month month = Month.FEBRUARY;
        boolean isLeapYear = true;

        System.out.println("Days in " + month + ": " + getDaysInMonth(month, isLeapYear));
    }

    public enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
        JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }
}

// LocalDate and Month are classes from the java.time package
import java.time.LocalDate;
import java.time.Month;
// We can use Period class to calculate the difference between two dates
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.time.format.DateTimeFormatter;

public class LocalDatePeriodTemporalAdjustersAndDateTimeFormatter {
    public static void main(String[] args) {
        //LocalDate date = LocalDate.of(1999, 6, 12);
        LocalDate birthday = LocalDate.of(1999, Month.JUNE, 12);
        // LocalDate.now() returns the current date
        LocalDate now = LocalDate.now();
        // Period.between() returns the difference between two dates
        Period p = Period.between(birthday, now);
        System.out.println(birthday);
        // Period class has methods to get the difference in years, months and days
        System.out.println(p.getYears() + " years " + p.getMonths() + " months " + p.getDays() + " days");

        // next birthday:
        LocalDate nextBirthday = birthday.withYear(now.getYear());
        // if the birthday has already passed this year, add 1 to the year
        if (nextBirthday.isBefore(now) || nextBirthday.isEqual(now)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        Period p2 = Period.between(now, nextBirthday);
        System.out.println("Next birthday: " + nextBirthday);
        System.out.println(p2.getMonths() + " months " + p2.getDays() + " days");

        // Day of Week from next birthday:
        System.out.println("Day of Week: " + nextBirthday.getDayOfWeek().name());
        System.out.println("Day of Week: " + nextBirthday.getDayOfWeek().ordinal());
        // Month:
        System.out.println("Month: " + nextBirthday.getMonth().name());
        System.out.println("Month: " + nextBirthday.getMonth().ordinal());
        // Year:
        System.out.println("Year: " + nextBirthday.getYear());
        // Leap Year:
        System.out.println("Leap Year: " + nextBirthday.isLeapYear());
        // Day of Year:
        System.out.println("Day of Year: " + nextBirthday.getDayOfYear());
        // Number of days in month:
        System.out.println("Number of days in month: " + nextBirthday.lengthOfMonth());
        // Number of days in year:
        System.out.println("Number of days in year: " + nextBirthday.lengthOfYear());

        // TemporalAdjusters:
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate tomorrow = today.plusDays(1);
        LocalDate nextMonth = today.plusMonths(1);
        LocalDate nextYear = today.plusYears(1);

        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate lastDayOfDecember = today.withMonth(12).with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Today: " + today);
        System.out.println("Yesterday: " + yesterday);
        System.out.println("Tomorrow: " + tomorrow);
        System.out.println("Next Month: " + nextMonth);
        System.out.println("Next Year: " + nextYear);
        System.out.println("Last Day of This Month: " + lastDayOfThisMonth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Last Day of December: " + lastDayOfDecember.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));


    }
}
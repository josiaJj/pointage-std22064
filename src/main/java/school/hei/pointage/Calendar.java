package school.hei.pointage;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Month;

@NoArgsConstructor
public class Calendar {
    private int year;
    private int month;
    public void monthCalendar(int monthNumber) {
        Month month = Month.of(monthNumber);
        LocalDate month1stDay = LocalDate.of(2024, month, 1);
        LocalDate monthLastday = LocalDate.of(2024, month, 30);
        int[] workingDaysNormal = {1, 2, 3, 4, 5};
        int[] workingDaysGuard = {1, 2, 3, 4, 5, 6, 7};
        LocalDate[] monthHolidays = {LocalDate.of(2024, month, 17),
                LocalDate.of(2024, month, 25),
                LocalDate.of(2024, month, 26)};

        while (month1stDay.isBefore(monthLastday.plusDays(1))) {
            LocalDate currentDate = month1stDay;

            boolean holiday = false;
            for (LocalDate isHoliday : monthHolidays) {
                if (isHoliday.equals(currentDate)) {
                    holiday = true;
                    break;
                }
            }

            System.out.print(currentDate.getDayOfWeek() + " (" + currentDate + ") : ");

            if (contains(workingDaysNormal, currentDate.getDayOfWeek().getValue()) && !holiday) {
                System.out.println("Employés normaux et Gardiens");
            } else if (contains(workingDaysGuard, currentDate.getDayOfWeek().getValue()) && !holiday) {
                System.out.println("Gardiens");
            } else {
                System.out.println("Repos");
            }

            month1stDay = month1stDay.plusDays(1);

        }

    }
    private static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }
}

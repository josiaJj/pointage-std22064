package school.hei.pointage;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class Calendar {
    private int year;
    private int month;

    private Map<String, List<LocalDate>> monthCalendar(int year, int monthNumber, int[] monthHolidays) {
        Month month = Month.of(monthNumber);
        LocalDate month1stDay = LocalDate.of(2024, month, 1);
        LocalDate monthLastday = LocalDate.of(year, month, month.length(false));

        int[] workingDaysNormal = {1, 2, 3, 4, 5};
        int[] workingDaysGuard = {1, 2, 3, 4, 5, 6, 7};

        Map<String, List<LocalDate>> categorizedDays = new HashMap<>();
        categorizedDays.put("normalEmployee", new ArrayList<>());
        categorizedDays.put("guard", new ArrayList<>());
        categorizedDays.put("holidays", new ArrayList<>());
        while (month1stDay.isBefore(monthLastday.plusDays(1))) {
            LocalDate currentDate = month1stDay;

            boolean isHoliday = false;
            for (int holidayDay : monthHolidays) {
                if (holidayDay == currentDate.getDayOfMonth()) {
                    isHoliday = true;
                    break;
                }
            }

            //System.out.print(currentDate.getDayOfWeek() + " (" + currentDate + ") : ");

            if (contains(workingDaysNormal, currentDate.getDayOfWeek().getValue()) && !isHoliday) {
                //System.out.println("Employés normaux et Gardiens");
                categorizedDays.get("normalEmployee").add(currentDate);
                categorizedDays.get("guard").add(currentDate);
            } else if (contains(workingDaysGuard, currentDate.getDayOfWeek().getValue()) && !isHoliday) {
                categorizedDays.get("guard").add(currentDate);
            } else {
                categorizedDays.get("holidays").add(currentDate);
            }

            month1stDay = month1stDay.plusDays(1);

        }
        return categorizedDays;

    }
    private static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }
    public Map<String, List<LocalDate>> juneCalendar(int year) {
        return monthCalendar(year, 6, new int[]{17, 25, 26});
    }

}

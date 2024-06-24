package school.hei.pointage;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        //System.out.println(calendar.juneCalendar(2024));
        //Category guard = new Category("guard", 56, 110_000, 00);
        Employee rakoto = new Employee("Rakoto", "guard");
        System.out.println(rakoto.monthWorkingHours("night"));
        //System.out.println(calendar.workingDays("normalEmployee").size());
        //System.out.println(rakoto.monthWorkingHours());
        //Category normalEmployee = new Category("normalEmployee", 40, 100_000, 00);
        //
        //System.out.println(guard.countingMonthHours(6));
        //System.out.println(normalEmployee.countingMonthHours(6));
        //rakoto.guard.workingNight.getMonthHours(int monthNumber);
    }


}
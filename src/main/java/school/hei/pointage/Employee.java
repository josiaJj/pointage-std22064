package school.hei.pointage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private String name;
    private int matriculeNumber;
    private Instant birthDate;
    private Instant contractStartDate;
    private Instant contractEndDate;
    private double salaryAmount;
    private String category;

    public Employee(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public List<LocalDate> workingDays() {
        Calendar calendar = new Calendar();
        return calendar.juneCalendar(2024).get(getCategory());
    }

    public long daysBetween(String startDateStr, String endDateStr) {
        LocalDate startDate = LocalDate.parse(startDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse(endDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return ChronoUnit.DAYS.between(startDate, endDate.plusDays(1));
    }

    public int monthWorkingHours(String dayOrNight) {
        System.out.println("Working Days :" + workingDays().size());
        if (dayOrNight.equals("day")) {
            return 10 * workingDays().size();
        } else if (dayOrNight.equals("night")) {
            return 14 * workingDays().size();
        } else {
            return 0;
        }
    }

}

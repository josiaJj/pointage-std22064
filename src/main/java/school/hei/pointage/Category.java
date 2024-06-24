package school.hei.pointage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
    private String name;
    private int weeklyNormalWorkingHours;
    private double weeklyNormalSalary;
    private double compensationAmount;

}

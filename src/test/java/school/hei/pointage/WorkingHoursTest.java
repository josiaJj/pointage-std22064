package school.hei.pointage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkingHoursTest {
    @Test
    public void rakoto_works_420h() {
        Employee rakoto = new Employee("Rakoto", "Guard");
        long days = rakoto.daysBetween("2024-05-26", "2024-07-06");
        assertEquals(days, 42);
    }
}

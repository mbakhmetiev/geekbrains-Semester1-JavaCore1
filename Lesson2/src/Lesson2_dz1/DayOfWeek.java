package Lesson2_dz1;

import java.util.EnumSet;

public enum DayOfWeek {
    MONDAY(8), TUESDAY(8), WEDNESDAY(8), THURSDAY(8), FRIDAY(8),
    SATURDAY(0), SUNDAY(0);

    private final int workhours;

    DayOfWeek(int workhours) {
        this.workhours = workhours;
    }

    public static int getWorkingHours(DayOfWeek day) {
        int total = 0;
        for (DayOfWeek workday : EnumSet.range(day, DayOfWeek.SUNDAY)) {
            total += workday.workhours;
        }
        return total;
    }
}

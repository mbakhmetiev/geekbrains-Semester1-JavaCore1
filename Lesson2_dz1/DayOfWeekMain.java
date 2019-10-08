package Lesson2_dz1;

public class DayOfWeekMain {
    public static void main(String[] args) {

        DayOfWeek day = DayOfWeek.WEDNESDAY;

        System.out.printf("Если сегодня %s, то до конца недели осталось - %d часа%n" , day, DayOfWeek.getWorkingHours(day));
    }


}

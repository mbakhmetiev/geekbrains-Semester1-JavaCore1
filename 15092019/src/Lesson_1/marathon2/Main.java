package Lesson_1.marathon2;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Overwatch", "Ханзо","Заря", "Барсик", "Джек");
        team.teamInfo();
        Course c = new Course(new Cross(80), new Wall(2), new Wall(1), new Cross(120), new Water(10), new Cross(150));
        c.doIt(team);
        team.showResults();
    }
}

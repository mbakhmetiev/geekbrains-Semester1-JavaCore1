package Lesson_1.marathon2;

public class Course {

    private Obstacle[] course;

    public Course(Obstacle... vars) {
        this.course = new Obstacle[vars.length];
        int i = 0;
        for (Obstacle x : vars) {
            course[i] = x;
            i++;
        }
    }

    public Obstacle[] getCourse () {
        return course;
    }

    public void doIt(Team team) {

        for (Competitor t : team.getTeam()) {
            for (Obstacle o : getCourse()) {
                o.doIt(t);
                if (!t.isOnDistance()) break;
            }
        }
    }
}

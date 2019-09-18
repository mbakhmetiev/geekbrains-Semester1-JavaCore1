package Lesson_1.marathon2;

public class Team {

    private Competitor[] team = new Competitor[4];
    private String teamName;

    public Team(String teamName, String humanName1, String humanName2, String catName, String dogName) {
        this.teamName = teamName;
        this.team[0] = new Human(humanName1);
        this.team[1] = new Human(humanName2);
        this.team[2] = new Dog(dogName);
        this.team[3] = new Cat(catName);
    }

    public Competitor[] getTeam() {
        return team;
    }

    public void teamInfo() {
        System.out.println("Команда -" + teamName);
        for (Competitor t : team) {
            System.out.println(t.toString());
        }
    }

    public void showResults() {
        for (Competitor t : getTeam()) {
            t.info();
        }

    }
}

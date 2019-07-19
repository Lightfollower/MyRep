package Lesson_1.Marathon.competitors;

import Lesson_1.Marathon.competitors.Competitor;

public class Team {
    private String teamName;
    private Competitor[] competitors;

    public Team(String teamName, Competitor... competitors) {
        this.teamName = teamName;
        this.competitors = competitors;
    }

    public void activeCompetitorsInfo() {
        for (Competitor c :
                competitors) {
            if (c.isOnDistance())
                c.info();
        }
    }

    public void competitorsInfo() {
        for (Competitor c :
                competitors) {
                c.info();
        }
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public String getTeamName() {
        return teamName;
    }
}

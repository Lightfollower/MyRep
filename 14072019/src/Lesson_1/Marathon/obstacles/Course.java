package Lesson_1.Marathon.obstacles;

import Lesson_1.Marathon.competitors.Team;

public class Course {
    Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void teamDoIt(Team team){
        for (int i = 0; i < team.getCompetitors().length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                obstacles[j].doIt(team.getCompetitors()[i]);
                if(!team.getCompetitors()[i].isOnDistance())
                    break;
            }
        }
    }
}

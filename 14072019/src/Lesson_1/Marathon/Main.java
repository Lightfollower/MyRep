package Lesson_1.Marathon;

import Lesson_1.Marathon.competitors.Team;
import Lesson_1.Marathon.obstacles.Course;
import Lesson_1.Marathon.obstacles.Cross;
import Lesson_1.Marathon.obstacles.Wall;
import Lesson_1.Marathon.competitors.Cat;
import Lesson_1.Marathon.competitors.Dog;
import Lesson_1.Marathon.competitors.Human;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Human, dog and cat", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"));
        Course course = new Course(new Cross(80), new Wall(2), new Wall(1), new Cross(120));
        course.teamDoIt(team);
        team.activeCompetitorsInfo();
    }
}
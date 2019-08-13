package Game;

import Game.heroes.Hero;
import Game.sample.Controller;
import javafx.application.Platform;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.List;

public class Game extends Thread {
    public Controller controller;
    public boolean win = false;
    public boolean isFinished = false;
    public List<Hero> team1 = new ArrayList<>();/*{new Warrior(this, 250, "Тигрил", 50, 0)
            , new Assassin(this, 150, "Акали", 70, 0)
            , new Doctor(this, 120, "Жанна", 0, 60)};*/

    public List<Hero> team2 = new ArrayList<>();/*{new Warrior(this, 290, "Минотавр", 60, 0)
            , new Assassin(this, 160, "Джинкс", 90, 0)
            , new Doctor(this, 110, "Зои", 0, 80)};*/

    public Game(Controller controller) {
        this.controller = controller;
    }

    public void startGame() {
        start();
        for (Hero h : team1) {
            h.start();
        }
        for (Hero h : team2) {
            h.start();
        }
    }


//    public boolean isWin() {
//        return win;
//    }

    public void addHeroInTeam_1(Hero hero) {
        team1.add(hero);
        System.out.println(team1);
    }

    public void addHeroInTeam_2(Hero hero) {
        team2.add(hero);
        System.out.println(team2);

    }


    @Override
    public void run() {
        while (true) {
            win = true;
            /*synchronized (team1)*/
            {
                for (Hero h :
                        team1) {

                    if (h.getHealth() > 0) {
                        win = false;
                        break;
                    }
                }
            }
            if (win) {
                System.out.println("team 2 win");
                Platform.runLater(() -> controller.log.getChildren().add(new Label("team 2 win\n")));
                break;
            }
            win = true;
            {
                for (Hero h :
                        team2) {

                    if (h.getHealth() > 0) {
                        win = false;
                        break;
                    }
                }
            }
            if (win) {
                System.out.println("team 1 win");
                Platform.runLater(() -> controller.log.getChildren().add(new Label("team 1 win\n")));
                break;
            }
        }
        isFinished = true;
        System.out.println("Game finished");
    }
}
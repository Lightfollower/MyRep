package Game;

import Game.heroes.Assassin;
import Game.heroes.Doctor;
import Game.heroes.Hero;
import Game.heroes.Warrior;
import Game.sample.Main;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Game extends Thread {
    public Main application;
    public boolean win = false;
    public boolean isFinished = false;
    public List<Hero> team1 = new ArrayList<>();/*{new Warrior(this, 250, "Тигрил", 50, 0)
            , new Assassin(this, 150, "Акали", 70, 0)
            , new Doctor(this, 120, "Жанна", 0, 60)};*/

    public List<Hero> team2 = new ArrayList<>();/*{new Warrior(this, 290, "Минотавр", 60, 0)
            , new Assassin(this, 160, "Джинкс", 90, 0)
            , new Doctor(this, 110, "Зои", 0, 80)};*/

    public Game(Main application) {
        this.application = application;
    }

    public void startGame() {
//        gameStarted = true;
        start();
        for (Hero h : team1) {
            h.start();
        }
        for (Hero h : team2) {
            h.start();
        }
    }


    public boolean isWin() {
        return win;
    }

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
            /*synchronized (team1)*/ {
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
                application.log.appendText("team 2 win\n");
                break;
            }
            win = true;
            /*synchronized (team2)*/ {
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
                application.log.appendText("team 1 win\n");
                break;
            }
        }
        isFinished = true;
        System.out.println("Game finished");
    }
}
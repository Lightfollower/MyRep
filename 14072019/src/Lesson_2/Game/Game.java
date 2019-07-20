package Lesson_2.Game;

import java.util.Random;

class Game {
    boolean win = false;
    private volatile Hero[] team1 = new Hero[]{new Warrior(this, 250, "Тигрил", 50, 0)
            , new Assassin(this, 150, "Акали", 70, 0)
            , new Doctor(this, 120, "Жанна", 0, 60)};

    private volatile Hero[] team2 = new Hero[]{new Warrior(this, 290, "Минотавр", 60, 0)
            , new Assassin(this, 160, "Джинкс", 90, 0)
            , new Doctor(this, 110, "Зои", 0, 80)};

    public static void main(String[] args) {
        Game game = new Game();
        game.team1[2].setAllies(game.team1);
        game.team2[2].setAllies(game.team2);
        for (int i = 0; i < game.team1.length; i++) {
            game.team1[i].setOpponents(game.team2);
            game.team2[i].setOpponents(game.team1);
            game.team1[i].start();
            game.team2[i].start();
        }

        while (true) {
            if (game.team1[0].getHealth() <= 0 && game.team1[1].getHealth() <= 0 && game.team1[2].getHealth() <= 0) {
                game.win = true;
                System.out.println("team 2 win");
                break;
            }

            if (game.team2[0].getHealth() <= 0 && game.team2[1].getHealth() <= 0 && game.team2[2].getHealth() <= 0) {
                game.win = true;
                System.out.println("team 1 win");
                break;
            }
        }
    }
}
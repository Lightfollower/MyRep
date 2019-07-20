package Lesson_2.Game;

import java.util.Random;

class Game {
    boolean win = false;
    private volatile Hero[] team1 = new Hero[]{new Warrior( this, 250, "Тигрил", 50, 0)
            , new Assassin(this,150, "Акали", 70, 0)
            , new Doctor(this, 120, "Жанна", 0, 60)};

    private volatile Hero[] team2 = new Hero[]{new Warrior(this,290, "Минотавр", 60, 0)
            , new Assassin(this,160, "Джинкс", 90, 0)
            , new Doctor(this,110, "Зои", 0, 80)};
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

        while (true){
            if(game.team1[0].getHealth() <= 0 && game.team1[1].getHealth() <= 0 && game.team1[2].getHealth() <= 0){
                game.win = true;
                System.out.println("team 2 win");
                break;
            }

//            game.team1[0].health = 0;
//            game.team1[2].health = 0;
//            game.team2[2].health = 0;
//            game.team1[2].health = 0;
            if(game.team2[0].getHealth() <= 0 && game.team2[1].getHealth() <= 0 && game.team2[2].getHealth() <= 0){
                game.win = true;
                System.out.println("team 1 win");
                break;
            }
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }


//        System.out.println("mainmethod ended");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(game.team2[0].isAlive());
//        System.out.println(game.team2[1].isAlive());
//        System.out.println(game.team2[2].isAlive());
//        System.out.println(game.team1[0].isAlive());
//        System.out.println(game.team1[1].isAlive());
//        System.out.println(game.team1[2].isAlive());

//        Random randomStep = new Random();
//        Random randomHealing = new Random();
//        int round = 3;




//        for (int j = 0; j < round; j++) {
//            for (int i = 0; i < team1.length; i++) {
//                if(randomStep.nextInt(2) == 0) {
//                    if(team1[i] instanceof Doctor) {
//                        team1[i].healing(team1[randomHealing.nextInt(2)]);
//                    } else {
//                        team1[i].hit(team2[i]);
//                    }
//                } else {
//                    if(team2[i] instanceof Doctor) {
//                        team2[i].healing(team2[randomHealing.nextInt(2)]);
//                    } else {
//                        team2[i].hit(team1[i]);
//                    }
//                }
//            }
//        }

//        System.out.println("---------------");
//
//        for (Hero t1: team1) {
//            t1.info();
//        }
//
//        for (Hero t2: team2) {
//            t2.info();
//        }

    }

}
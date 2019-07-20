package Lesson_2.Game;

import java.util.Random;

class Warrior extends Hero {

    Random random = new Random();


    public Warrior(Game game, int health, String type, int damage, int addHeal) {
        super( game, health, type, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                hero.causeDamage(damage);
            }
            System.out.println(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }

    @Override
    public void run() {
        super.run();
        Hero opponent;
        while(!game.win && health > 0) {
            opponent = opponents[random.nextInt(3)];
            if (opponent.getHealth() > 0) {
                hit(opponent);
            }
        }
        System.out.println(this.name + " dead");
    }

}

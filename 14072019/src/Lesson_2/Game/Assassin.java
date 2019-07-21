package Lesson_2.Game;

import java.util.Random;

class Assassin extends Hero {
    int criticalHit;
    Random random = new Random();

    public Assassin(Game game, int heal, String name, int damage, int addHeal) {
        super(game, heal, name, damage, addHeal);
        this.criticalHit = random.nextInt(20);
    }

    @Override
    void hit(Hero hero) {
        if (health < 0) {
                System.out.println("Герой погиб и бить не может!");
        } else {
            hero.causeDamage(damage + criticalHit);
        }
            System.out.println(this.name + " нанес урон " + hero.name);
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }

    @Override
    public void run() {
        super.run();
        Hero opponent;
        while (health > 0 && !game.win) {
            opponent = opponents[random.nextInt(3)];
            if (opponent.getHealth() > 0) {
                hit(opponent);
            }
        }
        System.out.println(this.name + " dead");
    }
}
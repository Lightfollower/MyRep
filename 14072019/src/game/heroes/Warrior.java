package Game.heroes;

import Game.Game;

import java.util.List;
import java.util.Random;

public class Warrior extends Hero {

    Random random = new Random();


    public Warrior(Game game, int health, String name, int damage, int addHeal, List<Hero> allies, List<Hero> opponents) {
        super(game, health, name, damage, addHeal, allies, opponents);
    }

    @Override
    void hit(Hero hero) {
        if (health < 0) {
            System.out.println("Герой погиб и бить не может!");
            game.application.log.appendText("Герой погиб и бить не может!\n");
        } else {
            hero.causeDamage(damage);
        }
        System.out.println(this.name + " нанес урон " + hero.name);
        game.application.log.appendText(this.name + " нанес урон " + hero.name + "\n");
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }

    @Override
    public void run() {

        super.run();

        Hero opponent;
        while (health > 0 && game.isFinished == false) {
            opponent = opponents.get(random.nextInt(opponents.size()));
            if (opponent.getHealth() > 0) {
                hit(opponent);
            }
        }
        if(health <= 0) {
            System.out.println(this.name + " dead");
            game.application.log.appendText(this.name + " dead" + "\n");
        } else {
            System.out.println(this.name + " stayed alive");
        }
    }

}

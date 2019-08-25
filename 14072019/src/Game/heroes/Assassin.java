package Game.heroes;

import Game.Game;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.List;
import java.util.Random;

public class Assassin extends Hero {
    int criticalHit;
    Random random = new Random();

    public Assassin(Game game, int heal, String name, int damage, int addHeal, List<Hero> allies, List<Hero> opponents) {
        super(game, heal, name, damage, addHeal, allies, opponents);
        this.criticalHit = random.nextInt(20);
    }

    @Override
    void hit(Hero hero) {
        if (health < 0) {
            System.out.println("Герой погиб и бить не может!");
            Platform.runLater(() -> game.controller.log.getChildren().add(new Label("Герой погиб и бить не может!\n")));
        } else {
            hero.causeDamage(damage + criticalHit);
        }
        System.out.println(this.name + " нанес урон " + hero.name);
        Platform.runLater(() -> game.controller.log.getChildren().add(new Label(this.name + " нанес урон " + hero.name + "\n")));
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
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


        showState();
    }
}
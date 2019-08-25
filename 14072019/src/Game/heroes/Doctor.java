package Game.heroes;

import Game.Game;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.List;
import java.util.Random;

public class Doctor extends Hero {

    Random random = new Random();


    public Doctor(Game game, int heal, String name, int damage, int addHeal, List<Hero> allies, List<Hero> opponents) {
        super(game, heal, name, damage, addHeal, allies, opponents);
    }

    @Override
    void hit(Hero hero) {
        System.out.println("Доктор не может бить!");
        game.controller.log.getChildren().add(new Label("Доктор не может бить!"));
    }

    @Override
    void healing(Hero hero) {
        hero.addHealth(addHeal);
        System.out.println(String.format("%s heal %s\n", this.name, hero.name));
        Platform.runLater(() -> game.controller.log.getChildren().add(new Label(String.format("%s heal %s\n", this.name, hero.name))));
    }

    @Override
    public void run() {
        super.run();

        Hero ally;
        while (health > 0 && !game.isFinished) {

            ally = allies.get(random.nextInt(allies.size()));
            if (ally.getHealth() > 0) {
                healing(ally);
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        showState();
    }


}
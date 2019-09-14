package Game.heroes;


import Game.Game;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.List;

public abstract class Hero extends Thread {

    Game game;
    List<Hero> allies;
    List<Hero> opponents;
    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;

    public Hero(Game game, int health, String name, int damage, int addHeal, List<Hero> allies, List<Hero> opponents) {
        this.game = game;
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
        this.allies = allies;
        this.opponents = opponents;
    }

    abstract void hit(Hero hero);

    abstract void healing(Hero hero);

    synchronized void causeDamage(int damage) {
        if (health < 0) {
            Platform.runLater(() -> game.controller.log.getChildren().add(new Label("Герой уже мертвый!\n")));
        } else {
            health -= damage;
//            System.out.println(this.name + health);
        }
    }


    void addHealth(int health) {
        this.health += health;
    }

    void showState(){
        if (health <= 0) {
            System.out.println(this.name + " dead");
            Platform.runLater(() -> game.controller.log.getChildren().add(new Label(this.name + " dead" + "\n")));
        } else {
            System.out.println(this.name + " stayed alive\n");
            Platform.runLater(() -> game.controller.log.getChildren().add(new Label(this.name + " stayed alive" + "\n")));
        }
    }
//    void info() {
//
//        System.out.println(name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage);
//    }

//    public void setOpponents(List<Hero> heroes) {
//        this.opponents = heroes;
//    }

//    public void setAllies(List<Hero> allies) {
//        this.allies = allies;
//    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " " + name;
    }
}








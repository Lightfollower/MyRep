package Lesson_2.Game;

import java.util.Random;

class Doctor extends Hero {

    Random random = new Random();



    public Doctor(Game game, int heal, String name, int damage, int addHeal) {
        super(game, heal, name, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        System.out.println("Доктор не может бить!");
    }

    @Override
    void healing(Hero hero) {
        hero.addHealth(addHeal);
        System.out.println(String.format("%s heal %s", this.name, hero.name));
    }

    @Override
    public void run() {
        super.run();
        Hero ally;
        while (health > 0 && !game.win) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ally = allies[random.nextInt(3)];
            if (ally.getHealth() > 0) {
                healing(ally);
            }
        }
        System.out.println(this.name + " dead");
    }


}
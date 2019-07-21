package Lesson_2.Game;


abstract class Hero extends Thread {

    Game game;
    Hero[] allies;
    Hero[] opponents;
    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;

    public Hero(Game game, int health, String name, int damage, int addHeal) {
        this.game = game;
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    abstract void hit(Hero hero);

    abstract void healing(Hero hero);

    void causeDamage(int damage) {
        if(health < 0) {
            System.out.println("Герой уже мертвый!");
        } else {
            health -= damage;
            System.out.println(this.name + health);
        }

    }

    public int getHealth() {
        return health;
    }

    void addHealth(int health) {
        this.health += health;
    }

    void info() {

        System.out.println(name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage);
    }

    public void setOpponents(Hero[] heroes) {
        this.opponents = heroes;
    }

    public void setAllies(Hero[] allies) {
        this.allies = allies;
    }
}








package javaBasics.Lesson5;

import javaBasics.lesson4.Animal;

public class Cat {
    private int id;
    private int appetite;
    private boolean satiety = false;

    public Cat(int id, int ap) {
        appetite = ap;
        this.id = id;
    }

    public void toEat(Bowl bowl) {
        if (bowl.feedTheCat(appetite)) {
            System.out.println(String.format("The cat %s ate %s of food", id, appetite));
            satiety = true;
        } else {
            System.out.println(String.format("Cat %s stayed hungry", id));
        }
    }


    public boolean isSatiety() {
        return satiety;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

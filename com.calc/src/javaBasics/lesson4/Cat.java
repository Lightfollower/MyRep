package javaBasics.lesson4;

public class Cat extends Animal {
    private int id;
    private int appetite = 50;
    private boolean satiety = false;

    public Cat(int runLimit, int swimLimit, float jumpLimit) {
        super(runLimit, swimLimit, jumpLimit);
    }

    public Cat(int runLimit, int swimLimit, float jumpLimit, int id) {
        super(runLimit, 0, jumpLimit);
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

    @Override
    public boolean run(int a) {
        //Можно так:
        System.out.println((a <= runLimit) ? String.format("Cat run %s meters", a) : ("i'am a cat, not a horse"));
        return (a <= runLimit) ? true : false;
    }

    @Override
    public boolean swim(int a) {
        return super.swim(a);
    }

    @Override
    public boolean jump(float a) {
        System.out.println((a <= jumpLimit) ? String.format("Cat jump %s meters", a) : ("i'am a cat, not a kangaroo"));
        return (a <= jumpLimit) ? true : false;
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

package javaBasics.lesson4;

public abstract class Animal {
    protected int runLimit;
    protected int swimLimit;
    protected float jumpLimit;

    public Animal(int runLimit, int swimLimit, float jumpLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
    }

    public boolean run(int a) {
        return false;
    }

    public boolean swim(int a) {
        System.out.println("this animal don't like water");
        return false;
    }

    public boolean jump(float a) {
        return false;
    }
}

package javaBasics.lesson4;

public class Dog extends Animal {

    public Dog(int runLimit, int swimLimit, float jumpLimit) {
        super(runLimit, swimLimit, jumpLimit);
    }

    @Override
    public boolean run(int a) {
        //Лучше так:
        if (a <= runLimit) {
            System.out.println(String.format("Dog run %s meters", a));
            return true;
        } else {
            System.out.println(("I'am a dog, not a horse"));
            return false;
        }
    }


    @Override
    public boolean swim(int a) {
        if (a <= swimLimit) {
            System.out.println(String.format("Dog swim %s meters", a));
            return true;
        } else {
            System.out.println("I'am dog, not a fish");
            return false;
        }
    }

    @Override
    public boolean jump(float a) {
        if (a <= jumpLimit) {
            System.out.println(String.format("Dog jump %s meters", a));
            return true;
        } else {
            System.out.println(("i'am a dog, not a kangaroo"));
            return false;
        }
    }
}
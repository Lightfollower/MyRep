package javaBasics.lesson4;

public class Bowl {
    private int capacity = 200;
    private int fullness = 0;

    public void fill() {
        fullness = capacity;
        System.out.println("Bowl filled");
    }

    public int getFullness() {
        return fullness;
    }

    private void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public boolean feedTheCat(int appetite) {

        if (appetite <= fullness) {
            setFullness(fullness - appetite);
            System.out.println(String.format("%s of food eaten from the bowl, %s left", appetite, fullness));
            return true;
        } else {
            System.out.println("Not enough food");
            return false;
        }
    }
}

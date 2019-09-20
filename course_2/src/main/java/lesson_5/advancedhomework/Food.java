package lesson_5.advancedhomework;

public class Food extends Cargo{
    int volumeRatio = 25;


    public Food(int value) {
        super(value);
    }

    @Override
    public String toString() {
        return super.toString() + "Food{}";
    }
}

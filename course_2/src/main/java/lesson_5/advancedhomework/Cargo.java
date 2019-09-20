package lesson_5.advancedhomework;

public abstract class Cargo {
    int value;

    public Cargo(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "value=" + value +
                '}';
    }
}

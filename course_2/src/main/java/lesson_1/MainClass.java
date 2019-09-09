package java.lesson_1;

import java.util.Arrays;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        String[] strings = {"a", "буй", "йуб"};
        System.out.println(Arrays.asList(shift(strings, 1, 2)));
        Integer[] integers = {1 , 2, 3};
        System.out.println(Arrays.asList(shift(integers, 1, 2)));

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 15; i++) {
            appleBox.addFruit(new Apple());
        }
        for (int i = 0; i < 10; i++) {
            orangeBox.addFruit(new Orange());
        }
        System.out.println(appleBox.compare(orangeBox));

        System.out.println(orangeBox.fruits);
        System.out.println(appleBox.fruits);
        Box<Apple> appleBox1 = new Box<>();
        for (int i = 0; i < 7; i++) {
            appleBox1.addFruit(new Apple());
        }
        System.out.println(appleBox1.fruits);
        appleBox.intersperse(appleBox1);
        System.out.println(appleBox.fruits);
        System.out.println(appleBox1.fruits);
    }

    public static <T> T[] shift(T[] array, int firstIndex, int secondIndex){
        T buffer;
        buffer = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buffer;
        return array;
    }

    public static <T> List<T> arrayToCollection(T[] array){
        return Arrays.asList(array);
    }
}

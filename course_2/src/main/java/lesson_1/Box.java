package java.lesson_1;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    List<T> fruits = new ArrayList();
    public float getWeight(){
        float boxWeight = 0;
        for (T f:
             fruits) {
           boxWeight += f.weight;
        }
        return boxWeight;
    }

    public boolean compare(Box anotherBox){
        return this.getWeight() == anotherBox.getWeight() ? true : false;
    }

    public void intersperse(Box<T> anotherBox){
        for (T f :
                fruits) {
            anotherBox.fruits.add(f);
        }
        fruits.clear();
    }

    public void addFruit(T fruit){
        fruits.add(fruit);

    }

}


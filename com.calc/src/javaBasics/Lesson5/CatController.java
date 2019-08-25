package javaBasics.Lesson5;

public class CatController {
    public static void main(String[] args) {
        Cat[] cats = new Cat[7];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(i, i*2);
        }
        Bowl bowl = new Bowl();
        bowl.fill();
        for (int i = 0; i < cats.length; i++) {
            cats[i].toEat(bowl);
            if (!cats[i].isSatiety()) {
                System.out.println("This cat will be back");
                bowl.fill();
                i--;
            }
            System.out.println();
        }
    }
}


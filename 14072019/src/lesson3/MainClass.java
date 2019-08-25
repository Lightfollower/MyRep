package lesson3;

import jdk.nashorn.api.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class MainClass {
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            list.add("sdf" + i);
        }
        for (String i : list
                ) {
            System.out.println(i);
        }
        list.remove("sdf3");

        for (String i : list
                ) {
            System.out.println(i);
        }

        String a = "Asd";

        String b = new String("Asd");

        System.out.println(a.equals(b));


        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Asd", 1);
        hashMap.put("asdh", 2);
        hashMap.put("asds", 3);
        hashMap.put(new String("Asd"), 4);
        System.out.println(hashMap);
        TreeSet<Zalupa> treeSet = new TreeSet<>(/*new Comparator<Zalupa>() {
            @Override
            public int compare(Zalupa o1, Zalupa o2) {
                return o2.length - o1.length;
            }
        }*/);
        for (int i = 0; i < 5; i++) {
            treeSet.add(new Zalupa(i, "zalupka-" + i));
        }
        System.out.println(treeSet);

    }
}

class Zalupa /*implements Comparable<Zalupa>*/ {
    int length;
    String name;

    public Zalupa(int length, String name) {
        this.length = length;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + length;
    }

    /*@Override
    public int compareTo(Zalupa o) {
        return this.length - o.length;
    }*/
}

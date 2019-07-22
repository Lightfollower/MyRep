package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, int number) {
        if (!phoneBook.containsKey(name))
            phoneBook.put(name, new ArrayList<Integer>());

        phoneBook.get(name).add(number);
    }

    public ArrayList<Integer> get(String name) {
        System.out.println(phoneBook.get(name));
        return phoneBook.get(name);
    }

}

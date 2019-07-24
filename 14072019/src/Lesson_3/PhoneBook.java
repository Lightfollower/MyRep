package Lesson_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneBook {
    Map<String, HashSet<Integer>> phoneBook = new HashMap<>();

    public void add(String name, int number) {
        if (!phoneBook.containsKey(name))
            phoneBook.put(name, new HashSet<Integer>());

        phoneBook.get(name).add(number);
    }

    public HashSet<Integer> get(String name) {
        System.out.println(phoneBook.get(name));
        return phoneBook.get(name);
    }

}

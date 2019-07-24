package Lesson_3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainClass {
    public static void main(String[] args) {
        String[] strings = new String[10];
        strings[0] = "Слово";
        strings[1] = "неСлово";
        strings[2] = "заСлово";
        strings[3] = "злоСлово";
        strings[4] = "недоСлово";
        strings[5] = "Слово";
        strings[6] = "чесСлово";
        strings[7] = "последнееСлово";
        strings[8] = "Слово";
        strings[9] = "нетоСлово";
        Map<String, Integer> words = new HashMap<>();
        for (String s :
                strings) {
            Integer value = words.get(s);
            words.put(s, (value==null ? 1:value + 1));
        }
        System.out.println(words);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Vasya", 123);
        phoneBook.add("Kolya", 987);
        phoneBook.add("Kolya", 555);

        phoneBook.get("Kolya");
    }



}

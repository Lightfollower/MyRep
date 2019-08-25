package html;
import java.util.Arrays;

public class MainClass {
    static String[] a = {"a\n" +
            "b" +
            "c" +
            "d"};

    public static void main(String[] args) {
        Arrays.asList(a).forEach(System.out::print);
        Arrays.asList(a).forEach(System.out::println);
    }
}

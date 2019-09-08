package lesson_6;


import java.util.Arrays;

public class MainClass {

    public static int[] lastFourTrimmer (int... ints){
        int lastIndexOfFour = -1;
        for (int i = 0; i < ints.length; i++) {
            if(ints[i] == 4)
            lastIndexOfFour = i;
        }
        if (lastIndexOfFour == -1)
            throw new RuntimeException("there is nothing left to trim");
        return Arrays.copyOfRange(ints, lastIndexOfFour + 1, ints.length);
    }
    public static void main(String[] args) {
        int[] ints = {1, 3, 2, 3, 6, 3};
        int[] resultArray = lastFourTrimmer(ints);
        for (int i :
                resultArray) {
            System.out.println(i);
        }
    }

}

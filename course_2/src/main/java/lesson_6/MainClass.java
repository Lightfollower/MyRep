package lesson_6;


import java.util.Arrays;

public class MainClass {

    public static int[] lastFourTrimmer(int... ints) {
        int lastIndexOfFour = -1;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 4)
                lastIndexOfFour = i;
        }
        if (lastIndexOfFour == -1)
            throw new RuntimeException("there is nothing left to trim");
        return Arrays.copyOfRange(ints, lastIndexOfFour + 1, ints.length);
    }

    public static boolean oneFourArrayValidator(int... ints) {
        boolean numberOneIsPresent = false;
        boolean numberFourIsPresent = false;
        for (int i :
                ints) {
            if (i == 1)
                numberOneIsPresent = true;
            if(i == 4)
                numberFourIsPresent = true;
            if (i != 1 && i != 4)
                return false;
        }
        return numberFourIsPresent && numberOneIsPresent;
    }

    public static void main(String[] args) {
        System.out.println(oneFourArrayValidator(0,1,4));
    }

}

package Lesson_2;

public class ArraySumCalculator {
    public static void main(String[] args) {
        String[][] strings1 = {{"3", "2", "2", "2"}, {"3", "4", "3", "3"}, {"3", "3", "3", "3"}, {"3", "3", "3", "3"}};
        String[][] strings2 = {{"3", "2", "2", "2"}, {"3", "4", "3", "3"}, {"3", "3", "3", "3"}, {"3", "3r", "3", "3"}};
        String[][] strings3 = {{"3", "2", "2", "2"}, {"3", "4", "3"}, {"3", "3", "3", "3"}, {"3", "3", "3", "3"}};
        try {
            System.out.println(sumUpArray(strings1));
        } catch (Exception e) {
            System.out.println("Array not accepted");
            e.printStackTrace();
        }
        try {
            System.out.println(sumUpArray(strings2));
        } catch (Exception e) {
            System.out.println("Array not accepted");
            e.printStackTrace();
        }
        try {
            System.out.println(sumUpArray(strings3));
        } catch (
                Exception e)
        {
            System.out.println("Array not accepted");
            e.printStackTrace();
        }

    }

    public static int sumUpArray(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        if (strings.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] s :
                strings) {
            if (s.length != 4) {
                throw new MyArraySizeException();

            }
        }
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                if (strings[i][j] != null && strings[i][j].matches("\\d+")) {
                    sum += Integer.parseInt(strings[i][j]);
                } else throw new MyArrayDataException(j, i);
            }
        }
        return sum;
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        System.err.println("Your array is of the illegal size");
    }
}

class MyArrayDataException extends Exception {
    private int x;
    private int y;

    public MyArrayDataException(int x, int y) {
        this.x = x;
        this.y = y;
        System.err.println(String.format("The array contains invalid data in cell [%s] [%s].", y, x));
    }
}
package javaBasics.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lesson2 {
    public static int[] arrayShifter(int[] array, int n) {
        //Так и не получилась магия с коллекциями:-(
        Collections.rotate(Arrays.asList(array),1);
        return array;
    }

    public static void checkBalance(int[] array) {
        int sum = 0;
        int sumBackward = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            sumBackward += array[i];
            sum -= array[i];
            if (sumBackward == sum) System.out.println(String.format("Равенство между позициями %s и %s", i, i + 1));
        }
    }

    public static void showArray(int[] array) {
        for (int i :
                array) {
            System.out.print(i + " ");
        }
        System.out.println("\r");
    }

    public static void main(String[] args) {

        //Целочисленный массив
        System.out.println("Замена 0 и 1");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            //Если бы чисел было больше 2, использовал бы Switch.
            array[i] = array[i] == 0 ? 1 : 0;
        }

        showArray(array);
        System.out.println();

        //Заполнение пустого массива
        System.out.println("Заполнение массива:");
        array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = (i) * 3;
        }
        showArray(array);
        System.out.println();

        //Умножение маленьких членов на 2
        System.out.println("Умножение выборочное");
        array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] = array[i] * 6;
        }
        showArray(array);

        //квадратный двумерный целочисленный массив
        int[][] squareArray = new int[10][10];
        for (int i = 0; i < squareArray.length; i++) {
            System.out.println();
            for (int j = 0; j < squareArray[i].length; j++) {
                if (j == i)
                    squareArray[i][j] = 1;
                System.out.print(squareArray[i][j]);
            }
        }
        System.out.println("\n");
        //минимальный и максимальный элементы
        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, -8, 0, 5};
        int max = array[0];
        int min = array[0];
        for (int a :
                array) {
            if (a > max) max = a;
            if (a < min) min = a;
        }
        System.out.println(String.format("max = %s, min = %s", max, min));
        System.out.println();
        //checkBalance
        array = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1};
        System.out.println("В массиве: ");
        showArray(array);
        checkBalance(array);
        System.out.println();
        //метод, которому на вход подается одномерный массив и число n
        array = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("Смещение массива (не работает)");
        showArray(arrayShifter(array, 2));
        //Не работает.
    }
}

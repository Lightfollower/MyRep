package lesson_6.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static int[] arrayShifter(int[] array, int n) {
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
            if (sumBackward == sum) System.out.println(String.format("Р Р°РІРµРЅСЃС‚РІРѕ РјРµР¶РґСѓ РїРѕР·РёС†РёСЏРјРё %s Рё %s", i, i + 1));
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

        //Р¦РµР»РѕС‡РёСЃР»РµРЅРЅС‹Р№ РјР°СЃСЃРёРІ
        System.out.println("Р—Р°РјРµРЅР° 0 Рё 1");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            //Р•СЃР»Рё Р±С‹ С‡РёСЃРµР» Р±С‹Р»Рѕ Р±РѕР»СЊС€Рµ 2, РёСЃРїРѕР»СЊР·РѕРІР°Р» Р±С‹ Switch.
            array[i] = array[i] == 0 ? 1 : 0;
        }

        showArray(array);
        System.out.println();

        //Р—Р°РїРѕР»РЅРµРЅРёРµ РїСѓСЃС‚РѕРіРѕ РјР°СЃСЃРёРІР°
        System.out.println("Р—Р°РїРѕР»РЅРµРЅРёРµ РјР°СЃСЃРёРІР°:");
        array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = (i) * 3;
        }
        showArray(array);
        System.out.println();

        //РЈРјРЅРѕР¶РµРЅРёРµ РјР°Р»РµРЅСЊРєРёС… С‡Р»РµРЅРѕРІ РЅР° 2
        System.out.println("оллоло");
        array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] = array[i] * 6;
        }
        showArray(array);

        //РєРІР°РґСЂР°С‚РЅС‹Р№ РґРІСѓРјРµСЂРЅС‹Р№ С†РµР»РѕС‡РёСЃР»РµРЅРЅС‹Р№ РјР°СЃСЃРёРІ
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
        //РјРёРЅРёРјР°Р»СЊРЅС‹Р№ Рё РјР°РєСЃРёРјР°Р»СЊРЅС‹Р№ СЌР»РµРјРµРЅС‚С‹
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
        System.out.println("Р’ РјР°СЃСЃРёРІРµ: ");
        showArray(array);
        checkBalance(array);
        System.out.println();
        //РјРµС‚РѕРґ, РєРѕС‚РѕСЂРѕРјСѓ РЅР° РІС…РѕРґ РїРѕРґР°РµС‚СЃСЏ РѕРґРЅРѕРјРµСЂРЅС‹Р№ РјР°СЃСЃРёРІ Рё С‡РёСЃР»Рѕ n
        array = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("РЎРјРµС‰РµРЅРёРµ РјР°СЃСЃРёРІР° (РЅРµ СЂР°Р±РѕС‚Р°РµС‚)");
        showArray(arrayShifter(array, 2));
        //РќРµ СЂР°Р±РѕС‚Р°РµС‚.
    }
}
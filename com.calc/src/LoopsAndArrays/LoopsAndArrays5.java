package LoopsAndArrays;

public class LoopsAndArrays5 {
    public static void main(String[] args) {
        int[] num = {10, 40, 30,0,-1000, 20, 50, 57, 64, 25};
        int max = num[0];
        int min = num[0];

        for (int a = 0; a < num.length; a++) {
            if (max > num[a]) {
                max = num[a];
            }
        if (min< num [a]){
            min= num [a];
        }
        }
        System.out.println(max +" minimum ");
        System.out.println(min + " maximum");
    }
}

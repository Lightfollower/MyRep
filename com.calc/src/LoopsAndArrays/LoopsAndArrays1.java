package LoopsAndArrays;

public class LoopsAndArrays1 {
    public static void main (String [] args){
        int[] arrays = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int a=0; a < arrays.length; a++){
            System.out.println(arrays [a]);
        }
        for (int a=0; a < arrays.length; a++){
            if (arrays [a]==1){
                arrays [a] =0;
            }
            else {
                arrays [a] =1;
            }
        }
        for (int a=0; a < arrays.length; a++){
            System.out.println( arrays [a] );
        }
    }
}

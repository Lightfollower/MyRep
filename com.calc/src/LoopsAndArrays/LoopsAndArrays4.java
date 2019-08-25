package LoopsAndArrays;

public class LoopsAndArrays4 {
    public static void main(String[] args) {
        int c=1;
        int [] [] table = new int [20][20];
        for (int a=0; a < table.length; a++) {
            for (int b=0; b < table[a].length; b ++){
                if(a==b){
                table [a][b] = c;
                }
        }
        }
   printArr(table);
}
public static void printArr (int[][]arr){
    for (int a=0; a < arr.length; a++) {
        for (int b=0; b < arr[a].length; b ++){
            System.out.print(arr[a][b] + "\t");
        }
        System.out.println();
    }
    }
}

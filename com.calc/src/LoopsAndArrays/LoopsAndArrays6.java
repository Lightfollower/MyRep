package LoopsAndArrays;

public class LoopsAndArrays6 {
    public static void main (String [] args) {
        int[] arr = {1,1,1,1,1,5 };
        int midle = arr.length/2 ;
        int left=0;
        int righ=0;
        for (int i = 0; i < arr.length; i++) {
            if (i < midle ){
                left=left+arr[i];
            }
            else {
                righ=righ+arr[i];
            }
            System.out.println(left+ "\t"+ righ);
        }
        if (left==righ){
            System.out.println("True");
        }
        else {
            System.out.println(" False ");
        }
        }
}

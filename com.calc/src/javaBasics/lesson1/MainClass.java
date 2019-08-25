package javaBasics.lesson1;

public class MainClass {
        public static void main(String[] args) {
        int i = 0;
        double d = 0d;
        long l = 0L;
        String s = "dfg0";
        boolean b = true;
        short sh = 0;
        float f = 0f;
        char c = 'a';
        byte bt= 127;

        String[] a = new String[2];

        System.out.println(calculate(5,6,8,9));
        System.out.println("\r");

        System.out.println(compare(5,1));
        System.out.println(compare(5,5));
        System.out.println(compare(10,10));
        System.out.println(compare(10,11));
        System.out.println("\r");

        compareWithZero(1);
        compareWithZero(0);
        compareWithZero(-1);
        System.out.println("\r");

        System.out.println(isNegative(1));
        System.out.println(isNegative(0));
        System.out.println(isNegative(-1));
        System.out.println("\r");

        greetings("username");
        System.out.println("\r");

        isMeatAndBoneYear(0);
        isMeatAndBoneYear(4);
        isMeatAndBoneYear(8);
        isMeatAndBoneYear(100);
        isMeatAndBoneYear(104);
        isMeatAndBoneYear(400);
        isMeatAndBoneYear(404);
        isMeatAndBoneYear(500);
    }

    public static int calculate(int a, int b , int c , int d){
        return  a * (b + (c / d));
    }

    public static boolean compare(int a, int b){
        int c = a+b;
        if (c>=10 && c<=20)
        return true;
        return false;
    }

    public static void compareWithZero(int i){
        System.out.println(i>=0 ? "Положительное": "Отрицательное");
    }

    public static boolean isNegative (int i){
        return true ? i < 0 : false;
    }

    public  static void greetings(String s ){
        System.out.println(String.format("Привет, %s!", s));
    }

    public static void isMeatAndBoneYear(int year){
        if (((year % 4 == 0) && year % 100 !=0)||year % 400 == 0 )
            System.out.println(String.format("Год %s мясокостный", year));
    }

}

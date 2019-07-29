package lesson_5;

public class MainClass {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        fillArrayWithOneThread();
        fillArrayWithTwoThreads();
    }

    static public void fillArrayWithOneThread() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One: " + (System.currentTimeMillis() - startTime));
    }

    static public void fillArrayWithTwoThreads() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long startTime = System.currentTimeMillis();

        float[] tempArr_1 = new float[h];
        float[] tempArr_2 = new float[h + size % 2];
        new Thread(() -> {
            System.arraycopy(arr, 0, tempArr_1, 0, tempArr_1.length);
            for (int i = 0; i < tempArr_1.length; i++) {
                tempArr_1[i] = (float) (tempArr_1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(tempArr_1, 0, arr, 0, tempArr_1.length);
            System.out.println("Two-1: " + (System.currentTimeMillis() - startTime));

        }).start();

        new Thread(() -> {
            System.arraycopy(arr, h, tempArr_2, 0, tempArr_2.length);
            for (int i = 0; i < tempArr_2.length; i++) {
                tempArr_2[i] = (float) (tempArr_2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(tempArr_2, 0, arr, h, tempArr_2.length);
            System.out.println("Two-2: " + (System.currentTimeMillis() - startTime));

        }).start();
    }

}

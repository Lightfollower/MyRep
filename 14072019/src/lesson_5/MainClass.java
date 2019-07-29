package lesson_5;

import Lesson_1.Marathon.Main;

public class MainClass {

    final int size = 10000000;
    float[] arr = new float[size];
    int numberOfThreads;
    Thread[] threads;
    float[][] tempArrays;

    public MainClass(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        threads = new Thread[numberOfThreads];
        tempArrays = new float[numberOfThreads][];
    }

    public static void main(String[] args) {
        MainClass mainClass = new MainClass(171);
        mainClass.fillArrayWithOneThread();
        mainClass.fillArrayWithFewThreads();
    }

    public void fillArrayWithOneThread() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One: " + (System.currentTimeMillis() - startTime));
    }

    public void fillArrayWithFewThreads() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfThreads; i++) {
            int iteration = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (iteration == numberOfThreads - 1 && arr.length % numberOfThreads != 0) {
                        tempArrays[iteration] = new float[arr.length / numberOfThreads + arr.length % numberOfThreads];
                    } else {
                        tempArrays[iteration] = new float[arr.length / numberOfThreads];
                    }
                    System.arraycopy(arr, iteration * (arr.length / numberOfThreads),
                            tempArrays[iteration], 0, tempArrays[iteration].length);
                    for (int i = 0; i < tempArrays[iteration].length; i++) {
                        tempArrays[iteration][i] = (float) (tempArrays[iteration][i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                    System.arraycopy(tempArrays[iteration], 0, arr, tempArrays[0].length * iteration, tempArrays[iteration].length);
                }
            });
        }
        for (Thread t :
                threads) {
            t.start();
        }
        for (Thread t :
                threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(numberOfThreads + " " + (System.currentTimeMillis() - startTime));

    }
}

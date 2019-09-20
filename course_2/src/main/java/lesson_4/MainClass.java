package lesson_4;

import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    static int turn = 0;

    public static void main(String[] args) {
        createAndRunThreads(new char[]{'a', 'b', 'c', 'd', 'e' , 'f'});
    }

    public static void createAndRunThreads(char... chars) {
        for (int i = 0; i < chars.length; i++) {
            int iteration = i;
            new Thread(new Runnable() {
                int number = iteration;

                char letter = chars[iteration];
                @Override
                public void run() {
                    synchronized (System.out) {
                        for (int j = 0; j < 5; j++) {
                        while (turn != iteration) {
                            try {
                                System.out.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                            System.out.println(letter);
                            turn  = (number == chars.length - 1) ? 0 : number + 1;
                            System.out.notifyAll();
                        }
                    }
                }
            }).start();
        }
    }
}

package lesson_5.advancedhomework;

import java.util.concurrent.Semaphore;

public class Strait {
    Semaphore straitSemaphore;

    public Strait(int straitWidth) {
        straitSemaphore = new Semaphore(straitWidth);
    }

    public void swimThrough(Ship ship) throws InterruptedException {
        straitSemaphore.acquire();
        System.out.println(ship + " entered in the strait");
        Thread.sleep(500);
        System.out.println(ship + " came out the strait");
        straitSemaphore.release();

    }
}

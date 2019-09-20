package lesson_5.advancedhomework;

import java.util.concurrent.Semaphore;

public class Port{
    Sea sea;
    String cargo;
    int volumeRatio;
    Semaphore dockSemaphore;
    int stock;

    public Port(int loadingDockSize, Sea sea) {
        cargo = "Empty";
        dockSemaphore = new Semaphore(loadingDockSize);
        this.sea = sea;
    }

    public Port(int loadingDockSize, String cargo, int volumeRatio, Sea sea) {
        this.cargo = cargo;
        this.volumeRatio = volumeRatio;
        stock = 1000;
        dockSemaphore = new Semaphore(loadingDockSize);
        this.sea = sea;
    }

    public void load(Ship ship) throws InterruptedException {
        dockSemaphore.acquire();
        System.out.println(ship + " loading in the " + this);
        Thread.sleep(500);
        ship.cargo = new String(cargo);
        ship.amountOfCargo = volumeRatio;
        stock-=volumeRatio;
        if(stock < volumeRatio)
            ship.sea.portsAvailable.decrementAndGet();
        System.out.println(ship + " finished loading in the " + this);
        dockSemaphore.release();
        System.out.println(this + " " + stock);

    }

    public void unload(Ship ship) throws InterruptedException {
        dockSemaphore.acquire();
        System.out.println(ship + " unloading in the " + this);
        Thread.sleep(1000);
        ship.amountOfCargo = 0;
        System.out.println(ship + " finished unloading in the " + this);
        dockSemaphore.release();
    }

    @Override
    public String toString() {
        return  cargo == "Empty"? "discharge port": cargo + " port";
    }
}

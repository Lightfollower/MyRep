package lesson_5.advancedhomework;

public class Ship implements Runnable {
    int shipNumber;
    Sea sea;
    String cargo;
    int amountOfCargo;

    public Ship(Sea sea, int shipNumber) {
        this.shipNumber = shipNumber;
        this.sea = sea;
        cargo = "Empty";
        amountOfCargo = 0;
    }

    @Override
    public void run() {
        while (!sea.portsAvailable.equals(0)) {
            for (Port p :
                    sea.ports
                    ) {
                if (p.stock >= p.volumeRatio) {
                    if (p.dockSemaphore.availablePermits() > 0) {
                        System.out.println("Loading without waiting");
                        try {
                            p.load(this);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            System.out.println(this + " " + amountOfCargo);


            if (amountOfCargo == 0) {
                System.out.println("waiting");
                int numberOfShortestQueue = 0;
                int shortestQueueLength = sea.ports[0].dockSemaphore.getQueueLength();
                for (int i = 1; i < sea.ports.length; i++) {
                    if ((sea.ports[i].dockSemaphore.getQueueLength() < shortestQueueLength) &&
                            (sea.ports[i].stock >= sea.ports[i].volumeRatio)) {
                        numberOfShortestQueue = i;
                    }
                }
                try {
                    if (sea.ports[numberOfShortestQueue].stock >= sea.ports[numberOfShortestQueue].volumeRatio) {
                        sea.ports[numberOfShortestQueue].load(this);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                sea.strait.swimThrough(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                sea.destinationPort.unload(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this + " " + amountOfCargo);

            try {
                sea.strait.swimThrough(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Ship " + shipNumber;
    }
}

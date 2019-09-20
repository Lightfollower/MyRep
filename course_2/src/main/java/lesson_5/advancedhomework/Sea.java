package lesson_5.advancedhomework;


import java.util.concurrent.atomic.AtomicInteger;

public class Sea {
    Ship[] ships;
    Port[] ports;
    Port destinationPort;
    Strait strait;
    AtomicInteger portsAvailable = new AtomicInteger();

    public Sea() {
        ships = new Ship[10];
        for (int i = 0; i < 10; i++) {
            ships[i] = new Ship(this, i);
        }
        ports = new Port[]{new Port(1, "Fuel", 100, this),
                new Port(1, "Clothes", 50, this),
                new Port(1, "Food", 25, this)};
        destinationPort = new Port(2, this);
        strait = new Strait(2);
        for (Ship s :
                ships) {
            new Thread(s).start();
        }
        portsAvailable.set(ports.length);
    }

    public static void main(String[] args) {
        new Sea();
    }

}

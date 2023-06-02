package antship;

import java.io.*;
import java.lang.Thread;

// Starts up multiple ships through threading
public class BatchStarter {
    // Number of ant ships to start
    static int batchSize = 10;

    // Ip to connect each ant ship to.
    static String ip = "127.0.1.1";

    static int millisecondDelayBetweenDelay = 100;


    public static void main(String[] args) {
        for (int i = 1; i < batchSize + 1; i++) {
            AntShipInstance object = new AntShipInstance(ip, i);
            try {
                Thread.sleep(millisecondDelayBetweenDelay);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            object.start();
        }
    }
}

class AntShipInstance extends Thread {

    // Connect to this ip
    String ip;

    // Name to give ship.
    String name;

    public AntShipInstance(String ipToConnect, int num) {
        this.ip = ipToConnect;
        this.name = "antboat" + num;
    }

    public void run() {
        try {
            System.out.println("Started ant ship.");
            new DragonsLairShip(ip, name);
        }
        catch (Exception e) {
            System.out.println("Caught exception");
        }
    }
}

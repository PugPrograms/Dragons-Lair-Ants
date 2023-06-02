package antship;

import java.awt.*;
import java.io.*;
import java.lang.Thread;

// Starts up multiple ships through threading
public class BatchStarter {
    // Number of ant ships to start
    static int batchSize = 10;

    // Ship settings
    static String ip = "127.0.1.1";
    static Color desiredColor = new Color(243, 0, 255);
    static int desiredSkin = 6;

    static int millisecondDelayBetweenDelay = 100;


    public static void main(String[] args) {
        for (int i = 1; i < batchSize + 1; i++) {
            AntShipInstance object = new AntShipInstance(ip, i, desiredColor, desiredSkin);
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

    // Skin to set for this current ship.
    int skin;

    // Color for the username for this ship.
    Color color;

    public AntShipInstance(String ipToConnect, int num, Color color, int skin) {
        this.ip = ipToConnect;
        this.name = "antboat" + num;
        this.skin = skin;
        this.color = color;
    }

    public void run() {
        try {
            System.out.println("Started ant ship.");
            new DragonsLairShip(ip, name, color, skin);
        }
        catch (Exception e) {
            System.out.println("Caught exception");
        }
    }
}

package antship;
// Starts up multiple ships through threading
public class BatchStarter {
    // Number of ant ships to start
    static int batchSize = 3;

    // Ip to connect each ant ship to.
    static String ip = "127.0.1.1";
    public static void main(String[] args) {
        for (int i = 0; i < batchSize; i++) {
            AntShipInstance object
                    = new AntShipInstance(ip, i);
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
        this.name = "ant" + num;
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

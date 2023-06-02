import java.awt.Color;

import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;

public class DragonsLairShip extends BasicSpaceship {
   // Global reference to ship
   ObjectStatus ship;

   // Global reference to game info
   BasicGameInfo gameInfo;

   // Minimum speed to cruise at all times.
   double minimumSpeed = 20d;

   // Ip to join to.
   static String desiredIp = "10.40.30.77";
   
   public static void main(String[] args) {
      TextClient.run(desiredIp, new DragonsLairShip());
   }

   @Override
   public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight) {
      // parameters are ship name, color of ship text (RGB), and index of image
      return new RegistrationData("Ant Boat", new Color(255, 255, 255), 6);
   }

   @Override
   public ShipCommand getNextCommand(BasicEnvironment env) {
      ship = env.getShipStatus();
      gameInfo = env.getGameInfo();

      // Check our speed.
      var speedChecker = SpeedChecker();
      if (speedChecker != null) return speedChecker;


      // If nothing happens, simpy idle.
      return new IdleCommand(0.1);
   }

   // Function to check if we are at the minimum speed, if not, accelerate up to it.
   public ShipCommand SpeedChecker() {
      System.out.println(ship.getSpeed());
      if (ship.getSpeed() < minimumSpeed) {
         return new ThrustCommand('B', 0.1, 1);
      }
      else {
         return null;
      }
   }
}

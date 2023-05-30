import java.awt.Color;

import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;

public class DragonsLairShip extends BasicSpaceship {
   ObjectStatus ship;
   BasicGameInfo gameInfo;
   
   public static void main(String[] args) {
      // "10.40.30.77" is typically the IP address of Mr. Stutler's projector computer
      // "FindTheMiddleShip" is the name of the current class
      TextClient.run("10.40.30.143", new DragonsLairShip());
   }

   @Override
   public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight) {
      // parameters are ship name, color of ship text (RGB), and index of image
      return new RegistrationData("Ant Boat", new Color(255, 255, 255), 6);
   }

   @Override
   public ShipCommand getNextCommand(BasicEnvironment env) {
      // every time getNextCommand() is called, return a command
      // all commands are subclasses of ShipCommand superclass
      ship = env.getShipStatus();
      gameInfo = env.getGameInfo();
      
      var speed = SpeedChecker('B');
      if (speed != null) {
         return speed;
      }
      
      
      return new IdleCommand(0.1);
   }
   
   public ShipCommand SpeedChecker(char dir) {
      System.out.println(ship.getSpeed());
      if (ship.getSpeed() < 100) {
         return new ThrustCommand(dir, 0.1, 1);
      }
      else {
         return null;
      }
   }
}

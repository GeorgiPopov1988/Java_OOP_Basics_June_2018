package polymorphysm.exercises.vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] carTokens = reader.readLine().split(" ");
    double fuelQuantity = Double.parseDouble(carTokens[1]);
    double litersPerKm = Double.parseDouble(carTokens[2]);
    Vehicle car = new Car(fuelQuantity, litersPerKm);
    
    String[] truckTokens = reader.readLine().split(" ");
    fuelQuantity = Double.parseDouble(truckTokens[1]);
    litersPerKm = Double.parseDouble(truckTokens[2]);
    Vehicle truck = new Truck(fuelQuantity, litersPerKm);
    
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    
    int commandsCnt = Integer.parseInt(reader.readLine());
    
    while (commandsCnt-- > 0) {
      
      String[] commandTokens = reader.readLine().split(" ");
      
      String command = commandTokens[0];
      String vehicleType = commandTokens[1];
      double parameter = Double.parseDouble(commandTokens[2]);
      
      switch (command) {
        case "Drive":
          if ("Car".equalsIgnoreCase(vehicleType)) {
            try {
              car.drive(parameter);
              System.out.printf("Car travelled %s km%n", decimalFormat.format(parameter));
            } catch (IllegalArgumentException iae){
              System.out.println(iae.getMessage());
            }
          } else {
            try {
              truck.drive(parameter);
              System.out.printf("Truck travelled %s km%n", decimalFormat.format(parameter));
            } catch (IllegalArgumentException iae){
              System.out.println(iae.getMessage());
            }
          }
          break;
        case "Refuel":
          if ("Car".equalsIgnoreCase(vehicleType)) {
            car.refuel(parameter);
          } else {
            truck.refuel(parameter);
          }
          
          break;
      }
      
    }
    
    System.out.printf("Car: %.2f%n", car.getFuel());
    System.out.printf("Truck: %.2f%n", truck.getFuel());
    
  }
}
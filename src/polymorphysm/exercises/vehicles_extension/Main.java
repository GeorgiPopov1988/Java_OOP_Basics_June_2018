package polymorphysm.exercises.vehicles_extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Vehicle {initial fuel quantity} {liters per km} {tank capacity}
  
    String[] vehicleTokens = reader.readLine().split(" ");
    Vehicle car = createCar(vehicleTokens);
    Vehicle truck = createTruck(reader);
    Vehicle bus = createBus(reader);
    
    int commandsCnt = Integer.parseInt(reader.readLine());
    readCommands(reader, car, truck, bus, commandsCnt);
  
    printFuelLeft(car, truck, bus);
    
  }
  
  private static void readCommands(BufferedReader reader, Vehicle car, Vehicle truck, Vehicle bus, int commandsCnt) throws IOException {
    while (commandsCnt-- > 0) {
      String[] commandTokens = reader.readLine().split(" ");
      String command = commandTokens[0];
      String vehicleType = commandTokens[1];
      double parameter = Double.parseDouble(commandTokens[2]);
  
      getVehicle(car, truck, bus, command, vehicleType, parameter);
  
    }
  }
  
  private static void getVehicle(Vehicle car, Vehicle truck, Vehicle bus, String command, String vehicleType, double
          parameter) {
    switch (vehicleType) {
      case "Car":
        doCommand(car, command, parameter);
        break;
      case "Truck":
        doCommand(truck, command, parameter);
        break;
      case "Bus":
        doCommand(bus, command, parameter);
        break;
    }
  }
  
  private static void printFuelLeft(Vehicle car, Vehicle truck, Vehicle bus) {
    System.out.printf("Car: %.2f%n", car.getFuel());
    System.out.printf("Truck: %.2f%n", truck.getFuel());
    System.out.printf("Bus: %.2f%n",bus.getFuel());
  }
  
  private static void doCommand(Vehicle vehicle, String command, double parameter) {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    switch (command) {
      case "Drive":
        try {
          vehicle.drive(parameter);
          
          System.out.printf("%s travelled %s km%n"
          , vehicle.getClass().getSimpleName(), decimalFormat.format(parameter));
          
        } catch (IllegalArgumentException iae){
          System.out.println(iae.getMessage());
        }
        break;
      case "DriveEmpty":
        vehicle.setConsumption(vehicle.getConsumption() - 1.4);
        
        try {
          vehicle.drive(parameter);
          System.out.printf("%s travelled %s km%n"
                  , vehicle.getClass().getSimpleName(), decimalFormat.format(parameter));
  
        } catch (IllegalArgumentException iae) {
          System.out.println(iae.getMessage());
        }
        
        vehicle.setConsumption(vehicle.getConsumption() + 1.4);
        
        break;
      case "Refuel":
        try {
          vehicle.refuel(parameter);
         // System.out.printf("%s refuel %s km%n"
         //         , vehicle.getClass().getSimpleName(), decimalFormat.format(vehicle.getFuel()));
        } catch (IllegalArgumentException iae) {
          System.out.println(iae.getMessage());
        }
        break;
    }
  }
  
  private static Vehicle createBus(BufferedReader reader) throws IOException {
    String[] vehicleTokens;
    double fuel;
    double consuption;
    double capacity;
    vehicleTokens = reader.readLine().split(" ");
    fuel = Double.parseDouble(vehicleTokens[1]);
    consuption = Double.parseDouble(vehicleTokens[2]);
    capacity = Double.parseDouble(vehicleTokens[3]);
    Vehicle bus = new Bus(fuel, consuption, capacity);
    return bus;
  }
  
  private static Vehicle createTruck(BufferedReader reader) throws IOException {
    String[] vehicleTokens;
    double fuel;
    double consuption;
    double capacity;
    vehicleTokens = reader.readLine().split(" ");
    fuel = Double.parseDouble(vehicleTokens[1]);
    consuption = Double.parseDouble(vehicleTokens[2]);
    capacity = Double.parseDouble(vehicleTokens[3]);
    Vehicle truck = new Truck(fuel, consuption, capacity);
    return truck;
  }
  
  private static Vehicle createCar(String[] vehicleTokens) {
    double fuel = Double.parseDouble(vehicleTokens[1]);
    double consuption = Double.parseDouble(vehicleTokens[2]);
    double capacity = Double.parseDouble(vehicleTokens[3]);
    Vehicle car = new Car(fuel, consuption, capacity);
    return car;
  }
}

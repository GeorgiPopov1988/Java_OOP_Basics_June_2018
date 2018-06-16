package defining_classes.exercises.speed_racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
    Map<String, Car> cars = new LinkedHashMap<>();
  
    fillGarageWithCars(reader, cars);
    ride(reader, cars);
    print(cars);
  
  }
  
  private static void print(Map<String, Car> cars) {
    for (Map.Entry<String, Car> garage : cars.entrySet()) {
      System.out.println(garage.getValue());
    }
  }
  
  private static void ride(BufferedReader reader, Map<String, Car> cars) throws IOException {
    String inLine = reader.readLine();
    while (!"End".equalsIgnoreCase(inLine)) {
      // Drive <CarModel>  <amountOfKm>
      String[] inDriveTokens = inLine.split(" ");
      String model = inDriveTokens[1];
      double traveledKm = Double.parseDouble(inDriveTokens[2]);
      Car car = cars.get(model);
      double neededFuel = car.getFuelPerOneKilometer() * traveledKm;
      
      try {
        car.goTrip(neededFuel, traveledKm);
      } catch (NumberFormatException nfe) {
        System.out.println(nfe.getMessage());
      }
      
      inLine = reader.readLine();
    }
  }
  
  private static void fillGarageWithCars(BufferedReader reader, Map<String, Car> cars) throws IOException {
    int carsCnt = Integer.parseInt(reader.readLine());
    while (carsCnt-- > 0) {
      Car car = null;
      // <Model> <FuelAmount> <FuelCostFor1km>
      String[] carInTokens = reader.readLine().split(" ");
      String model = carInTokens[0];
      double fuelAmount = Double.parseDouble(carInTokens[1]);
      double fuelPerOneKilometer = Double.parseDouble(carInTokens[2]);
      
      car = new Car(model, fuelAmount, fuelPerOneKilometer);
      cars.put(model, car);
    }
  }
}

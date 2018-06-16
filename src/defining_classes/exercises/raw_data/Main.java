package defining_classes.exercises.raw_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
    List<Car> cars = new LinkedList<>();
    
    int carsCnt = Integer.parseInt(reader.readLine());
    createCars(reader, cars, carsCnt);
  
    String commad = reader.readLine();
    print(cars, commad);
  
  }
  
  private static void print(List<Car> cars, String commad) {
    switch (commad) {
      case "fragile":
        cars.stream()
                .filter(c -> c.getTires().stream().filter(t -> t.getPressure() < 1).collect(Collectors.toList()).size()> 0)
                .filter(c -> c.getCargo().getType().equals("fragile"))
        .forEach(c -> System.out.println(c.getModel()));
        break;
      case "flamable":
        cars.stream()
                .filter(c -> c.getCargo().getType().equals("flamable"))
                .filter(c -> c.getEngine().getPower() >= 250)
                .forEach(c -> System.out.println(c.getModel()));
        break;
    }
  }
  
  private static void createCars(BufferedReader reader, List<Car> cars, int carsCnt) throws IOException {
    while (carsCnt-- > 0) {
      // <Model>
      // <EngineSpeed> <EnginePower>
      // <CargoWeight> <CargoType>
      // <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age>
      // <Tire4Pressure> <Tire4Age>
  
      String[] carInTokens = reader.readLine().split(" ");
      String model = carInTokens[0];
  
      Car car = null;
      List<Tire> tires = new ArrayList<>();
      car = createCar(tires, carInTokens, model);
      cars.add(car);
    }
  }
  
  private static Car createCar(List<Tire> tires, String[] carInTokens, String model) {
    Engine engine = createEngine(carInTokens);
    Cargo cargo = createCargo(carInTokens);
    createTires(tires, carInTokens);
    
    Car car = new Car(model, engine, cargo, tires);
    return car;
  }
  
  private static void createTires(List<Tire> tires, String[] carInTokens) {
    for (int i = 5; i < carInTokens.length - 1; i+=2) {
      Tire tire = null;
      double pressure = Double.parseDouble(carInTokens[i]);
      int age = Integer.parseInt(carInTokens[i + 1]);
      tire = new Tire(pressure, age);
      tires.add(tire);
    }
  }
  
  private static Cargo createCargo(String[] carInTokens) {
    Cargo cargo = null;
    int weight = Integer.parseInt(carInTokens[3]);
    String type = carInTokens[4];
    cargo = new Cargo(weight, type);
    return cargo;
  }
  
  private static Engine createEngine(String[] carInTokens) {
    Engine engine = null;
    int speed = Integer.parseInt(carInTokens[1]);
    int power = Integer.parseInt(carInTokens[2]);
    engine = new Engine(speed, power);
    return engine;
  }
}

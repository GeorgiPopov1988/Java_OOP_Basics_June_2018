package defining_classes.exercises.car_salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    int inputCnt = Integer.parseInt(reader.readLine());
    
    Map<String, Engine> engines = new LinkedHashMap<>();
    createEngines(reader, inputCnt, engines);
    
    inputCnt = Integer.parseInt(reader.readLine());
  
    List<Car> cars = new LinkedList<>();
    createCars(reader, inputCnt, engines, cars);
  
    print(cars);
  
  }
  
  private static void print(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(car.toString());
    }
  }
  
  private static void createCars(BufferedReader reader, int inputCnt, Map<String, Engine> engines, List<Car> cars) throws IOException {
    while (inputCnt-- > 0) {
      String[] carInTokens = reader.readLine().split(" ");
      // <Model> <Engine> <Weight> <Color>
      String model = carInTokens[0];
      String engineModel = carInTokens[1];
      Engine engine = engines.get(engineModel);
      
      Car car = new Car(model, engine);
      
      switch (carInTokens.length) {
        case 3:
          try {
            int weight = Integer.parseInt(carInTokens[2]);
            car.setWeight(weight);
          } catch (Exception e) {
            String color = carInTokens[2];
            car.setColor(color);
          }
          break;
        case 4:
          int weight = Integer.parseInt(carInTokens[2]);
          String color = carInTokens[3];
          car.setWeight(weight);
          car.setColor(color);
          break;
      }
      
      cars.add(car);
    }
  }
  
  private static void createEngines(BufferedReader reader, int inputCnt, Map<String, Engine> engines) throws
          IOException {
    while (inputCnt-- > 0) {
      String[] engineInTokens = reader.readLine().split(" ");
      // <Model> <Power> <Displacement> <Efficiency>
      String model = engineInTokens[0];
      int power = Integer.parseInt(engineInTokens[1]);
      
      Engine engine = new Engine(model, power);
      switch (engineInTokens.length) {
        case 3:
          try {
            int displacement = Integer.parseInt(engineInTokens[2]);
            engine.setDisplacement(displacement);
          } catch (Exception e) {
            String efficiency = engineInTokens[2];
            engine.setEfficiency(efficiency);
          }
          break;
        case 4:
          engine.setDisplacement(Integer.parseInt(engineInTokens[2]));
          engine.setEfficiency(engineInTokens[3]);
          break;
      }
      
      engines.put(model, engine);
      
    }
  }
}

package interfaces_and_abstraction.exercises.ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String driverName = reader.readLine();
    Car car = new Ferarri(driverName);
    
    // 488-Spider/Brakes!/Zadu6avam sA!/Bat Giorgi
    System.out.printf("%s/%s/%s/%s", car.getModel(), car.pushBrakes(), car.pushGasPedal(), car.getDriverName());
  }
}

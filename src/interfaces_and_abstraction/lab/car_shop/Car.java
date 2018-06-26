package interfaces_and_abstraction.lab.car_shop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public interface Car {
  int TIRES = 4;
  
  String getModel();
  
  String getColor();
  
  Integer getHorsePower();
  
  class Main {
    public static void main(String[] args) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
      Car seat = new Seat("Leon", "gray", 110, "Spain");
    
      System.out.println(String.format(
              "%s is %s color and have %s horse power",
              seat.getModel(),
              seat.getColor(),
              seat.getHorsePower()));
      System.out.println(seat.toString());
    
    
    
    }
  }
}

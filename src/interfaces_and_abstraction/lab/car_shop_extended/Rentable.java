package interfaces_and_abstraction.lab.car_shop_extended;

public interface Rentable extends Car {
  Integer getMinRentDay();
  Double getPricePerDay();
  
}

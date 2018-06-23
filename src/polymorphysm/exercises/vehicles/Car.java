package polymorphysm.exercises.vehicles;

public class Car extends Vehicle {
  private final static double INCREASED_CAR_CONSUMPTION = 0.9d;
  
  public Car(double fuel, double consumption) {
    super(fuel, consumption + INCREASED_CAR_CONSUMPTION);
  }
  
  @Override
  public void refuel(double fuel) {
    super.setFuel(super.getFuel() + fuel);
  }
  
  @Override
  public void drive(double distance) {
    try {
      super.drive(distance);
  
    }catch (IllegalArgumentException iae) {
      throw new IllegalArgumentException("Car needs refueling");
    }
  }
  
  
}

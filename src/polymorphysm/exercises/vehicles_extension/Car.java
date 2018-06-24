package polymorphysm.exercises.vehicles_extension;

public class Car extends Vehicle {
  private final static double INCREASED_CAR_CONSUMPTION = 0.9d;
  
  public Car(double fuel, double consumption, double tankCapacity) {
    super(fuel, consumption + INCREASED_CAR_CONSUMPTION, tankCapacity);
  }
  
  @Override
  public void refuel(double fuel) {
   super.refuel(fuel);
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

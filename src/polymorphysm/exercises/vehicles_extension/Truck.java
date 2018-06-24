package polymorphysm.exercises.vehicles_extension;

public class Truck extends Vehicle {
  private final static double INCREASED_TRUCK_CONSUMPTION = 1.6d;
  private final static double FUEL_LOSS = 0.95d;
  
  public Truck(double fuel, double consumption, double tankCapacity) {
    super(fuel, consumption + INCREASED_TRUCK_CONSUMPTION, tankCapacity);
  }
  
  @Override
  public void refuel(double fuel) {
    fuel *= INCREASED_TRUCK_CONSUMPTION;
    super.refuel(fuel);
  }
  
  @Override
  public void drive(double distance) {
    try {
      super.drive(distance);
    }catch (IllegalArgumentException iae) {
      throw new IllegalArgumentException("Truck needs refueling");
    }
  }
}

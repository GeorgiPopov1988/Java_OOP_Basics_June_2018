package polymorphysm.exercises.vehicles_extension;

public class Bus extends Vehicle {
  private final static double INCREASED_BUS_CONSUMPTION = 1.4d;
  
  public Bus(double fuel, double consumption, double tankCapacity) {
    super(fuel, consumption + INCREASED_BUS_CONSUMPTION, tankCapacity);
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
      throw new IllegalArgumentException("Bus needs refueling");
    }
  }
}

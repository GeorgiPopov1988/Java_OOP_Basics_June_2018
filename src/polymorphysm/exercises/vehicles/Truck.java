package polymorphysm.exercises.vehicles;

public class Truck extends Vehicle {
  private final static double INCREASED_TRUCK_CONSUMPTION = 1.6d;
  private final static double FUEL_LOSS = 0.95d;
  
  public Truck(double fuel, double consumption) {
    super(fuel, consumption + INCREASED_TRUCK_CONSUMPTION);
  }
  
  @Override
  public void refuel(double fuel) {
    super.setFuel(super.getFuel() + (fuel * FUEL_LOSS));
  }
  
  @Override
  public void drive(double distance) {
    if (super.getFuel() < super.getConsumption() * distance) {
      throw new IllegalArgumentException("Truck needs refueling");
    } else {
      super.setFuel(super.getFuel() - distance * super.getConsumption());
    }
  }
}

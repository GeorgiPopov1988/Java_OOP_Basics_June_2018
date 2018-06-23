package polymorphysm.exercises.vehicles;

public class Truck extends Vehicle {
  private final static double INCREASED_TRUCK_CONSUMPTION = 1.6d;
  private final static double FUEL_LOSS = 0.95d;
  
  
  public Truck(double fuelQuantity, double consumptionLitersPerKm) {
    super(fuelQuantity, consumptionLitersPerKm);
  }
  
  @Override
  protected void setConsumptionLitersPerKm(double consumptionLitersPerKm) {
    this.consumptionLitersPerKm = consumptionLitersPerKm + INCREASED_TRUCK_CONSUMPTION;
  }
  
  @Override
  protected void setFuelQuantity(double fuelQuantity) {
    this.fuelQuantity = fuelQuantity;
  }
  
  @Override
  protected void drive(double distance) {
    try {
      super.drive(distance);
    } catch (IllegalArgumentException iae) {
      throw new IllegalArgumentException("Truck needs refueling");
    }
  }
  
  @Override
  protected void refueled(double liters) {
    this.fuelQuantity = this.fuelQuantity + (liters * FUEL_LOSS);
  }
}

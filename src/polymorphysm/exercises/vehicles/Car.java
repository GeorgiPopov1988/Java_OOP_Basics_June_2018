package polymorphysm.exercises.vehicles;

public class Car extends Vehicle {
  private final static double INCREASED_CAR_CONSUMPTION = 0.9d;
  
  
  public Car(double fuelQuantity, double consumptionLitersPerKm) {
    super(fuelQuantity, consumptionLitersPerKm);
  }
  
  @Override
  protected void setConsumptionLitersPerKm(double consumptionLitersPerKm) {
    this.consumptionLitersPerKm = consumptionLitersPerKm + INCREASED_CAR_CONSUMPTION;
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
      throw new IllegalArgumentException("Car needs refueling");
    }
  }
  
  @Override
  protected void refueled(double liters) {
    this.fuelQuantity += liters;
  }
}

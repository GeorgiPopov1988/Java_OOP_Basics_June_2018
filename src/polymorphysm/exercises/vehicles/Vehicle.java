package polymorphysm.exercises.vehicles;

public abstract class Vehicle {
  
  protected double fuelQuantity;
  protected double consumptionLitersPerKm;
  
  public Vehicle(double fuelQuantity, double consumptionLitersPerKm) {
    this.setFuelQuantity(fuelQuantity);
    this.setConsumptionLitersPerKm(consumptionLitersPerKm);
  }
  
  protected abstract void setConsumptionLitersPerKm(double consumptionLitersPerKm);
  
  protected abstract void setFuelQuantity(double fuelQuantity);
  
  protected abstract void refueled(double liters);
  
  public double getFuel() {
    return this.fuelQuantity;
  }
  
  protected void drive(double distance) {
    if (this.fuelQuantity > distance * this.consumptionLitersPerKm) {
      this.fuelQuantity -= distance * this.consumptionLitersPerKm;
    } else {
      throw new IllegalArgumentException();
    }
  }
}

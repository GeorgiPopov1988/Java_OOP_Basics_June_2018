package polymorphysm.exercises.vehicles;

public abstract class Vehicle {
  private double fuel;
  private double consumption;
  
  public Vehicle(double fuel, double consumption) {
    this.setFuel(fuel);
    this.setConsumption(consumption);
  }
  
  private void setConsumption(double consumption) {
    this.consumption = consumption;
  }
  
  protected void setFuel(double fuel) {
    this.fuel = fuel;
  }
  
  protected double getFuel() {
    return this.fuel;
  }
  
  public abstract void drive(double distance);
  
  public abstract void refuel(double fuel);
  
  protected final double getConsumption() {
    return this.consumption;
  }
}

package polymorphysm.exercises.vehicles_extension;

public abstract class Vehicle {
  private double fuel;
  private double consumption;
  private double capacity;
  
  
  public Vehicle(double fuel, double consumption, double capacity) {
    this.fuel = fuel;
    this.consumption = consumption;
    this.capacity = capacity;
  }
  
  protected void setConsumption(double consumption) {
    this.consumption = consumption;
  }
  
  protected void setFuel(double fuel) {
    this.fuel = fuel;
  }
  
  protected final double getFuel() {
    return fuel;
  }
  
  protected final double getCapacity() {
    return capacity;
  }
  
  protected final double getConsumption() {
    return consumption;
  }
  
  public void drive(double distance){
    if (this.getFuel() < this.getConsumption() * distance) {
      throw new IllegalArgumentException();
    } else {
      this.setFuel(this.getFuel() - distance * this.getConsumption());
    }
  }
  
  public void refuel(double fuel) {
    if (fuel <= 0) {
      throw new IllegalArgumentException("Fuel must be a positive number");
    } else if (this.getFuel() + fuel > this.getCapacity()){
      throw new IllegalArgumentException("Cannot fit fuel in tank");
    } else {
  
      this.setFuel(this.getFuel() + fuel);
    }
  }
}

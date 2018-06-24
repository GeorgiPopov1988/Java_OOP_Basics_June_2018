package polymorphysm.exercises.vehicles_extension;

public abstract class Vehicle {
  private double fuel;
  private double consumption;
  private double tankCapacity;
  
  
  public Vehicle(double fuel, double consumption, double tankCapacity) {
    this.setFuel(fuel);
    this.setConsumption(consumption);
    this.setTankCapacity(tankCapacity);
  }
  
  protected void setConsumption(double consumption) {
    this.consumption = consumption;
  }
  
  protected void setFuel(double fuel) {
    this.fuel = fuel;
  }
  
  protected void setTankCapacity(double tankCapacity) {
    this.tankCapacity = tankCapacity;
  }
  
  protected double getFuel() {
    return this.fuel;
  }
  
  protected double getTankCapacity() {
    return this.tankCapacity;
  }
  
  protected final double getConsumption() {
    return this.consumption;
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
    } else if (this.getFuel() + fuel > this.getTankCapacity()){
      throw new IllegalArgumentException("Cannot fit fuel in tank");
    } else {
  
      this.fuel += fuel;
    }
  }
}

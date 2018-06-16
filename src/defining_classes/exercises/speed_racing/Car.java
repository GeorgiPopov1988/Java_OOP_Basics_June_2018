package defining_classes.exercises.speed_racing;

public class Car {
  private final static double START_DISTANCE = 0.0d;
  
  private String model;
  private double fuelAmount;
  private double fuelPerOneKilometer;
  private double distance;
  
  public Car(String model, double fuelAmount, double fuelPerOneKilometer) {
    this. model = model;
    this.fuelAmount = fuelAmount;
    this.fuelPerOneKilometer = fuelPerOneKilometer;
    this.distance = START_DISTANCE;
  }
  
  public double getFuelPerOneKilometer() {
    return this.fuelPerOneKilometer;
  }
  
  private double getDistance() {
    return this.distance;
  }
  
  private double getFuelAmount() {
    return this.fuelAmount;
  }
  
  private String getModel() {
    return this.model;
  }
  
  public void goTrip(double neededFuel, double traveledKm) {
    if (neededFuel > this.fuelAmount) {
      throw new NumberFormatException("Insufficient fuel for the drive");
    } else {
      this.distance += traveledKm;
      this.fuelAmount -= neededFuel;
    }
  }
  
  @Override
  public String toString() {
    // <Model> <fuelAmount>  <distanceTraveled>
    return String.format("%s %.2f %.0f", this.getModel(), this.getFuelAmount(), this.getDistance());
  }
  
 
}

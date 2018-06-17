package defining_classes.exercises.google;

public class Car {
  private String model;
  private int speed;
  
  public Car(String model, int speed) {
    this.model = model;
    this.speed = speed;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public int getSpeed() {
    return this.speed;
  }
  
  @Override
  public String toString() {
    return String.format("%s %d", this.getModel(), this.getSpeed());
  }
}

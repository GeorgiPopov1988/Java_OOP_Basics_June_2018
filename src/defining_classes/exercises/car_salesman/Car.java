package defining_classes.exercises.car_salesman;

public class Car {
  private String model;
  private Engine engine;
  private int weight;
  private String color;
  
  public Car(String model, Engine engine) {
    this.model = model;
    this.engine = engine;
  }
  
  public Car(String model, Engine engine, int weight, String color) {
    this(model, engine);
    this.weight = weight;
    this.color = color;
  }
  
  public void setWeight(int weight) {
    this.weight = weight;
  }
  
  public void setColor(String color) {
    this.color = color;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public Engine getEngine() {
    return this.engine;
  }
  
  public int getWeight() {
    return this.weight;
  }
  
  public String getColor() {
    return this.color;
  }
  
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(String.format("%s:",this.getModel()));
    stringBuilder.append(System.lineSeparator());
    stringBuilder.append(this.getEngine().toString());
    stringBuilder.append(System.lineSeparator());
    stringBuilder.append(String.format("Weight: %s", this.getWeight() == 0 ? "n/a" : this.getWeight()));
    stringBuilder.append(System.lineSeparator());
    stringBuilder.append(String.format("Color: %s", this.getColor() == null ? "n/a" : this.getColor()));
  
    return stringBuilder.toString();
  }
  
}

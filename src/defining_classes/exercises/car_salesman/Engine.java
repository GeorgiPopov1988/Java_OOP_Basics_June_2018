package defining_classes.exercises.car_salesman;

public class Engine {
  private String model;
  private int power;
  private int displacement;
  private String efficiency;
  
  public Engine(String model, int power) {
    this.model = model;
    this.power = power;
  }
  
  public Engine(String model, int power, int displacement, String efficiency) {
    this(model, power);
    this.displacement = displacement;
    this.efficiency = efficiency;
  }
  
  public void setDisplacement(int displacement) {
    this.displacement = displacement;
  }
  
  public void setEfficiency(String efficiency) {
    this.efficiency = efficiency;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public int getPower() {
    return this.power;
  }
  
  public int getDisplacement() {
    return this.displacement;
  }
  
  public String getEfficiency() {
    return this.efficiency;
  }
  
  @Override
  public String toString() {
    StringBuilder stringBuilder =  new StringBuilder();
    stringBuilder.append(String.format("%s:", this.getModel()));
    stringBuilder.append(System.lineSeparator());
    stringBuilder.append(String.format("Power: %d", this.getPower()));
    stringBuilder.append(System.lineSeparator());
    stringBuilder.append(String.format("Displacement: %s"
            , this.getDisplacement() == 0 ? "n/a" : this.getDisplacement()));
    stringBuilder.append(System.lineSeparator());
    stringBuilder.append(String.format("Efficiency: %s", this.getEfficiency() == null ? "n/a" : this.getEfficiency()));
    
    
    return  stringBuilder.toString();
  }
  
}

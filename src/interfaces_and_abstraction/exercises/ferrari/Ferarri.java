package interfaces_and_abstraction.exercises.ferrari;

public class Ferarri implements Car {
  private final static String DEFAULT_MODEL = "488-Spider";
  
  private String model;
  private String driverName;
  
  public Ferarri(String driverName) {
    model = DEFAULT_MODEL;
    this.driverName = driverName;
  }
  
  
  @Override
  public String getModel() {
    return this.model;
  }
  
  @Override
  public String pushBrakes() {
    return "Brakes!";
  }
  
  @Override
  public String pushGasPedal() {
    return "Zadu6avam sA!";
  }
  
  @Override
  public String getDriverName() {
    return this.driverName;
  }
}

package interfaces_and_abstraction.exercises.border_control;

public class Robot implements Identifable {
  private String name;
  private String id;
  
  public Robot(String name, String id) {
    this.name = name;
    this.id = id;
  }
  
  @Override
  public String getId() {
    return this.id;
  }
}

package defining_classes.exercises.google;

public class Parent {
  private String name;
  private String birthDay;
  
  public Parent(String name, String birthDay) {
    this.name = name;
    this.birthDay = birthDay;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getBirthDay() {
    return this.birthDay;
  }
  
  @Override
  public String toString() {
    return String.format("%s %s", this.getName(), this.getBirthDay());
  }
  
}

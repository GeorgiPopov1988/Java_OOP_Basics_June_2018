package defining_classes.exercises.google;

public class Child {
  private String name;
  private String birthDay;
  
  public Child(String name, String birthDay) {
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

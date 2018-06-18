package encapsulation.exercises.animal_farm;

public class Chicken {
  private String name;
  private int age;
  
  public Chicken(String name, int age) {
    setName(name);
    setAge(age);
  }
  
  private void setAge(int age) {
    if (age < 0 || age > 15) {
      throw new IllegalArgumentException("Age should be between 0 and 15.");
    }
    this.age = age;
  }
  
  private void setName(String name) {
    if (name.trim().isEmpty() && name.length() <= 1) {
      throw new IllegalArgumentException("Name cannot be empty.");
    }
    this.name = name;
  }
  
  public String getProductPerDay() {
    return calculateProductPerDay();
  }
  
  private String calculateProductPerDay() {
    int age = this.age;
    String result = "";
    if (age >= 0 && age < 6) {
      result = "2";
    } else if (age >= 6 && age < 12) {
      result = "1";
    } else if (age >= 12 && age <= 15) {
      result = "0.75";
    }
    return result;
  }
  
  @Override
  public String toString() {
    return String.format("Chicken %s (age %d) can produce %s eggs per day.", this.getName(), this.getAge(), this.getProductPerDay());
  }
  
  private int getAge() {
    return this.age;
  }
  
  private String getName() {
    return this.name;
  }
}

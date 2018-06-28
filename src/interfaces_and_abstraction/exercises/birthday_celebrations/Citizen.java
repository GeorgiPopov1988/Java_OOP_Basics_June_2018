package interfaces_and_abstraction.exercises.birthday_celebrations;

public class Citizen implements Identifable, Celebratebale {
  private String name;
  private String age;
  private String id;
  private String birthDate;
  
  public Citizen(String name, String age, String id, String birthDate) {
    this.name = name;
    this.age = age;
    this.id = id;
    this.birthDate = birthDate;
  }
  
  @Override
  public String getId() {
    return this.id;
  }
  
  @Override
  public String getBirthDate() {
    return this.birthDate;
  }
}

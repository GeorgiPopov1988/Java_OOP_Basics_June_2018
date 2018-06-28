package interfaces_and_abstraction.exercises.birthday_celebrations;

public class Pet implements Celebratebale {
private String name;
private String birthDate;

public Pet(String name, String birthDate) {
  this.name = name;
  this.birthDate = birthDate;
}
  @Override
  public String getBirthDate() {
    return this.birthDate;
  }
}

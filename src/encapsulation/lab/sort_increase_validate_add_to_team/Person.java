package encapsulation.lab.sort_increase_validate_add_to_team;

public class Person {
  private String firstName;
  private String lastName;
  private Integer age;
  private Double salary;
  
  public Person(String firstName, String lastName, Integer age, Double salary) {
    setFirstName(firstName);
    setLastName(lastName);
    setAge(age);
    setSalary(salary);
  }
  
  private void setFirstName(String firstName) {
    if (firstName.length() < 3) {
      throw new IllegalArgumentException("First name cannot be less than 3 symbols");
    }
    this.firstName = firstName;
  }
  
  public String getFirstName() {
    return this.firstName;
  }
  
  private void setLastName(String lastName) {
    if (lastName.length() < 3) {
      throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
    }
    this.lastName = lastName;
  }
  
  private String getLastName() {
    return this.lastName;
  }
  
  private void setAge(Integer age) {
    if (age < 0) {
      throw new IllegalArgumentException("Age cannot be zero or negative integer");
    }
    this.age = age;
  }
  
  public Integer getAge() {
    return this.age;
  }
  
  private void setSalary(Double salary) {
    if (salary < 460) {
      throw new IllegalArgumentException("Salary cannot be less than 460 leva");
    }
    this.salary = salary;
  }
  
  private Double getSalary() {
    return this.salary;
  }
  
  public void increaseSalary(Double bonus) {
    if (this.getAge() > 30) {
      this.salary = this.salary + (this.salary * bonus / 100);
    } else {
      this.salary = this.salary + (this.salary * bonus / 200);
    }
  }
  
  @Override
  public String toString() {
    //return String.format("%s %s gets %s leva"
            //, this.getFirstName(), this.getLastName(), Double.toString(this.getSalary()));
    return this.firstName + " "+ this.lastName + " gets " + this.getSalary() + " leva";
  }
}

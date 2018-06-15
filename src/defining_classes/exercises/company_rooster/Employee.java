package defining_classes.exercises.company_rooster;

public class Employee {
  private final static String DEFAULT_EMAIL = "n/a";
  private final static int DEFAULT_AGE = -1;
  
  private String name;
  private double salary;
  private String position;
  private String department;
  private String email;
  private int age;
  
  public Employee(String name, double salary, String position, String department) {
    this(name, salary, position, department, DEFAULT_EMAIL, DEFAULT_AGE);
  }
  
  public Employee(String name, double salary, String position, String department, String email) {
    this(name, salary, position, department, email, DEFAULT_AGE);
  }
  
  public Employee(String name, double salary, String position, String department, int age) {
    this(name, salary, position, department, DEFAULT_EMAIL, age);
  }
  
  public Employee(String name, double salary, String position, String department, String email, int age) {
    this.name = name;
    this.salary = salary;
    this.position = position;
    this.department = department;
    this.email = email;
    this.age = age;
  }
  
  
  private String getName() {
    return this.name;
  }
  
  private int getAge() {
    return this.age;
  }
  
  private String getEmail() {
    return this.email;
  }
  
  public double getSalary() {
    return this.salary;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  @Override
  public String toString() {
    return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
  }
  

}

package interfaces_and_abstraction.lab.say_hello_extended;

public class Chinese extends BasePerson implements Person {
  
  protected Chinese(String name) {
    super(name);
  }
  
  @Override
  public String sayHello() {
    return "Djydjybydjy";
  }
}

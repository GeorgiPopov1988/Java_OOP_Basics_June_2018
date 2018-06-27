package interfaces_and_abstraction.lab.say_hello_extended;

public class Bulgarian extends BasePerson implements Person {
  
  protected Bulgarian(String name) {
    super(name);
  }
  
  @Override
  public String sayHello() {
    return "Здравей";
  }
}

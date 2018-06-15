package defining_classes.lab.bank_account_with_person;

import java.util.ArrayList;
import java.util.List;

public class Person {
  private String name;
  private int age;
  private List<BankAcc> accounts;
  
  
  
  public Person(String name, int age) {
    this(name, age, new ArrayList<BankAcc>());
    
                        // Alternative
    //this.name = name;
    //this.age = age;
    //this.accounts = new ArrayList<>();
  }
  
  public Person(String name, int age, List<BankAcc> accounts) {
    this.name = name;
    this.age = age;
    this.accounts = accounts;
  }
  
  public double getBalance() {
    return this.accounts.stream().mapToDouble(s -> s.getBalance()).sum();
  }
  
  
}

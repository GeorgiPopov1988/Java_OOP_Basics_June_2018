package interfaces_and_abstraction.exercises.military_elite.implementations;

import interfaces_and_abstraction.exercises.military_elite.interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {
  private double salary;
  
  public PrivateImpl(String id, String firstName, String lastName, double salary) {
    super(id, firstName, lastName);
    this.salary = salary;
  }
  
  @Override
  // Privates
  // Name: <firstName> <lastName> Id: <id> Salary: <salary>
  public String toString() {
    return String.format("%s Salary: %.2f",super.toString(), this.salary);
  }
}

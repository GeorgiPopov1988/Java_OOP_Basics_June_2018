package interfaces_and_abstraction.exercises.military_elite.implementations;

import interfaces_and_abstraction.exercises.military_elite.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
  private String codeNumber;
  
  public SpyImpl(String id, String firstName, String lastName, String codeNumber) {
    super(id, firstName, lastName);
    this.codeNumber = codeNumber;
  }
  
  @Override
  // Spy:
  // Name: <firstName> <lastName> Id: <id>
  // Code Number: <codeNumber>
  public String toString() {
    StringBuilder spy = new StringBuilder(super.toString()).append(System.lineSeparator());
    
    spy.append(String.format("Code Number: %s", this.codeNumber));
    
    return spy.toString();
  }
}

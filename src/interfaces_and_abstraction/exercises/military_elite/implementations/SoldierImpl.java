package interfaces_and_abstraction.exercises.military_elite.implementations;

import interfaces_and_abstraction.exercises.military_elite.interfaces.Soldier;

public abstract class SoldierImpl implements Soldier {
  private String id;
  private String firstName;
  private String lastName;
  
  protected SoldierImpl(String id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public void addPrivate(PrivateImpl privateSoldier) {
  
  }
  
  @Override
  public String getId() {
    return this.id;
  }
  
  @Override
  //  Name: <firstName> <lastName> Id: <id>
  public String toString() {
    return String.format("Name: %s %s Id: %s", this.firstName, this.lastName, this.id);
  }
}

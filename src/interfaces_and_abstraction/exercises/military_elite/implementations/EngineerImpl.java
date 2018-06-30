package interfaces_and_abstraction.exercises.military_elite.implementations;

import interfaces_and_abstraction.exercises.military_elite.interfaces.Engineer;
import interfaces_and_abstraction.exercises.military_elite.interfaces.Repair;

import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
  private Set<Repair> repairs;
  
  
  public EngineerImpl
          (String id, String firstName, String lastName, double salary, String corps, Set<Repair> repairs) {
    super(id, firstName, lastName, salary, corps);
    this.repairs = repairs;
  }
  
  @Override
  // Engineer:
  // Name: <firstName> <lastName> Id: <id> Salary: <salary>
  // Corps: <corps>
  // Repairs:
  //  <repair1 ToString()>
  //  <repair2 ToString()>
  //  …
  //  <repairN ToString()>
  public String toString() {
    StringBuilder engineer = new StringBuilder(super.toString()).append(System.lineSeparator());
    engineer.append("Repairs:");
  
    for (Repair repair : repairs) {
      engineer.append(System.lineSeparator());
      engineer.append(" " + repair);
    }
    return engineer.toString();
  }
}

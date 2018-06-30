package interfaces_and_abstraction.exercises.military_elite.implementations;

import interfaces_and_abstraction.exercises.military_elite.interfaces.Repair;

public class RepairImpl implements Repair {
  private String partName;
  private int hoursWorked;
  
  public RepairImpl(String partName, int hoursWorked) {
    this.partName = partName;
    this.hoursWorked = hoursWorked;
  }
  
  @Override
  public String toString() {
    // Part Name: <partName> Hours Worked: <hoursWorked>
    return String.format(" Part Name: %s Hours Worked: %s", this.partName, this.hoursWorked);
  }
}

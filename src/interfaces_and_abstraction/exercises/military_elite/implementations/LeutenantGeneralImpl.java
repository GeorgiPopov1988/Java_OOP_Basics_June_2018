package interfaces_and_abstraction.exercises.military_elite.implementations;

import interfaces_and_abstraction.exercises.military_elite.interfaces.LeutenantGeneral;
import interfaces_and_abstraction.exercises.military_elite.interfaces.Private;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LeutenantGeneralImpl extends  PrivateImpl implements LeutenantGeneral {
  private Set<Private> privates;
  
  public LeutenantGeneralImpl
          (String id, String firstName, String lastName, double salary, Set<Private> privates) {
    super(id, firstName, lastName, salary);
    this.privates = privates;
  }
  
  @Override
  // LeutenantGeneral:
  // Name: <firstName> <lastName> Id: <id> Salary: <salary>
  // Privates:
      // sort by descending order
  //   <private1 ToString()>
  //   <private2 ToString()>
  //   …
  //   <privateN ToString()>
  public String toString() {
    StringBuilder leutenant = new StringBuilder(super.toString()).append(System.lineSeparator());
    
    leutenant.append("Privates:");
  
    LinkedHashSet<Private> sorted = privates.stream()
            .sorted((p1, p2) -> p2.getId().compareTo(p1.getId()))
            .collect(Collectors.toCollection(LinkedHashSet::new));
    
    for (Private aPrivate : sorted) {
      leutenant.append(System.lineSeparator())
              .append("  " + aPrivate);
    }
    return leutenant.toString();
  }
}

package interfaces_and_abstraction.exercises.military_elite.implementations;

import interfaces_and_abstraction.exercises.military_elite.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
  private static final String AIRFORCES_VALID_CORPS_TYPE = "Airforces";
  private static final String MILITARY_VALID_CORPS_TYPE = "Marines";
  
  private String corps;
  
  protected SpecialisedSoldierImpl(String id, String firstName, String lastName, double salary,
                                   String corps) {
    super(id, firstName, lastName, salary);
    this.setCorps(corps);
  }
  
  private void setCorps(String corps) {
    if (!AIRFORCES_VALID_CORPS_TYPE.equals(corps)
            && !MILITARY_VALID_CORPS_TYPE.equals(corps)) {
      throw new IllegalArgumentException();
    } else {
      this.corps = corps;
    }
  }
  
  @Override
  public String toString() {
    StringBuilder specialist = new StringBuilder(super.toString()).append(System.lineSeparator());
    specialist.append(String.format("Corps: %s", this.corps));
    
    return specialist.toString();
  }
}

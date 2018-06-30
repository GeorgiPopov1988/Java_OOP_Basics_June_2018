package interfaces_and_abstraction.exercises.military_elite.implementations;

import interfaces_and_abstraction.exercises.military_elite.interfaces.Mission;

public class MissionImpl implements Mission {
  private static final String INPROGRESS_VALID_MISSION_STATE = "inProgress";
  private static final String FINISHED_VALID_MISSION_STATE = "Finished";
  
  private String codeName;
  private String state;
  
  public MissionImpl(String codeName, String state) {
    this.codeName = codeName;
    this.setState(state);
  }
  
  private void setState(String state) {
    if (!INPROGRESS_VALID_MISSION_STATE.equals(state)
            && !FINISHED_VALID_MISSION_STATE.equals(state)) {
      throw new IllegalArgumentException();
    } else {
      this.state = state;
    }
  }
  
  @Override
  public void completeMission(){
    this.state = FINISHED_VALID_MISSION_STATE;
  }
  
  @Override
  public String toString() {
    //Code Name: <codeName> State: <state>
    return String.format("  Code Name: %s State: %s", this.codeName, this.state);
  }
}

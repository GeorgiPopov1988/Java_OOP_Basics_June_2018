package interfaces_and_abstraction.exercises.military_elite;

import interfaces_and_abstraction.exercises.military_elite.implementations.*;
import interfaces_and_abstraction.exercises.military_elite.interfaces.Mission;
import interfaces_and_abstraction.exercises.military_elite.interfaces.Private;
import interfaces_and_abstraction.exercises.military_elite.interfaces.Repair;
import interfaces_and_abstraction.exercises.military_elite.interfaces.Soldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
    Map<String, Soldier> soldiers = new LinkedHashMap<>();
    Map<String, Private> privates = new LinkedHashMap<>();
    
    String input = reader.readLine();
    while (!"End".equals(input)) {
      String[] inTokens = input.split(" ");
      String type = inTokens[0];
      
      Soldier soldier = null;
      switch (type) {
        case "Private":
          // Private <id> <firstName> <lastName> <salary>
          Private privateSoldier = createPrivate(inTokens);
          
          soldiers.put(privateSoldier.getId(), privateSoldier);
          privates.put(privateSoldier.getId(), privateSoldier);
          
          break;
        case "LeutenantGeneral":
          // LeutenantGeneral <id> <firstName> <lastName> <salary> <private1Id> <private2Id> … <privateNId>
          soldier = createLeutenantGeneral(inTokens, privates);
          
          break;
        case "Engineer":
          // Engineer <id> <firstName> <lastName> <salary> <corps> <repair1Part> <repair1Hours> …
          // <repairNPart> <repairNHours>
          
          try {
            soldier = createEngineer(inTokens);
          } catch (IllegalArgumentException iae) {
            ;//System.out.println("Error engineer");
          }
          break;
        case "Commando":
          // Commando <id> <firstName> <lastName> <salary> <corps> <mission1CodeName>  <mission1state> …
          // <missionNCodeName> <missionNstate>
          try {
            soldier = createCommando(inTokens);
          } catch (IllegalArgumentException iae) {
            ;//System.out.println("Error commando.");
          }
          break;
        case "Spy":
          // Spy <id> <firstName> <lastName> <codeNumber>
          soldier = createSpy(inTokens);
          break;
      }
      
      if (soldier!=null) {
        soldiers.put(soldier.getId(), soldier);
      }
      
      input = reader.readLine();
    }
  
    for (Map.Entry<String, Soldier> soldiersMap : soldiers.entrySet()) {
      System.out.println(soldiersMap.getValue());
    }
    
  }
  
  private static SpyImpl createSpy(String[] inTokens) {
    String id = inTokens[1];
    String firstName = inTokens[2];
    String lastName = inTokens[3];
    String codeNumber = inTokens[4];
    
    return new SpyImpl(id, firstName, lastName, codeNumber);
  }
  
  private static CommandoImpl createCommando(String[] inTokens) {
    String id = inTokens[1];
    String firstName = inTokens[2];
    String lastName = inTokens[3];
    double salary = Double.parseDouble(inTokens[4]);
    String corps = inTokens[5];
  
    Set<Mission> missions = new LinkedHashSet<>();
  
    for (int i = 6; i < inTokens.length - 1; i+= 2) {
      String missionName = inTokens[i];
      String state = inTokens[i + 1];
      try {
        Mission mission = new MissionImpl(missionName, state);
        missions.add(mission);
      } catch (IllegalArgumentException iae) {
        ;//System.out.println("Error mission");
      }
    }
    return new CommandoImpl(id, firstName, lastName, salary,corps, missions);
  }
  
  private static EngineerImpl createEngineer(String[] inTokens) {
      String id = inTokens[1];
      String firstName = inTokens[2];
      String lastName = inTokens[3];
      double salary = Double.parseDouble(inTokens[4]);
      String corps = inTokens[5];
  
      Set<Repair> repairs = new LinkedHashSet<>();
  
      for (int i = 6; i < inTokens.length - 1; i+= 2) {
        
        Repair repair = new RepairImpl(inTokens[i], Integer.parseInt(inTokens[i + 1]));
        repairs.add(repair);
      }
      return new EngineerImpl(id, firstName, lastName, salary,corps, repairs);
  }
  
  private static LeutenantGeneralImpl createLeutenantGeneral(String[] inTokens, Map<String, Private> privates) {
    String id = inTokens[1];
    String firstName = inTokens[2];
    String lastName = inTokens[3];
    double salary = Double.parseDouble(inTokens[4]);
    Set<Private> setPrivates = new LinkedHashSet<>();
  
    for (int i = 5; i < inTokens.length; i++) {
      String privateID = inTokens[i];
  
      if (privates.containsKey(privateID)) {
  
        setPrivates.add(privates.get(privateID));
  
      }
    }
    
    return new LeutenantGeneralImpl(id, firstName, lastName, salary, setPrivates);
  }
  
  private static PrivateImpl createPrivate(String[] inTokens) {
    String id = inTokens[1];
    String firstName = inTokens[2];
    String lastName = inTokens[3];
    double salary = Double.parseDouble(inTokens[4]);
    
    return new PrivateImpl(id, firstName, lastName, salary);
  }
}

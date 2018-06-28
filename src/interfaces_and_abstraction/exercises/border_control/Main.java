package interfaces_and_abstraction.exercises.border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
    List<Identifable> list = new ArrayList<>();
    list = createResidents(list, reader);
    printByCriteria(reader, list);
  }
  
  private static List<Identifable> createResidents(List<Identifable> list, BufferedReader reader) throws IOException {
    String input = reader.readLine();
    
    while (!"End".equals(input)) {
      String[] inputTokens = input.split(" ");
      
      Identifable identifable = null;
      
      if (inputTokens.length== 2) {
        identifable = createRobot(inputTokens);
      } else if (inputTokens.length == 3){
        identifable = createCitizen(inputTokens);
      }
      
      list.add(identifable);
      
      input = reader.readLine();
    }
    
    return list;
  }
  
  private static void printByCriteria(BufferedReader reader, List<Identifable> list) throws IOException {
    String criteria = reader.readLine();
    
    list
            .stream()
            .filter(identifable -> identifable.getId().endsWith(criteria))
            .forEach(identifable -> System.out.println(identifable.getId()));
  }
  
  
  private static Citizen createCitizen(String[] inputTokens) {
    String name = inputTokens[0];
    String age = inputTokens[1];
    String id = inputTokens[2];
    
    return new Citizen(name, age, id);
  }
  
  private static Robot createRobot(String[] inputTokens) {
    String name = inputTokens[0];
    String id = inputTokens[1];
    
    return new Robot(name, id);
  }
}

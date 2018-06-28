package interfaces_and_abstraction.exercises.birthday_celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
    List<Celebratebale> list = new ArrayList<>();
    list = createResidents(list, reader);
    printByCriteria(reader, list);
  }
  
  private static List<Celebratebale> createResidents(List<Celebratebale> list, BufferedReader reader) throws IOException {
    String input = reader.readLine();
    
    while (!"End".equals(input)) {
      String[] inputTokens = input.split(" ");
      
      Celebratebale celebratebale = null;
      
      String type = inputTokens[0];
      switch (type){
        case "Citizen":
          celebratebale = createCitizen(inputTokens);
          break;
        //case "Robot":
        //  celebratebale = createRobot(inputTokens);
        //break;
        case "Pet":
          celebratebale = createPet(inputTokens);
          break;
      }
      if (celebratebale != null) {
        list.add(celebratebale);
      }
      
      input = reader.readLine();
    }
    
    return list;
  }
  
  private static void printByCriteria(BufferedReader reader, List<Celebratebale> list) throws IOException {
    String criteria = reader.readLine();
    
    list
            .stream()
            .filter(celebratebale -> celebratebale.getBirthDate().endsWith(criteria))
            .forEach(celebratebale -> System.out.println(celebratebale.getBirthDate()));
  }
  
  private static Pet createPet(String[] inputTokens) {
    String name = inputTokens[1];
    String birthDate = inputTokens[2];
    return new Pet(name, birthDate);
  }
  
  private static Citizen createCitizen(String[] inputTokens) {
    String name = inputTokens[1];
    String age = inputTokens[2];
    String id = inputTokens[3];
    String birthDate = inputTokens[4];
    
    return new Citizen(name, age, id, birthDate);
  }
  
  private static Robot createRobot(String[] inputTokens) {
    String name = inputTokens[1];
    String id = inputTokens[2];
    
    return new Robot(name, id);
  }
}

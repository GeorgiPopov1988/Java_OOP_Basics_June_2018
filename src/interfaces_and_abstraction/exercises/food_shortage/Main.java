package interfaces_and_abstraction.exercises.food_shortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
    Map<String, Buyer> list = new HashMap<>();
    list = createPopulation(list, reader, list);
    
    shopping(reader, list);
    System.out.println(list.entrySet().stream().mapToInt(b -> b.getValue().getFood()).sum());
  }
  
  private static void shopping(BufferedReader reader, Map<String, Buyer> list) throws IOException {
    String buyer = reader.readLine();
    while (!"End".equals(buyer)) {
      if (list.containsKey(buyer)) {
        list.get(buyer).buyFood();
      }
      buyer = reader.readLine();
    }
  }
  
  private static Map<String, Buyer> createPopulation(Map<String, Buyer> map, BufferedReader reader, Map<String, Buyer> list) throws IOException {
    int cnt = Integer.parseInt(reader.readLine());
    while (cnt-- > 0) {
      String[] inTokens = reader.readLine().split(" ");
      
      String name = inTokens[0];
      String age = inTokens[1];
      Buyer buyer = null;
      
      if (inTokens.length == 3) {
        // create Rebel
        buyer = createRebel(inTokens, name, age);
      } else if (inTokens.length == 4) {
        // create Citizen
        buyer = createCitizen(inTokens, name, age);
      }
      
      if (buyer != null) {
        map.put(name, buyer);
      }
      
    }
    return map;
  }
  
  private static Citizen createCitizen(String[] inTokens, String name, String age) {
    String id = inTokens[2];
    String birthDate = inTokens[3];
    
    return new Citizen(name, age,id, birthDate);
  }
  
  private static Rebel createRebel(String[] inTokens, String name, String age) {
    String group = inTokens[2];
    return new Rebel(name, age, group);
  }
}

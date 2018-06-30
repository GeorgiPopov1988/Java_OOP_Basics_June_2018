package interfaces_and_abstraction.exercises.mood_3;

import interfaces_and_abstraction.exercises.mood_3.implementation.ArchangelImpl;
import interfaces_and_abstraction.exercises.mood_3.implementation.DemonImpl;
import interfaces_and_abstraction.exercises.mood_3.interfaces.Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] inTokens = reader.readLine().split(" \\| ");
    Hero hero = createHero(inTokens);
  
    System.out.println(hero);
    
  }
  
  private static Hero createHero(String[] inTokens) {
    //<username> | <character type> | <special points> | <level>
  
    String username = inTokens[0];
    String type = inTokens[1];
    int level = Integer.parseInt(inTokens[3]);
    
    Hero hero = null;
    if ("Demon".equals(type)) {
      double energy = Double.parseDouble(inTokens[2]);
      hero = new DemonImpl(username, energy, level);
    } else {
      int mana = Integer.parseInt(inTokens[2]);
      hero = new ArchangelImpl(username, mana, level);
    }
    return hero;
  }
}

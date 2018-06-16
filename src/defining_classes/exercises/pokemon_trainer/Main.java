package defining_classes.exercises.pokemon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    String inLine = reader.readLine();
    
    Map<String, Trainer> trainers = new LinkedHashMap<>();
    //Map<String, List<Pokemon>> pokemons = new HashMap<>();
    
    addPlayers(reader, inLine, trainers);
    
    String element = reader.readLine();
    fight(reader, trainers, element);
  
    sortAndPrint(trainers);
  
  }
  
  private static void sortAndPrint(Map<String, Trainer> trainers) {
    trainers.entrySet().stream().sorted((t1, t2) -> Integer.compare(
            t2.getValue().getBadgesCnt(), t1.getValue().getBadgesCnt()
    )).forEach(t -> System.out.println(t.getValue().toString()));
  }
  
  private static void fight(BufferedReader reader, Map<String, Trainer> trainers, String element) throws IOException {
    while (!"End".equals(element)) {
      
      for (Map.Entry<String, Trainer> map : trainers.entrySet()) {
        String trainerName = map.getKey();
        boolean haveElement = false;
        
        for (Pokemon pokemon : map.getValue().getPokemons()) {
          if (pokemon.getElement().equals(element)) {
            haveElement = true;
            trainers.get(trainerName).addBadge(1);
            break;
          }
        }
        
        if (!haveElement) {
          Trainer trainer = trainers.get(trainerName);
          trainer.hitAllPokemons();
        }
        
      }
      element = reader.readLine();
    }
  }
  
  private static void addPlayers(BufferedReader reader, String inLine, Map<String, Trainer> trainers) throws IOException {
    
    while (!"Tournament".equals(inLine)) {
      String[] inTokens = inLine.split(" ");
      // <TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>
      String trainerName = inTokens[0];
      String pokemonName = inTokens[1];
      String pokemonElement = inTokens[2];
      int pokemonHealth = Integer.parseInt(inTokens[3]);
      
      Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
      Trainer trainer = new Trainer(trainerName);
      
      if (!trainers.containsKey(trainerName)) {
        trainers.put(trainerName, trainer);
      }
      trainers.get(trainerName).addPokemon(pokemon);
      
      inLine = reader.readLine();
    }
  }
}

package defining_classes.exercises.pokemon_trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
  private final static int START_BADGES_CNT = 0;
  
  private String name;
  private int badgesCnt;
  private List<Pokemon> pokemons;
  
  public Trainer(String name) {
    this.name = name;
    this.badgesCnt = START_BADGES_CNT;
    this.pokemons = new ArrayList<>();
  }
  
  public String getName() {
    return this.name;
  }
  
  public int getBadgesCnt() {
    return this.badgesCnt;
  }
  
  public List<Pokemon> getPokemons() {
    return this.pokemons;
  }
  
  public void addBadge(int badgeCnt) {
    this.badgesCnt += badgeCnt;
  }
  
  public void addPokemon(Pokemon pokemon) {
    this.pokemons.add(pokemon);
  }
  
  public void hitAllPokemons() {
    for (int i = 0; i < this.pokemons.size(); i++) {
      pokemons.get(i).hit();
      if (pokemons.get(i).getHealth() <= 0) {
        this.pokemons.remove(pokemons.get(i));
      }
    }
  }
  
  @Override
  public String toString() {
    return String.format("%s %s %s", this.getName(), this.getBadgesCnt(), this.pokemons.size());
  }
}

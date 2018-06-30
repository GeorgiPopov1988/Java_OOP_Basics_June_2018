package interfaces_and_abstraction.exercises.mood_3.implementation;

import interfaces_and_abstraction.exercises.mood_3.interfaces.Demon;

public class DemonImpl extends HeroImpl implements Demon {
  private static final String TYPE = "Demon";
  private double energy;
  private double num;
  
  public DemonImpl(String name, double energy, int level) {
    super(name, level);
    super.hashPassword = hashing(name);
    super.type = TYPE;
    this.energy = energy;
    this.num =energy * level;
  }
  
  private String hashing(String name) {
    int pass = name.length() * 217;
    return String.valueOf(pass);
  }
  
  @Override
  public String toString() {
    // ""Akasha"" | ""ahsakA"168" -> Archangel
    //500
    StringBuilder demon = new StringBuilder(super.toString());
    demon.append(this.type);
    demon.append(System.lineSeparator());
    demon.append(String.format("%.1f", this.num));
    
    return demon.toString();
  }
}

package interfaces_and_abstraction.exercises.mood_3.implementation;

import interfaces_and_abstraction.exercises.mood_3.interfaces.Hero;

public abstract class HeroImpl implements Hero {
  protected String name;
  protected String hashPassword;
  private int level;
  protected String type;
  
  protected HeroImpl(String name, int level) {
    this.name = name;
    this.level = level;
  }
  
  @Override
  public String toString() {
    //""Akasha"" | ""ahsakA"168" -> Archangel
    //500
    return String.format("\"%s\" | \"%s\" -> ", this.name, this.hashPassword);
  }
}

package interfaces_and_abstraction.exercises.mood_3.implementation;

import interfaces_and_abstraction.exercises.mood_3.interfaces.Archangel;

public class ArchangelImpl extends HeroImpl implements Archangel {
  private final static String TYPE = "Archangel";
  private int mana;
  private int num;
  
  public ArchangelImpl(String name, int mana, int level) {
    super(name, level);
    super.hashPassword = hashing(this.name);
    super.type = TYPE;
    this.mana = mana;
    this.num = mana * level;
  }
  
  private String hashing(String name) {
    StringBuilder archangelPassword = new StringBuilder(name);
    archangelPassword.reverse().append((name.length() * 21));
    return archangelPassword.toString();
  }
  
  @Override
  public String toString() {
    StringBuilder archangel = new StringBuilder(super.toString());
    archangel.append(this.type);
    archangel.append(System.lineSeparator());
    archangel.append(this.num);
    
    return archangel.toString();
  }
}

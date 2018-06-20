package inheritance.lab.fragile_base_class;

public class Predator extends Animal {
  private int health;
  
  public void feed(Food food) {
    this.health++;
    super.eat(food);
  }
}

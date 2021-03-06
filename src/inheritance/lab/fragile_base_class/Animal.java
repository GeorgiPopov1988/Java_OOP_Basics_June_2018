package inheritance.lab.fragile_base_class;

import java.util.ArrayList;
import java.util.List;

public class Animal {
  protected List<Food> foodEaten;
  
  public Animal() {
    this.foodEaten = new ArrayList<Food>();
  }
  
  public final void eat(Food food) {
    this.foodEaten.add(food);
  }
  
  public void eatAll(Food[] foods) {
    for (Food food : foods) {
      this.eat(food);
    }
  }
  
  
}

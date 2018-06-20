package inheritance.lab.random_array_list;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

  
  public Object getRandomElement() {
    Random random = new Random();
    int rndIndex = random.nextInt(super.size());
    Object result = super.get(rndIndex);
    super.remove(result);
    return result;
  }
}

package inheritance.lab.stack_of_strings;

import java.util.LinkedList;
import java.util.List;

public class StackOfStrings {
  private List<String> data;
  
  public StackOfStrings() {
    this.data = new LinkedList<>();
  }
  
  public void push(String item) {
    this.data.add(item);
  }
  
  public String pop() {
    if (!this.data.isEmpty()) {
      return this.data.remove(this.data.size() - 1);
    } else {
      return null;
    }
  }
  
  public String peek() {
    if (!this.data.isEmpty()) {
      return this.data.get(this.data.size() - 1);
    } else {
      return null;
    }
  }
  
  public boolean isEmpty() {
    
    return this.data.size() > 0;
  }
}

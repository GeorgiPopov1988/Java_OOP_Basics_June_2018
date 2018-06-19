package encapsulation.exercises.shopping_spree;

import java.util.ArrayList;
import java.util.List;

public class Person {
  private String name;
  private int money;
  private List<Product> products;
  
  public Person(String name, int money) {
    setName(name);
    setMoney(money);
    this.products = new ArrayList<>();
  }
  
  private void setName(String name) {
    if (name.length() > 1) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("Name cannot be empty");
    }
  }
  
  public String getName() {
    return this.name;
  }
  
  private void setMoney(int money) {
    if (money < 0) {
      throw new IllegalArgumentException("Money cannot be negative");
    } else {
      this.money = money;
    }
  }
  
  public double getMoney() {
    return this.money;
  }
  
  public List<Product> getProducts() {
    return this.products;
  }
  
  public void buyProduct(Product product){
    
    if (this.getMoney() < product.getPrice()) {
      System.out.printf("%s can't afford %s%n", this.getName(), product.getName());
    } else {
      this.getProducts().add(product);
      this.money -= product.getPrice();
      System.out.println(this.getName() + " bought " + product.getName());
    }
  }
  
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.name);
    stringBuilder.append(" - ");
    stringBuilder.append(String.join(", ", this.getProducts().stream()
            .map(p -> p.getName()).toArray(String[]::new)));
    
    return stringBuilder.toString();
  }
  
}

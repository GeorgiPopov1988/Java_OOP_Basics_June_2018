package encapsulation.exercises.shopping_spree;

import java.util.ArrayList;
import java.util.List;

public class Person {
  private String name;
  private double money;
  private List<Product> products;
  
  public Person(String name, double money) {
    this.setName(name);
    this.setMoney(money);
    this.products = new ArrayList<>();
  }
  
  private void setName(String name) {
    if (name == null || name.trim().length() == 0) {
      throw new IllegalArgumentException("Name cannot be empty");
    } else {
      this.name = name;
    }
  }
  
  public String getName() {
    return this.name;
  }
  
  private void setMoney(double money) {
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
  
  public String buyProduct(Product product){
    String buyResult = "";
    if (this.getMoney() < product.getPrice()) {
      buyResult = String.format("%s can't afford %s", this.getName(), product.getName());
    } else {
      this.getProducts().add(product);
      this.money -= product.getPrice();
      buyResult = this.getName() + " bought " + product.getName();
    }
    
    return  buyResult;
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

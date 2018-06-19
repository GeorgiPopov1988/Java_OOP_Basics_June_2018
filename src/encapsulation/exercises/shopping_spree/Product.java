package encapsulation.exercises.shopping_spree;

public class Product {
  private String name;
  private double price;
  
  public Product(String name, double price) {
    setName(name);
    setPrice(price);
  }
  
  private void setName(String name) {
    if (!name.trim().isEmpty() && name.length() == 1) {
      throw new IllegalArgumentException("Name cannot be empty");
    }
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }
  
  private void setPrice(double price) {
    if (price < 0) {
      throw new IllegalArgumentException("Money cannot be negative");
    }
    this.price = price;
  }
  
  public double getPrice() {
    return this.price;
  }
}

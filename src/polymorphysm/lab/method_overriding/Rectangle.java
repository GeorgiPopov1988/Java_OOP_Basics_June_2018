package polymorphysm.lab.method_overriding;

public class Rectangle {
  private double sideA;
  private double sideB;
  
  public Rectangle(double sideA) {
    this.sideA = sideA;
  }
  
  public Rectangle(double sideA, double sideB) {
    this.sideA = sideA;
    this.sideB = sideB;
  }
  
  public double getSideA() {
    return this.sideA;
  }
  
  public double getArea() {
    return this.sideA * this.sideB;
  }
}

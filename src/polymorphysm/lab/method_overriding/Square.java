package polymorphysm.lab.method_overriding;

public class Square extends Rectangle{
  
  public Square(double sideA) {
    super(sideA);
  }
  
  @Override
  public double getArea() {
    return this.getSideA() * this.getSideA();
  }
}

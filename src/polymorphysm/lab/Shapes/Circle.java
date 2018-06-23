package polymorphysm.lab.Shapes;

public class Circle extends Shape {
  private double radius;
  
  public Circle(double radius) {
    this.setRadius(radius);
    this.calculatePerimeter();
    this.calculateArea();
  }
  
  public void setRadius(double radius) {
    this.radius = radius;
  }
  
  private final double getRadius() {
    return this.radius;
  }
  
  @Override
  protected void calculatePerimeter() {
    this.setPerimeter( 2 * Math.PI * this.getRadius());
  }
  
  @Override
  protected void calculateArea() {
    this.setArea(Math.pow(Math.PI * this.getRadius(), 2));
  }
  
}

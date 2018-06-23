package polymorphysm.lab.Shapes;

public abstract class Shape {
  private double perimeter;
  private double area;
  
  protected void setPerimeter(double perimeter) {
    this.perimeter = perimeter;
  }
  
  public double getPerimeter() {
    return  this.perimeter;
  }
  
  protected void setArea(double area) {
    this.area = area;
  }
  
  public double getArea() {
    return this.area;
  }
  
  protected abstract void calculatePerimeter();
  
  protected abstract void calculateArea();
}

package polymorphysm.lab.Shapes;

public class Rectangle extends Shape {
  private double height;
  private double width;
  
  public Rectangle(double height, double width) {
    this.setHeight(height);
    this.setWidth(width);
    this.calculatePerimeter();
    this.calculateArea();
  }
  
  private double getHeight() {
    return this.height;
  }
  
  private void setHeight(double height){
    this.height = height;
  }
  
  private double getWidth() {
    return this.width;
  }
  
  private void setWidth(double width) {
    this.width = width;
  }
  
  @Override
  protected void calculatePerimeter() {
    this.setPerimeter((2 * this.getHeight()) + (2 * this.getWidth()));
  }
  
  @Override
  protected void calculateArea() {
    this.setArea(this.getHeight() * this.getWidth());
  }

}

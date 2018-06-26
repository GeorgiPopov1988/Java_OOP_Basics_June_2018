package interfaces_and_abstraction.lab.shapes_drawing;

public class Circle implements Drawable {
  private Integer radius;
  
  public Circle(Integer integer, Integer poll, Integer radius) {
    this.radius = radius;
  }
  
  public Integer getRadius() {
    return this.radius;
  }
  
  public void setRadius(Integer radius) {
    this.radius = radius;
  }
  
  @Override
  public void draw() {
    double r_in = this.getRadius() - 0.4;
    double r_out = this.getRadius() + 0.4;
    for (double y = this.getRadius(); y >= -this.getRadius(); --y) {
      for (double x = -this.getRadius(); x < r_out; x += 0.5) {
        double value = x * x + y * y;
        if (value >= r_in * r_in && value <= r_out * r_out) {
          System.out.print("*");
        } else
          System.out.print(" "); }
      System.out.println(); }
  }
}

package interfaces_and_abstraction.lab.shapes_drawing;

public class Rectangle implements Drawable{
  private Integer width;
  private Integer height;
  
  public Rectangle(Integer width, Integer height) {
    this.width = width;
    this.height = height;
  }
  
  public Integer getWidth() {
    return this.width;
  }
  
  public void setWidth(Integer width) {
    this.width = width;
  }
  
  public Integer getHeight() {
    return this.height;
  }
  
  public void setHeight(Integer height) {
    this.height = height;
  }
  
  @Override
  public void draw() {
    for (int i = 0; i < this.getHeight(); i++) {
      System.out.print("*");
      for (int j = 1; j < this.getWidth() - 1; j++) {
        System.out.print(" ");
        if (i == 0 || i == (this.getHeight() - 1)){
          System.out.print("*");
        } else { System.out.print(" "); }}
      System.out.print(" ");
      System.out.print("*");
      System.out.println();
    }
  }
}

package shape.example3;

/**
 * Created by Java Student on 10.11.2016.
 */
public class Square implements Shape {
  private double width;

  public Square(double width) {
        this.width = width;
    }

  public double calculateArea() {
    return width * width;
  }
}

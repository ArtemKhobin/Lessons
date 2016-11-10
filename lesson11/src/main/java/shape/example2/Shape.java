package shape.example2;

/**
 * Created by Java Student on 10.11.2016.
 */
public class Shape {
    public double calculateArea(Object obj) {
        double area = 0.0;
        if (obj instanceof Circle) {
            Circle circle = (Circle) obj;
            area = circle.getRadius() * circle.getRadius() * Math.PI;
        } else if (obj instanceof Square) {
            Square square = (Square) obj;
            area = square.getWidth() * square.getWidth();
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            area = rectangle.getWidth() * rectangle.getHeight();
        }

        return area;
    }
}

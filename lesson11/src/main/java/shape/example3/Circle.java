package shape.example3;

/**
 * Created by Java Student on 10.11.2016.
 */
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

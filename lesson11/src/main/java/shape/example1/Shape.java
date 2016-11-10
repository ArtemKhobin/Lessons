package shape.example1;

/**
 * Created by Java Student on 10.11.2016.
 */
public class Shape {
    private double width = 10.0;
    private double height = 15.0;
    private double radius = 5.0;

    public Shape(double width, double height, double radius) {
        this.width = width;
        this.height = height;
        this.radius = radius;
    }

    public double calculateArea(ShapeType shapeType) {
        switch (shapeType) {
            case SQUARE:
                return width*width;
            case RECTANGLE:
                return width*height;
            case CIRCLE:
                return Math.PI * radius * radius;
            default:
                return 0.0;

        }
    }
}

import shape.example3.*;
import template.Foo;
import template.Foo2;

public class Main {
  public static void main(String...args) {
    Circle circle = new Circle(5);
    Square square = new Square(4);
    Rectangle rect = new Rectangle(4, 5);

    System.out.println(circle.calculateArea());
    System.out.println(square.calculateArea());
    System.out.println(rect.calculateArea());

    //Foo foo = new Foo();
    Foo2 foo2 = new Foo2();
    foo2.init();

  }
}

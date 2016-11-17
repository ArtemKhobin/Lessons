package strategy;

/**
 * Created by Java Student on 14.11.2016.
 */
public class RubberDuck extends Duck {
  public RubberDuck(String name) {
    super(new FlyNoWay());
  }

  public void display() {
    System.out.println("I am a rubber duck");
  }
}

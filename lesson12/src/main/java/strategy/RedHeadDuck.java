package strategy;

/**
 * Created by Java Student on 14.11.2016.
 */
public class RedHeadDuck extends Duck {
  public RedHeadDuck(String name) {
    super(new FlyWithWings());
  }

  public void display() {
    System.out.println("I am a redhead duck");
  }
}

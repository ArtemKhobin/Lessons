package strategy;

/**
 * Created by Java Student on 14.11.2016.
 */
public class FlyNoWay implements FlyBehavior {
  public void fly() {
    System.out.println("I cannot fly");
  }
}

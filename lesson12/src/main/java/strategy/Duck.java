package strategy;

/**
 * Created by Java Student on 14.11.2016.
 */
public abstract class Duck {
  private FlyBehavior flyBehavior;

  public Duck(FlyBehavior flyBehavior) {
    this.flyBehavior = flyBehavior;
  }

  public abstract void display();

  public void quack() {
    System.out.println("Quack-quack");
  }

  public void fly() {
    flyBehavior.fly();
  }

  public void swim() {

  }
}

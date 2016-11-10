package template;

/**
 * Created by Java Student on 10.11.2016.
 */
abstract class Bar2 {
  public final void init() {
    createThing();
    configureThing();
  }

  public abstract void createThing();
  public void configureThing() {
    System.out.println("Thing configured in base class");
  }
}

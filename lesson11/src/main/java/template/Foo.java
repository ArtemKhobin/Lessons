package template;

/**
 * Created by Java Student on 10.11.2016.
 */
public class Foo extends Bar {
  int i = 10;

  public Foo() {
    super();
  }

  protected void init() {
    System.out.println("Foo.init(); i = " + i);
  }
}

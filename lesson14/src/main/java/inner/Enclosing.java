package inner;

/**
 * Created by Java Student on 21.11.2016.
 */
public class Enclosing<T> {
  int first;
  T tmp;
  public class Inner {
    public Inner() {

    }

    public void foo() {
      System.out.println(Enclosing.this.first);
    }
  }

  public static void esFoo() {
    System.out.println("Es");
    System.out.println(InnerStatic.innerInt);
  }

  static int sInt = 0;
  public static class InnerStatic {
    static int innerInt = 100;
    public static void foo() {
      System.out.println("sInt: " + sInt);
      sInt = 10;
      System.out.println("sInt: " + sInt);
    }

  }
}

import data.ArrayList;
import data.List;
import inner.Enclosing;

public class Main {
  public static void main(String...args) {
    /*Enclosing<Integer> enclosing = new Enclosing<>();
    Enclosing.InnerStatic.foo();
    Enclosing.esFoo();

    Enclosing.Inner inner = enclosing.new Inner();

    class LocalClass {
      void foo() {
        System.out.println("Local.foo");
      }
    }

    class LocalClass2 extends LocalClass {
      void foo() {
        System.out.println("Local2.foo");
      }
    }
    LocalClass local = new LocalClass();
    local.foo();
    LocalClass local2 = new LocalClass2();
    local2 .foo();*/

    List<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    System.out.println(list.size());

    for (Integer item : list) {

    }

  }
}

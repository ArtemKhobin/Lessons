public class Singleton {
  private static Singleton instance;
  private Singleton() {}

  public static synchronized Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    Singleton2.INSTANCE.foo();

    return instance;
  }
}

enum Singleton2 {
  INSTANCE;

  void foo() {
    System.out.println("ololo");
  }
}

class Singleton3 {
  private static Singleton3 instance = new Singleton3();

  public static Singleton3 getInstance() {
    return instance;
  }
}

class DCLSingleton {
  private static volatile DCLSingleton instance;

  private DCLSingleton() {}

  public static DCLSingleton getInstance() {
    if (instance == null) {
      synchronized (DCLSingleton.class) {
        if (instance == null) {
          instance = new DCLSingleton();
        }
      }
    }

    return instance;
  }
}

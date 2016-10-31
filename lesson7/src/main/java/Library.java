import jelementary.*;

public class Library {
  public static void main(String[] args) {
      Engineer eng = new Engineer("Vasya");
      eng.sayHello();

      QA qa = new QA("Ololosha");
      qa.sayHello();

      Developer dev = new Developer("Petya");
      dev.sayHello();
  }

    public boolean someLibraryMethod() {
        return true;
    }
}

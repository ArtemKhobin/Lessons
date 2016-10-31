package jelementary;

public class QA extends Engineer {
  public QA(String name) {
    super(name);
  }

  @Override
  public void sayHello() {
    System.out.println("Hello. I'm "+ name +" and I'm a QA engineer");
  }
}

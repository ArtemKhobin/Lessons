package jelementary;

public class Developer  extends Engineer {
  public Developer(String name) {
    super(name);
  }

  @Override
  public void sayHello() {
    System.out.println("Hello. I'm "+ name +" and I'm a Developer");
  }
}

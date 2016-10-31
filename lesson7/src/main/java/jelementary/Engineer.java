package jelementary;

public class Engineer {
  public String name;

  public Engineer(String name) {
    this.name = name;
  }

  public void sayHello() {
    System.out.println("Hello. I'm "+ name +" and I'm an engineer");
  }
}

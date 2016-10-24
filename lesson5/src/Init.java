public class Init {
  public static String staticString = "staticString";
  public String nonStaticString = "nonStaticString";

  public Init() {
    System.out.println(staticString);
    System.out.println(nonStaticString);
  }

  public void finalize() {
    System.out.println("ololo");
  }
}

package template;

/**
 * Created by Java Student on 14.11.2016.
 */
public class Application {
  private boolean run;
  private int counter = 0;

  public void run() {
    configure();
    run = true;
    while (run) {
      idle();
    }
    destroy();
  }

  public void configure() {
    System.out.println("Configuration");
  }

  public void destroy() {
    System.out.println("Destroy");
  }

  public void idle() {
    System.out.println("idle");
    counter++;
    if (counter > 10) run = false;
  }
}

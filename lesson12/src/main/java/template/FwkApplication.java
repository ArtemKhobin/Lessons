package template;

/**
 * Created by Java Student on 14.11.2016.
 */
abstract public class FwkApplication {
  private boolean run;
  private int counter = 0;

  public final void run() {
    configure();
    run = true;
    while (run) {
      idle();
      counter++;
      if (counter > 10) run = false;
    }
    destroy();
  }

  public abstract void configure();

  public abstract void destroy();

  public abstract void idle();
}

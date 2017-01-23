import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ThreadsTest {
  @Test
  public void testThread() throws Exception {
    Runnable runnableTask = new Runnable() {
      @Override
      public void run() {
        System.out.println("hello");
      }
    };

    Thread th = new Thread(runnableTask);
    th.start();
    th.join();
  }

  @Test
  public void testPriority() throws Exception {
    class PrintNumberTask implements Runnable {
      private int i;

      public PrintNumberTask(int i) {
        this.i = i;
      }

      @Override
      public void run() {
        System.out.println(i);
      }
    }

    for (int i = 0; i < 100; i++) {
      Thread thread = new Thread(new PrintNumberTask(i));
      if (i % 2 == 0) {
        thread.setPriority(Thread.MAX_PRIORITY);
      } else {
        thread.setPriority(Thread.MIN_PRIORITY);
      }
      thread.start();
    }

    TimeUnit.SECONDS.sleep(2);
  }
}

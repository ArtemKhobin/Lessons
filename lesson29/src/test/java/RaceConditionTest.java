import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class RaceConditionTest {
  @Test
  public void test1() throws Exception {
    final IntWrapper intWrapper = new IntWrapper();

    Runnable task = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          intWrapper.incrementOn(10);
        }
      }
    };

    Thread[] threads = new Thread[100];

    for (int i = 0; i < 100; i++) {
      threads[i] = new Thread(task);
      threads[i].start();
    }

    for (int i = 0; i < 100; i++) {
      threads[i].join();
    }

    TimeUnit.SECONDS.sleep(1);
    System.out.println(intWrapper.get());
  }

  @Test
  public void test3() throws Exception {
    class IntWrapper {
      private int i;
      synchronized public int get() {
        return i;
      }

      synchronized  public void incrementOn(int i) {
        this.i += i;
      }
    }

    final IntWrapper intWrapper = new IntWrapper();

    Runnable task = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          intWrapper.incrementOn(10);
        }
      }
    };

    Thread[] threads = new Thread[100];

    for (int i = 0; i < 100; i++) {
      threads[i] = new Thread(task);
      threads[i].start();
    }

    for (int i = 0; i < 100; i++) {
      threads[i].join();
    }

    TimeUnit.SECONDS.sleep(1);
    System.out.println(intWrapper.get());
  }

  @Test
  public void test4() throws Exception {

    IntWrapper intWrapper = new IntWrapper();

    Object lock = new Object();

    Runnable task = () -> {
      for (int i = 0; i < 1000; i++) {
        synchronized (lock) {
          intWrapper.incrementOn(10);
        }
      }
    };

    Thread[] threads = new Thread[100];

    for (int i = 0; i < 100; i++) {
      threads[i] = new Thread(task);
      threads[i].start();
    }

    for (int i = 0; i < 100; i++) {
      threads[i].join();
    }

    TimeUnit.SECONDS.sleep(1);
    System.out.println(intWrapper.get());
  }

  class IntWrapper {
    private int i;
    public int get() {
      return i;
    }

    public void incrementOn(int i) {
      this.i += i;
    }
  }
}

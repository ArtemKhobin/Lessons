import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ThreadStatesTest {
  @Test
  public void test() throws Exception {
    Thread.yield();
    Thread currentThread = Thread.currentThread();
    currentThread.start();
    currentThread.interrupt();
  }

  @Test
  public void testWaitNotify() throws Exception {
    Object lock = new Object();

    class Waiter implements Runnable {
      @Override
      public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " is going to acquire the lock");
        synchronized (lock) {
          System.out.println(name + " has acquired the lock");
          try {
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(name + " has released the lock");
      }
    }

    Thread th1 = new Thread(new Waiter(), "Thread #1");
    Thread th2 = new Thread(new Waiter(), "Thread #2");
    th1.start();
    th2.start();
    TimeUnit.SECONDS.sleep(1);
    synchronized (lock) {
      lock.notifyAll();
    }

    th1.join();
    th2.join();

    //TimeUnit.SECONDS.sleep(1);
  }
}

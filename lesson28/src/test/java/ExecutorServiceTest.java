import jdk.nashorn.internal.codegen.CompilerConstants;
import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.*;

public class ExecutorServiceTest {
  @Test
  public void testFixedThreadPool() throws Exception {
    ExecutorService service = Executors.newFixedThreadPool(2);

    Runnable task = new Runnable() {
      @Override
      public void run() {
        System.out.println("hello");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    service.submit(task);
    service.submit(task);
    service.submit(task);
    service.submit(task);
    service.submit(task);
    service.submit(task);
    service.submit(task);
    service.submit(task);
    service.submit(task);

    Thread.sleep(10000);
  }

  @Test
  public void testScheduledThreadPool() throws Exception {
    ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    Runnable task = new Runnable() {
      @Override
      public void run() {
        System.out.println("hello");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    service.schedule(task, 10, TimeUnit.SECONDS);


    Thread.sleep(15000);
  }

  @Test
  public void testCallable() throws Exception {
    ExecutorService service = Executors.newFixedThreadPool(2);

    Callable<String> task = new Callable() {
      @Override
      public String call() throws Exception {
        System.out.println("hello");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return "Future";
      }
    };

    Future<String> future = service.submit(task);
    //service.submit(task);
    //service.submit(task);

    System.out.println(future.get());
  }
}

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.*;

public class ThreadedSocketTest {
  @Test (timeout = 60000)
  public void testSimpleTcpServer() throws Exception {
    ServerSocket serverSocket = new ServerSocket(1331);
    while (true) {
      try (Socket connection = serverSocket.accept()) {
        OutputStream out = connection.getOutputStream();
        Writer writer = new OutputStreamWriter(out);

        writer.write("hello\n");
        writer.flush();

        Thread.sleep(5000);

        writer.write("Bye");
        writer.flush();
        connection.close();
      }
    }
  }

  @Test
  public void testSimpleThread() throws Exception {
    Thread th1 =  new MyThread(1);
    Thread th2 =  new MyThread(2);
    Thread th3 =  new MyThread(3);

    th1.start();
    th2.start();
    th3.start();


    th1.join();
    System.out.println(1);
    th2.join();
    System.out.println(2);
    th3.join();
    System.out.println(3);
  }

  Object objField = new Object();
  @Test
  public void testRunnable() throws Exception {
    int i = 10;
    Object obj = new Object();
    objField = null;
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("i = " + i);
        System.out.println("obj = " + obj);
        System.out.println("objField = " + objField);
        objField = new Object();

      }
    };


    new Thread(runnable).start();
    new Thread(runnable).start();
  }

  @Test (timeout = 60000)
  public void testMultiThreadedTcpServer() throws Exception {
    class Worker extends Thread {
      private Socket connection;

      public Worker(Socket connection) {
        this.connection = connection;
      }

      @Override
      public void run() {
        try {
          OutputStream out = connection.getOutputStream();
          Writer writer = new OutputStreamWriter(out);

          writer.write("hello\n");
          writer.flush();

          Thread.sleep(5000);

          writer.write("Bye");
          writer.flush();
          connection.close();
        } catch (IOException | InterruptedException e) {
          throw new RuntimeException();
        }
      }
    }

    ServerSocket serverSocket = new ServerSocket(1331);
    while (true) {
      try {
        Socket connection = serverSocket.accept();
        //new Thread(new Worker(connection).start());
        new Worker(connection).start();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}

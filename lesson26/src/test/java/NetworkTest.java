import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static org.junit.Assert.*;

public class NetworkTest {
  @Test
  public void test_nothing() throws Exception {

    try(Socket socket = new Socket()) {
      SocketAddress address = new InetSocketAddress("time-d.nist.gov", 13);
      socket.connect(address);

    } catch (IOException e) {
      e.printStackTrace();
    }

    assertEquals(true, true);
  }

  @Test
  public void testReadFromSocket() throws Exception {
    Socket socket = new Socket("time-d.nist.gov", 13);

    InputStream inputStream = socket.getInputStream();
    InputStreamReader reader = new InputStreamReader(inputStream);

    String response = "";
    int ch = 0;
    while ((ch = reader.read()) != -1) {
      response += (char) ch;
    }
    System.out.println(response);
  }

  @Test (timeout = 5000)
  public void testWhoisService() throws Exception {
    Socket socket = new Socket("whois.arin.net", 43);

    OutputStream outputStream = socket.getOutputStream();
    Writer writer = new OutputStreamWriter(outputStream);

    writer.write("n 127.0.0.1");
    writer.write("\r\n");
    writer.flush();

    InputStream inputStream = socket.getInputStream();
    InputStreamReader reader = new InputStreamReader(inputStream);

    String response = "";
    int ch = 0;
    while ((ch = reader.read()) != -1) {
      response += (char) ch;
    }
    System.out.println(response);
  }

  @Test (timeout = 20000)
  public void testServerSocket() throws Exception {
    ServerSocket serverSocket = new ServerSocket(1331);

    while (true) {
      Socket connection = serverSocket.accept();

      Writer writer = new OutputStreamWriter(connection.getOutputStream());
      writer.write(new Date().toString());
      //writer.write("\n");
      writer.flush();
      connection.close();
    }
  }

  @Test
  public void testAdvancedServer() throws Exception {
    try (ServerSocket serverSocket = new ServerSocket(1331)) {
      while (true) {
        try (Socket connection = serverSocket.accept()) {
          Server server= new Server(connection);
          boolean active = true;
          String command;
          while (active && (command = server.parseInputStream()) != null) {
            switch (command) {
              case "date":
                server.sendResponse(LocalDate.now().toString());
                break;
              case "time":
                server.sendResponse(LocalTime.now().toString());
                break;
              case "datetime":
                server.sendResponse(LocalDateTime.now().toString());
                break;
              case "quit":
                server.sendResponse("Good bye!");
                active = false;
                break;
            }
          }
          connection.close();

        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  private class Server {
    Socket connection;

    public Server(Socket connection) {
      this.connection = connection;
    }

    public String parseInputStream() throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      return reader.readLine();
    }

    public void sendResponse(String response) throws IOException {
      Writer writer = new OutputStreamWriter(connection.getOutputStream());
      writer.write(response);
      writer.write("\n");
      writer.flush();
    }




  }
}

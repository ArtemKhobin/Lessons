import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.junit.Assert.*;

public class UdpTest {
  @Test
  public void testClient() throws Exception {
    DatagramSocket socket = new DatagramSocket();

    String str = "Hello";
    byte[] data = str.getBytes();
    DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 1331);
    //DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getByName("192.168.1.111"), 1331);
    socket.send(packet);


    byte[] serverResponseData = new byte[32];
    DatagramPacket serverResponse = new DatagramPacket(serverResponseData, serverResponseData.length);
    socket.receive(serverResponse);
    System.out.println("Response: " + new String(serverResponseData));
  }

  @Test (timeout = 60000)
  public void testServer() throws Exception {
    DatagramSocket socket = new DatagramSocket(1331);

    while (true) {
      byte[] data = new byte[32];
      DatagramPacket request = new DatagramPacket(data, 0, data.length);
      socket.receive(request);
      System.out.format("Received from %s:%d - %s\n",
          request.getAddress(),
          request.getPort(),
          new String(data));


      DatagramPacket response = new DatagramPacket(data, 0, data.length, request.getAddress(), request.getPort());
      socket.send(response);
    }
  }
}

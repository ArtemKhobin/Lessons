import jdk.nashorn.internal.codegen.CompilerConstants;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.*;

import static org.junit.Assert.*;

public class MulticastPacketTest {
  @Test
  public void testServer() throws Exception {
    MulticastSocket socket = new MulticastSocket();

    InetAddress groupAddress = InetAddress.getByName("224.0.0.1");

    String str = "ololo";
    DatagramPacket packet = new DatagramPacket(str.getBytes(), 0, str.length(), groupAddress, 1331);

    socket.joinGroup(groupAddress);

    for (int i = 0; i < 10; i++) {
      socket.send(packet);
      Thread.sleep(2000);
    }

    socket.leaveGroup(groupAddress);
  }

  @Test
  public void testClient() throws Exception {
    MulticastSocket socket = new MulticastSocket(1331);

    InetAddress groupAddress = InetAddress.getByName("224.0.0.1");
    socket.joinGroup(groupAddress);

    while (true) {
      byte[] data = new byte[32];
      DatagramPacket packet = new DatagramPacket(data, data.length);
      socket.receive(packet);
      System.out.println(new String(data));


    //socket.leaveGroup(groupAddress);
    }
  }
}

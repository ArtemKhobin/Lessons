import org.junit.Test;
import org.junit.Before;

import java.io.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class SerializationTest {
  @Test
  public void testSer() throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"));

      User user = new User("ololosha", "qqq");

    out.writeObject(user);
    out.close();

    ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"));

    User rUser = (User) in.readObject();

    assertThat(user.getPassword(), is(rUser.getPassword()));
    assertThat(user.getUsername(), is(rUser.getUsername()));
  }
}

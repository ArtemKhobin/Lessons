import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;

import java.io.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class StreamTest {
  @Test
  public void bufferedInputStream() throws Exception {
    File file = new File("chaos.txt");

    InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

    int data;
    while ((data = inputStream.read()) != -1) {
      System.out.print((char)data);
    }
    inputStream.close();
  }

  @Test
  public void bufferedReader() throws Exception {
    File file = new File("chaos.txt");

    BufferedReader reader = new BufferedReader(new FileReader(file));

    String out;

    while ((out = reader.readLine()) != null) {
      System.out.println(out);
    }

    reader.close();
  }

  @Test
  public void testByteArrayInputStream() throws Exception {
   // String text = "Hello";
    String text = "Привет";

    InputStream inputStream = new ByteArrayInputStream(text.getBytes());
    int data, chCount = -1;
    do {
      data = inputStream.read();
      System.out.println((char)data);
      chCount++;
    } while (data != -1);
    inputStream.close();

    assertThat(chCount, is(text.length()));
  }

  @Test
  public void testCharArrayReader() throws Exception {
    //String text = "Hello";
    String text = "Привет";

    Reader reader = new CharArrayReader(text.toCharArray());
    int data, chCount = -1;
    do {
      data = reader.read();
      System.out.println((char)data);
      chCount++;
    } while (data != -1);
    reader.close();

    assertThat(chCount, is(text.length()));
  }

  @Test
  public void testOutputFileStream() throws Exception {
    String text = "Just compare heart, beard, and heard,\n" +
        "Dies and diet, lord and word,\n" +
        "Sword and sward, retain and Britain.\n" +
        "(Mind the latter, how it's written.)\n" +
        "Now I surely will not plague you\n" +
        "With such words as plaque and ague.\n" +
        "But be careful how you speak:\n" +
        "Say break and steak, but bleak and streak;\n" +
        "Cloven, oven, how and low,\n" +
        "Script, receipt, show, poem, and toe.";

    OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("ololo.txt"));
    outputStream.write(text.getBytes());

    //outputStream.flush();
    outputStream.close();

  }

  @Test
  public void testFileWriter() throws Exception {
    String text = "Just compare heart, beard, and heard,\n" +
        "Dies and diet, lord and word,\n" +
        "Sword and sward, retain and Britain.\n" +
        "(Mind the latter, how it's written.)\n" +
        "Now I surely will not plague you\n" +
        "With such words as plaque and ague.\n" +
        "But be careful how you speak:\n" +
        "Say break and steak, but bleak and streak;\n" +
        "Cloven, oven, how and low,\n" +
        "Script, receipt, show, poem, and toe.";

    Writer writer = new BufferedWriter(new FileWriter("ololo1.txt"));
    writer.write(text.toCharArray());

    writer.close();

  }

  @Test
  public void testPrintStream() throws Exception {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(out);

    printStream.println(10);
    printStream.println("Ten");

    printStream.close();

    String str = new String(out.toByteArray());
  }

  @Test
  public void testSystemOut() throws Exception {
    OutputStream out = new FileOutputStream("system.out");
    PrintStream printStream = new PrintStream(out);

    System.setOut(printStream);

    System.out.println("Hello system.out");
  }

}

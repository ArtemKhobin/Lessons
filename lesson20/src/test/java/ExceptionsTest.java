import org.junit.Test;
import org.junit.Before;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ExceptionsTest {
  @Test
  public void test1() {
    try {
      System.out.println("One");
      foo();
      System.out.println("Two");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    //assertThat(list.get(4), is(50));

    //list.add(1);
  }

  @Test
  public void test2() {
    try {

    } catch (Exception e) {

    }

  }



  private void foo() throws Exception {
    throw new Exception("Hello");
  }

  private static class MyException extends RuntimeException {

  }
}

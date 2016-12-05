import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class RecursionTest {
  @Test
  public void test1() {
    assertThat(factorial(5), is(5*4*3*2*1));
    assertThat(factorial(10), is(10*9*8*7*6*5*4*3*2*1));
  }

  int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
  }

}

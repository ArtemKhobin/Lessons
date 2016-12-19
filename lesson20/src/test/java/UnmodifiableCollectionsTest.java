import org.junit.Test;
import org.junit.Before;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class UnmodifiableCollectionsTest {
  @Test
  public void test1() {
    List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
    assertThat(list.get(0), is(10));
    assertThat(list.get(1), is(20));
    assertThat(list.get(2), is(30));
    assertThat(list.get(3), is(40));
    assertThat(list.get(4), is(50));

    //list.add(1);
  }

  @Test
  public void test2() {
    List<Integer> list = new ArrayList<>();

    list.add(10);
    list.add(20);
    list.add(30);

    for (int i = 0; i < list.size(); i++) {

    }

    for (int item : new ArrayList<>(list)) {
      if (item == 20) {
        list.add(100);
      }
    }

    assertThat(list.get(3), is(100));
  }

  @Test
  public void test4() {
    assertThat(Collections.emptyList().size(), is(0));
  }

  @Test
  public void test5() {
    Optional<Integer>  opt = Optional.of(100);
    assertThat(opt.get(), is(100));
  }
}

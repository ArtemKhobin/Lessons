import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

//import java.util.Queue;

public class StackTest {
  @Test
  public void test1() {
    Stack<Integer> stack = new Stack<>();

    stack.push(10);
    assertThat(stack.pop(), is(10));
  }

  @Test
  public void test2() {
    Stack<Integer> stack = new Stack<>();

    stack.push(10);
    stack.push(20);
    stack.push(30);
    assertThat(stack.pop(), is(30));
    assertThat(stack.pop(), is(20));
    assertThat(stack.pop(), is(10));
  }

  @Test
  public void test3() {
    Stack<Integer> stack = new Stack<>();

    stack.push(10);
    stack.push(20);
    stack.push(30);

    stack.pop();
    stack.pop();

    stack.push(40);

    assertThat(stack.pop(), is(40));
    assertThat(stack.pop(), is(10));
  }

  @Test
  public void test4() {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < 20; i++) {
      stack.push(i);
    }

    for (int i = 19; i <= 0; i--) {
      assertThat(stack.pop(), is(i));
    }
  }

  private class Stack<T> {
    private Object[] elements = new Object[10];
    private int size = 0;

    public void  push(T item) {
      if (isFull()) {
        increaseCapacity();
      }
      elements[size++] = item;
    }


    @SuppressWarnings("unchecked")
    public T pop() {
      size--;
      T elem = (T) elements[size];
      elements[size] = null;
      return elem;
    }

    private boolean isFull() {
      return elements.length == size;
    }

    private void increaseCapacity() {
      elements = Arrays.copyOf(elements, elements.length + 10);
    }
  }
}

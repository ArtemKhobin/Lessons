import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class PQTest {
  @Test
  public void test1() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.insert(10);
    pq.insert(30);
    pq.insert(20);
    pq.insert(50);
    pq.insert(40);
    assertThat(pq.max(), is(50));
    assertThat(pq.max(), is(40));
    assertThat(pq.max(), is(30));
  }

  @Test
  public void test2() {
    PriorityQueue<Integer> pq = new PriorityQueue<>(new WeirdIntegerComparator<>());
    pq.insert(10);
    pq.insert(30);
    pq.insert(20);
    pq.insert(50);
    pq.insert(40);
    assertThat(pq.max(), is(10));
    assertThat(pq.max(), is(20));
    assertThat(pq.max(), is(30));
  }



  class WeirdIntegerComparator<T extends Integer> implements Comparator<T> {
    @Override
    public int compare(T left, T right) {
      return Integer.compare((Integer) left, (Integer) right) * -1;
    }
  }

  class PriorityQueue<T> {
    private Object[] elements = new Object[16];
    private int size = 0;
    private Comparator<T> comparator;

    PriorityQueue() {}

    PriorityQueue(Comparator<T> comparator) {
      this.comparator = comparator;
    }

    void insert(T item) {
      if (elements.length == size) {
        elements = Arrays.copyOf(elements, elements.length * 2);
      }

      elements[++size] = item;

      swim(size);
    }

    T max() {
      T max = (T) elements[1];
      exchange(1, size);
      elements[size] = null;
      size--;
      sink(1);
      return max;
    }

    private boolean lessOrEqual(int n, int m) {
      if (comparator == null) {
        return ((Comparable)elements[n]).compareTo(elements[m]) < 1;
      } else {
        return comparator.compare((T)elements[n], (T)elements[m]) < 1;
      }

    }

    private void swim(int k) {

      while (!isRoot(k) && lessOrEqual(k / 2, k)) {
        exchange(k, k / 2);
        k = k / 2;
      }
    }

    private void sink(int k) {
      //k*2 = left
      //k*2-1 = right
      while (k * 2 <= size) {
        int childOfK = k * 2;
        if (childOfK < size && lessOrEqual(childOfK, childOfK + 1)) {
          childOfK++;
        }

        if(lessOrEqual(k, childOfK)) {
          exchange(k, childOfK);
          k = childOfK;
        } else {
          break;
        }
      }
    }

    private boolean isRoot(int k) {
      return k == 1;
    }

    private void exchange(int index1, int index2) {
      T temp = (T)elements[index1];
      elements[index1] =  elements[index2];
      elements[index2] = temp;
    }
  }
}

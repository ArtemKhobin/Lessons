import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class STableTest {
  @Test
  public void test1() {
    Map<Integer, String> map = new Map<>();
    map.put(1, "One");
    map.put(11, "Eleven");
    map.put(3, "Three");

    assertThat(map.get(1), is("One"));
    assertThat(map.get(3), is("Three"));
    //assertThat(map.get(11), is("Eleven"));
    assertThat(map.get(30), is(nullValue()));
  }

  private class Map<K, V> {
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];
    private int size = 0;

    void put(K key, V value) {
      //keys[size] = key;
      //values[getIndex(key)] = value;
      Node node = new Node();
      node.key = key;
      node.value = value;

      int index = getIndex(key);
      if (values[index] == null) {
        values[index] = node;
      } else {
        Node n = (Node) values[index];
        while(n.next != null) {
          if (n.key.equals(key)) {
            n.value = value;
            return;
          }
          n = n.next;
        }
        n.next = node;
      }
      size++;
    }

    V get(K key) {
      int index = getIndex(key);
      Node node = (Node) values[index];
      if (node != null) {
        do {
          if (node.key.equals(key)) {
            return node.value;
          }
          node = node.next;
        } while(node.next != null);
      }
      return null;
    }

    void delete(K key) {
    }

    private int getIndex(K key) {
      return key.hashCode() % values.length;
    }

    private int hash(K key){
      return key.hashCode();
    }

    private class Node {
      K key;
      V value;
      Node next;

    }


  }
}

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class BSTTest {
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

  private class Map<K extends Comparable, V> {
    private Node root;
    private class Node {
      K key;
      V value;
      Node left;
      Node right;
    }
    void put(K key, V value) {
      root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
      if (node == null) {
        Node n = new Node();
        n.key = key;
        n.value = value;
        return n;
      } else {
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
          node.left = put(node.left, key, value);
        } else if (cmp > 0) {
          node.right = put(node.right, key, value);
        } else {
          node.value = value;
        }
      }
      return node;
    }

    V get(K key) {
      return get(root, key);
    }
    private V get(Node node, K key)  {
      if (node == null) {
        return null;
      } else {
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
          return get(node.left, key);
        } else if (cmp > 0) {
          return get(node.right, key);
        } else {
          return node.value;
        }
      }
    }
  }

}

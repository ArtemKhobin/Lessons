package data;

/**
 * Created by Java Student on 17.11.2016.
 */
public class Bag<Item> {
  private Node<Item> firstNode = new Node<>();
  private int size;

  private static class Node<Item> {
    Item value;
    Node<Item> next;
  }

  class Iterator<Item> {
    public boolean hasNext() {
      return isEmpty();
    }

    public Item next() {
      return null;
    }
  }

  public Iterator<Item> iterator() {
    return new Iterator<Item>();
  }

  public void add(Item item) {
    if ( isEmpty() ) {
      firstNode.value = item;
    } else {
      Node<Item> previous = firstNode;
      firstNode.value = item;
      firstNode.next = previous;
      size++;
    }
  }

  public boolean isEmpty() {
    return firstNode == null;
  }

  public int size() {
    return 1;
  }
}

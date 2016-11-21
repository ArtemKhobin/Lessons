package data;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Java Student on 21.11.2016.
 */
public class ArrayList<T> implements List<T> {
  Object[] data;
  int size;

  public void add(T item) {
    if (data == null) {
      data = new Object[1];
      data[0] = item;
    } else {
      Object[] newData = Arrays.copyOf(data, data.length + 1);
      newData[data.length] = item;
      data = newData;
    }
    size++;
  }

  public T get(int index) {
    return (T) data[index];
  }

  public int size() {
    return size;
  }

  public Iterator<T> iterator() {
    return new Iterator<T>() {
      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public T next() {
        return null;
      }
    };
  }


}

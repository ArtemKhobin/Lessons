package data;

/**
 * Created by Java Student on 21.11.2016.
 */
public interface List<T> extends Iterable<T> {
  void add(T item);
  T get(int index);
  int size();
}

public class Main {
  public static void main(String...args) {
    List rawList = new List();

    //rawList.add(10);

    //List<Integer> list2 = new List<>();
    //list2 = rawList;

    List<Number> listNum = new List<>();
    listNum.add(10);
    listNum.add(20L);
    listNum.add(1.45);

    listNum.add(new List<Number>());
    //listNum.add(new List<Integer>());
    listNum.add(new List3<Number>());

    Tuple<Integer, String> t1 = new Tuple<>(10, "20");
    int a = t1.first;
    String b = t1.second;

    Tuple<Long, String> t2 = Tuple.<Long, String>create(1L, "John");

    List2<FooBar> list2 = new List2<>();

    GenericList<String> strList = new GenericList<>();
    strList.addList(new GenericList<Integer>());

    StringTuple<String> st = new StringTuple<>("aa", "bb");
  }
}

class List<T extends Number> {
  void add(T item) {}
  void add(List<T> list) {}
}

class List3<T extends Number> extends List<T>{
  void add(T item) {}
  void add(List<T> list) {}
}

class List2<T extends Foo & Bar> {
  void add(T item) {

  }
}

class GenericList<T> {
  void addList(GenericList<? extends  Number> list) {

  }
}

interface Foo {}
interface Bar {}
class FooBar implements Foo, Bar {}

class Tuple<T, S extends String> {
  public final T first;
  public final S second;

  public Tuple(T first, S second) {
    this.first = first;
    this.second = second;
  }

  public static <T, S extends String> Tuple<T, S> create(T first, S second) {
    return new Tuple<>(first, second);
  }
}

class StringTuple extends Tuple<String, String> {
  public StringTuple(String first, String second) {
    super(first, second);
  }
}
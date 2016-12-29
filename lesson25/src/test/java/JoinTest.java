import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JoinTest {
  private ArrayList<Pair<Integer, String>> leftTable;
  private ArrayList<Pair<Integer, String>> rightTable;
  @Before
  public void setUp() throws Exception {
    leftTable = new ArrayList<>();
    rightTable = new ArrayList<>();

    leftTable.add(new Pair<>(1, "Ololo olo"));
    leftTable.add(new Pair<>(2, "Jolo lo"));
    leftTable.add(new Pair<>(3, "Abc def"));

    rightTable.add(new Pair<>(1, "Java"));
    rightTable.add(new Pair<>(1, "SQL"));
    rightTable.add(new Pair<>(2, "PHP"));
    rightTable.add(new Pair<>(2, "JS"));

  }

  @Test
  public void test2() throws Exception {
    List<Triple<Integer, String, String>> result = crossJoin(leftTable, rightTable);
    printResult(result);
  }

  private <K, V1, V2> void printResult(List<Triple<K, V1, V2>> result) {
    for (Triple<K, V1, V2> triple : result) {
      System.out.format("[ %s | %s | %s }\n", triple.key, triple.value, triple.value2);
    }
    System.out.printf("---\nSize: %d", result.size());
  }

  private <K, V1, V2> List<Triple<K, V1, V2>> crossJoin(List<Pair<K, V1>> leftTable, List<Pair<K, V1>> rightTable) {
    List<Triple<K, V1, V2>> result = new ArrayList<>();
    for (Pair<K, V1> leftRecord : leftTable) {
      for (Pair<K, V1> rightRecord : rightTable) {

      }
    }
    return Collections.emptyList();
  }

  private class Pair<K, V> {
    final K key;
    final V value;

    public Pair(K key, V value) {
      this.key = key;
      this.value = value;

    }
  }

  private class Triple<K, V, V2> extends Pair<K, V> {
    final V2 value2;
    public Triple(K key, V value, V2 value2) {
      super(key, value);
      this.value2 = value2;
    }
  }
}

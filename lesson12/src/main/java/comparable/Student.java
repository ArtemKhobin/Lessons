package comparable;

/**
 * Created by Java Student on 14.11.2016.
 */
public class Student implements Comparable <Student> {
  int score;
  String name;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String toString() {
    return "Name: " + name + "; Score: " + score;
  }

  public int compareTo(Student other) {
    return this.score - other.score;
  }
}

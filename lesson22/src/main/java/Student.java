import java.io.Serializable;

public class Student implements Serializable {
  int age;
  double score;
  String name;

  //public Student() {}

  public Student(int age, double score, String name) {
    this.age = age;
    this.name = name;
    this.score = score;
  }

  public String toString() {
    return this.name + " " + this.age + " " + this.score;
  }
}
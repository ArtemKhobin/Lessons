import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
  private String name;
  public List<Student> students = new ArrayList<>();

  public Group(String name) {
    this.name = name;
  }

  public void addStudent(Student student) {
    students.add(student);
  }

}

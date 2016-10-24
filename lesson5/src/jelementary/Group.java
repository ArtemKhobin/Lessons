package jelementary;
import jelementary.people.*;

import java.util.Arrays;

public class Group {
  private String name;
  private Student[] students;

  public Group(String name) {
    this.name = name;
  }

  public Group(String name, Student[] students) {
    this(name);
    this.students = students;
  }

  public void addStudent(Student newStudent) {
    if (students == null) {
      students = new Student[] {newStudent};
      return;
    }
    students = Arrays.copyOf(students, students.length+1);
    students[students.length - 1] = newStudent;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    String result = "Group name: " + name;
     if (students != null) {
      result += "; Students: ";
      for (int i = 0; i < students.length; i++) {
        result += students[i].getName() + ", ";
      }
    }
    return result;
  }
}

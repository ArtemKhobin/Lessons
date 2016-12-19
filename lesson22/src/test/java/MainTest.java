import org.junit.Test;
import org.junit.Before;

import java.io.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
public class MainTest {
  @Test
  public void test1() throws Exception {
    DataInput in = new DataInputStream(new FileInputStream("chaos.txt"));
    System.out.println(in.readLine());
    System.out.println(in.readBoolean());
    System.out.println(in.readDouble());
    System.out.println(in.readChar());
    System.out.println(in.readByte());
    assertEquals(true, true);
  }

  @Test
  public void test2() throws Exception {
    DataOutput out = new RandomAccessFile("chaos_out.txt", "rw");
    out.writeChar('a');
    out.writeBoolean(false);
    out.writeChar('Ы');
    out.writeBoolean(true);
    out.writeInt(10);

    DataInput in = new DataInputStream(new FileInputStream("chaos_out.txt"));
    assertThat(in.readChar(), is('a'));
    assertThat(in.readBoolean(), is(false));
    assertThat(in.readChar(), is('Ы'));
  }

  @Test
  public void serializationTest() throws Exception {

    /*Student student = new Student();
    student.age = 20;
    student.score = 100.0;
    student.name = "John Doe";

    ObjectOutput out = new ObjectOutputStream(new FileOutputStream("student.ser"));
    out.writeObject(student);
    out.close();

    ObjectInput in = new ObjectInputStream(new FileInputStream("student.ser"));
    Student rStudent = (Student) in.readObject();

    assertThat(rStudent.age, is(20));
    assertThat(rStudent.score, is(100.0));
    assertThat(rStudent.name, is("John Doe"));*/
  }

  @Test
  public void inheritanceSerializationTest() throws Exception {
    Student vasya = new Student(17, 89.3, "Vasya Vasin");
    Student petya = new Student(20, 34.6, "Petya Petin");
    Student ololosha = new Student(18, 98.5, "Ololosha Ololoev");

    Group group = new Group("Ololo group");
    group.addStudent(vasya);
    group.addStudent(petya);
    group.addStudent(ololosha);

    ObjectOutput out = new ObjectOutputStream(new FileOutputStream("group.ser"));
    out.writeObject(group);
    out.close();

    ObjectInput in = new ObjectInputStream(new FileInputStream("group.ser"));
    Group restoredGroup = (Group) in.readObject();

    System.out.println(restoredGroup.students);


  }
}

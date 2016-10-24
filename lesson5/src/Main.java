import jelementary.*;
import jelementary.people.*;

class Main {
  public static void main(String ... args) {
    School school = new School("New school");
    Group firstGroup = new Group("A-10");
    Group secondGroup = new Group("A-21");
    school.addGroup(firstGroup);
    school.addGroup(secondGroup);
    System.out.println(school);

    Student vasya = new Student("Vasya Vasin");
    Student ololosha = new Student("Ololosha Ololoev");
    firstGroup.addStudent(vasya);
    firstGroup.addStudent(ololosha);
    System.out.println(firstGroup);
    System.out.println();

    Init init = new Init();
    init = null;
    //
    //Student student = new Student();
  }
}

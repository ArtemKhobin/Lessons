import comparable.Student;
import strategy.Duck;
import strategy.RedHeadDuck;
import strategy.RubberDuck;
import template.Application;
import template.Application2;

import java.util.Arrays;

public class Main {
  public static void main(String ...args) {
    //Application app = new Application();
    //app.run();

    //Application2 app = new Application2();
    //app.run();

    /*Student st1 = new Student("Ololosha", 3);
    Student st2 = new Student("Vasya", 6);
    Student st3 = new Student("Petya", 7);

    Student[] students = {st1, st2, st3};
    int found = Arrays.binarySearch(students, st2);
    System.out.println(students[found]);*/

    RedHeadDuck duck1 = new RedHeadDuck("Duck");
    duck1.display();
    duck1.quack();
    duck1.fly();

    RubberDuck duck2 = new RubberDuck("Rubber");
    duck2.fly();
  }
}

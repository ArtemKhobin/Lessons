import org.junit.Test;
import zoo.*;

import static org.junit.Assert.*;

public class MainTest {
  @Test
  public void test_nothing() {
    assertEquals(true, true);
  }

  @Test
  public void test_casting() {
    Animal animal = new Animal();
    Cat cat = new Cat();
    Dog dog = new Dog();

    //animal = cat;

    System.out.println(animal);
    System.out.println(dog);
    //dog = (Dog) animal;
    //assertEquals(cat, dog);
  }

}

package program;

class Lesson3 {

  public static void main(String[] args) {

    Student student = new Student("Ololosha Ololoev", 33, 40);

    Student student2 = new Student("Petya Petin", 24);

    //System.out.println(student);
    //System.out.println(student2);

    while (student.isAlive()) {
      student.growImmediately();
      System.out.println(student);
    }

    System.out.println("Total: " + Student.studentsQty);

  }

}

class Student {
  String name;
  int age, deadAge = 90;
  public static int studentsQty = 0;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
    studentsQty++;
  }

  public Student(String name, int age, int deadAge) {
    this(name, age);
    this.deadAge = deadAge;
  }

  public String toString() {
    if ( ! isAlive() ) return "I'm dead now";
    return "Name: " + getName() + "; age:" + getAge();
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public boolean isAlive() {
    return age <= deadAge;
  }

  public void growImmediately() {
    age++;
  }
}

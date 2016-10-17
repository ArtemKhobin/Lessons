package lesson2;

class FirstProgram {

  static int age = 25;

  public static void main(String[] args) {
    int i = 10;
    for (int j = 100; j > 0; j--) {
      System.out.print( j + " is ");
      System.out.println( isEven(j) ? "even" : "odd" );
    }
  }

  public static boolean isEven(int i) {
    return i % 2 == 0;
  }

  public static void println(String text) {
    System.out.println(text);
  }
}

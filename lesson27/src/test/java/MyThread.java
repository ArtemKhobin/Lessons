public class MyThread extends Thread {
  int i;
  public MyThread(int i) {
    this.i = i;
  }

  @Override
  public void run() {
    try {
      System.out.println("hello" + i);
      this.sleep(1000 * i);
      super.run();
    } catch (Exception e){

    }

  }
}

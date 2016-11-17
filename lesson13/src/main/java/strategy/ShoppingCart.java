package strategy;

/**
 * Created by Java Student on 17.11.2016.
 */
public class ShoppingCart {
  private double total;
  public void addBook(String name, double price) {
    total += price;
  }

  public void pay(PaymentStrategy paymentStrategy) {
    paymentStrategy.pay(total);
  }
}

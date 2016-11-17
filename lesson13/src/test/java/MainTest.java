import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import strategy.PaymentStrategy;
import strategy.PayPalPaymentStrategy;
import strategy.ShoppingCart;

import static org.junit.Assert.*;


public class MainTest {
  ShoppingCart cart;
  @Before
  public void setUp() {
    cart = new ShoppingCart();
    cart.addBook("Head First Design Patterns", 30.0);
    cart.addBook("Head First Java", 30.0);
    cart.addBook("Java for dummies", 20.0);
  }

  @Test
  public void test_api() {
    cart.pay(new PaymentStrategy() {
      public void pay(double total) {
        //ololo
      }
    });

    assertEquals(true, true);
  }

 /* @Ignore @Test
  public void test_cartTotal_isCalculated() {
    assertThat(cart.total, is(30.0 + 30.0 + 20.0));
  }*/

  @Test
  public void paymentStrategy_payMethod_ShouldBeCalled_whenCartPayMethodIsCalled() {
    boolean[] callAttempt = {false};
    cart.pay(new PaymentStrategy() {
      @Override
      public void pay(double total) {
        callAttempt[0] = true;
      }
    });

    assertThat(callAttempt[0], is(true));

  }

  @Test
  public void paymentStrategy_payMethod_shouldReceiveRightTotal() {
    double[] totalPrice = {0.0};
    cart.pay(new PaymentStrategy() {
      @Override
      public void pay(double total) {
        totalPrice[0] = total;
      }
    });

    assertThat(totalPrice[0], is(30.0 + 30.0 + 20.0));

  }

  @Test
  public void payPalPaymentStrategy_api() {

    cart.pay(new PayPalPaymentStrategy("email@example.com", "Books", 100.0));

    assertEquals(true, true);
  }

}

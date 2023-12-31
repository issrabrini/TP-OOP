package OrderManager.Payment;

// OrderManger.Payment.CashPayment class implementing OrderManger.Payment.PaymentMethod
public class CashPayment implements PaymentMethod {
    // Implementing the processPayment method
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment of $" + amount);
    }
}

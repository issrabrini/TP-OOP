package OrderManager.Payment;

import java.time.LocalDate;

public class CreditCardPayment implements PaymentMethod {
    private String cardholderName;
    private String creditCardNumber;
    private LocalDate expirationDate;
    private int cvv;

    public CreditCardPayment(String cardholderName, String creditCardNumber, LocalDate expirationDate, int cvv) {
        this.cardholderName = cardholderName;
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }
    //  implement the processPayment method
    @Override
    public void processPayment(double amount)
    {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Cardholder: " + cardholderName);
        System.out.println("Credit Card Number: ****-****-****-" + creditCardNumber.substring(12));
        System.out.println("Expiration Date: " + expirationDate);
        System.out.println("CVV: ***");
        System.out.println("Payment successful. Transaction ID: " + generateTransactionId());

    }


    private String generateTransactionId()
    {
        return "TXN-" + System.currentTimeMillis();
    }
}

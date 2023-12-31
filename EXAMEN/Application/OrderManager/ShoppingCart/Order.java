package OrderManager.ShoppingCart;

import OrderManager.Payment.PaymentMethod;
import Product.Product;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private LocalDateTime orderDate;
    private List<Product> orderedItems;
    private double totalAmount;
    private PaymentMethod paymentMethod;
    private double packageWeight;
    // Constructor
    public Order(List<Product> orderedItems, double totalAmount, PaymentMethod paymentMethod,double packageWeight) {
        this.orderId = nextOrderId++;
        this.orderDate = LocalDateTime.now();
        this.orderedItems = orderedItems;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.packageWeight = packageWeight;
    }
    // Display order details
    public void displayOrder() {
        System.out.println("OrderManger.ShoppingCart.Order ID: " + orderId);
        System.out.println("OrderManger.ShoppingCart.Order Date: " + orderDate);
        System.out.println("Ordered Items:");
        for (Product product : orderedItems) {
            product.displayInfo();
        }
        System.out.println("Total Amount: $" + totalAmount);
    }
}

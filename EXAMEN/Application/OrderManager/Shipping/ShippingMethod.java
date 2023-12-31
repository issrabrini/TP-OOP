package OrderManager.Shipping;

public interface ShippingMethod {
    double calculateShippingCost(double packageWeight);
}

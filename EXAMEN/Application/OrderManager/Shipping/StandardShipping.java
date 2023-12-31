package OrderManager.Shipping;

public class StandardShipping implements ShippingMethod {
    // Calculate shipping cost
    @Override
    public double calculateShippingCost(double packageWeight) {
        return 2.5 * packageWeight;
    }
}

package OrderManager.Shipping;

public class ExpressShipping implements ShippingMethod {
    // Implementing the calculateShippingCost method
    public double calculateShippingCost(double packageWeight) {
        return 5 * packageWeight;
    }
}

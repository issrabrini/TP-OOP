package OrderManager.Shipping;

public class ShippingManager {
    private ShippingMethod shippingMethod;
    private double packageWeight;
    // Constructor
    public ShippingManager(ShippingMethod shippingMethod, double packageWeight) {
        this.shippingMethod = shippingMethod;
        this.packageWeight = packageWeight;
    }
    // Calculate shipping cost
    public double calculateShippingCost() {
        return shippingMethod.calculateShippingCost(packageWeight);
    }
}

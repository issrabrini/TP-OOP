package Product;

import Product.Product;
import Product.Review;

public class SkinCare extends Product {
    private String purpose;
    //Constructor:
    public SkinCare( String name, double price, String brand, String purpose, int quantity, int id,double weight){
        super( name, price, brand, quantity, id, weight);
        this.purpose = purpose;
    }
    //Displaying Product.Product Info:
    @Override
    public void displayInfo() {
        System.out.println("Product.SkinCare - ID: " + getId() + " | " + getName() + " | Price: $" + getPrice() + " | Brand: " + getBrand()+ " | Purpose: " + purpose+ " | Quantity: " + getQuantity());
        System.out.println("Reviews: ");
        for(Review review : reviews)
        {
            review.displayReview();
        }
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public String getPurpose() {
        return purpose;
    }

}


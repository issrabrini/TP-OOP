package Product;

import Product.Product;

public class Makeup extends Product {
    public Makeup( String name, double price, String brand, int quantity, int id, double  weight) {
        super(name, price, brand, quantity,id,weight);

    }
    //Displaying Product.Product Info:
    @Override
    public void displayInfo() {
        System.out.println("MakeUp - ID: " + getId() + " | " + getName() + " | Price: $" + getPrice() + " | Brand: " + getBrand()+ " | Quantity: " + getQuantity());
        System.out.println("Reviews: ");
        for(Review review : reviews)
        {
            review.displayReview();
        }
    }


}

package Product;

import Product.Product;

public class Clothing extends Product {
    private int size ;


    public Clothing( String name, double price, String brand, int size, int quantity, int id, double weight) {
        super(name, price, brand, quantity,id,weight);
        this.size = size;

    }
    //Overriding the displayInfo() method from the Product.Product class:
    @Override
    public void displayInfo() {
        System.out.println("Product.Clothing - ID: " + getId() + " | " + getName() + " | Price: $" + getPrice() + " | Brand: " + getBrand()+ " | Size: " + size + " | Quantity: " + getQuantity());
        System.out.println("Reviews: ");
        for(Review review : reviews)
        {
            review.displayReview();
        }
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
}

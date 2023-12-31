package Product;

import Account.User;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Product {

    protected int id;
    protected String name;
    protected double price;
    protected String brand;
    protected int quantity;
    protected double weight;
    protected ArrayList<Review> reviews = new ArrayList<Review>();



    public Product(String name, double price, String brand, int quantity, int id, double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
        this.weight = weight;
    }
    public abstract void displayInfo();
    //Adding a review to the product:
    public void addReview(User user) {
        int rating;
        Scanner scanner = new Scanner(System.in);
        String review;
        System.out.println("Enter rating: ");
        rating = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter review: ");
        review = scanner.nextLine();
        Review rev = new Review(rating, review, user);
        reviews.add(rev);
    }

    //getters and setters:
    public int getId() {
        return id;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight= weight;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
}

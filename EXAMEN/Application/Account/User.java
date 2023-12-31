package Account;

import Account.Account;
import OrderManager.ShoppingCart.History;
import OrderManager.ShoppingCart.Order;
import OrderManager.ShoppingCart.ShoppingCart;
import Product.ProductCatalog;
import Product.Product;

import java.util.List;

/**
 * The `Account.User` class represents a user account in the e-commerce application. This class extends the `Account.Account` class
 * to inherit basic account functionalities and introduces specific features related to shopping and order management.
 */
public class User extends Account {
    private ShoppingCart shoppingCart; // Account.User's shopping cart for managing selected products
    private ProductCatalog productCatalog; // Reference to the product catalog for retrieving product information
    private History history;// Account.User's order history for tracking past purchases
    // Constructor
    public User() {
        super();
        shoppingCart = new ShoppingCart();
        history = new History();
    }
    /**
     * Displays all products currently in the user's shopping cart.
     */
    public void displayShoppingCart() {
        shoppingCart.displayItems();
    }
    /**
     * Adds a product to the user's shopping cart based on the provided product ID.
     */
    public void addToShoppingCart(int id, ProductCatalog productCatalog) {
        shoppingCart.addItem(id, productCatalog);
    }
    /**
     * Deletes a product from the user's shopping cart based on the provided product ID.
     */
    public void deleteFromShoppingCart(int id) {
        shoppingCart.deleteItem(id);
    }
    /**
     * Completes the user's current order, finalizes the contents of the shopping cart, creates an order object,
     * adds it to the order history, and displays the order details.
     */
    public void completeOrder() {
        Order order = shoppingCart.completeOrder();
        history.addToHistory(order);
        if (order != null) {
            order.displayOrder();
        }
    }

    /**
     * Displays the order history for the user, showing details of past orders.
     */
    public void showHistory()
    {
        history.afficheHistory();
    }
    /**
     * Allows the user to add a review to a product based on the provided product ID.
     **/
    public void reviewProduct(int id, ProductCatalog catalog) {
        for (List<Product> productList : catalog.getCatalog().values()) {
            for (Product product : productList) {
                if (product.getId() == id) {
                    product.addReview(this);
                    product.displayInfo();
                    return;
                }
            }
        }
        System.out.println("Product not found.");
    }
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

}
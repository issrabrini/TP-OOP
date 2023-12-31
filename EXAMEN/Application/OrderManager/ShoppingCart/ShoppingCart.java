package OrderManager.ShoppingCart;

import Account.User;
import OrderManager.Payment.CashPayment;
import OrderManager.Payment.CreditCardPayment;
import OrderManager.Payment.PaymentMethod;
import OrderManager.Shipping.ExpressShipping;
import OrderManager.Shipping.ShippingManager;
import OrderManager.Shipping.ShippingMethod;
import OrderManager.Shipping.StandardShipping;
import Product.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class ShoppingCart {
    private List<Product> items;
    private double total;
    ProductCatalog productCatalog = new ProductCatalog();
    private double packageWeight;

    // Constructor
    public ShoppingCart() {
        items = new ArrayList<>();
        total = 0.0;
        packageWeight = 0.0;
    }
    // Add item to the shopping cart if it exists in the catalog using the product ID
    public void addItem(int id, ProductCatalog productCatalog) {
        for (List<Product> productList : productCatalog.getCatalog().values()) {
            for (Product product : productList) {
                if (product.getId() == id) {
                    if(product.getQuantity()==0) {
                        System.out.println("Product.Product is out of stock.");
                        return;
                    }
                    else {
                        items.add(product);
                        total += product.getPrice();
                        packageWeight += product.getWeight();
                        System.out.println("Product.Product added to the shopping cart.");
                        return;
                    }
                }
            }
        }
    }
    // Display the items in the shopping cart
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("The shopping cart is empty.");
        } else {
            System.out.println("Items in the shopping cart:");
            for (Product product : items) {
                product.displayInfo();
            }
        }
    }
    // Delete item from the shopping cart using the product ID
    public void deleteItem(int productId) {
        for (Product product : items) {
            if (product.getId() == productId) {
                total -= product.getPrice();
                packageWeight -= product.getWeight();
                items.remove(product);
                System.out.println("Product.Product removed from the shopping cart.");
                return;
            }
        }
        System.out.println("Product.Product not found in the shopping cart.");
    }
    // Complete the order by choosing the payment method
    public Order completeOrder() {
        Order order = null;
        if (items.isEmpty()) {
            System.out.println("Cannot complete the order. The shopping cart is empty.");

        }
        else {
            while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("choose payment method: ");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            System.out.println("3.exit");
            int choice = scanner.nextInt();
            PaymentMethod paymentMethod;

            switch (choice) {
                case 1:
                    paymentMethod = new CashPayment();
                    order = shipping(paymentMethod);

                    break;
                case 2:
                    System.out.println("Enter Credit Card Information:");
                    System.out.print("Cardholder Name: ");
                    String cardholderName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Credit Card Number: ");
                    String creditCardNumber = scanner.nextLine();
                    System.out.print("Expiration Date (YYYY-MM): ");
                    String expirationDateStr = scanner.nextLine();
                    LocalDate expirationDate = LocalDate.parse(expirationDateStr + "-01");
                    System.out.print("CVV: ");
                    int cvv = scanner.nextInt();
                    paymentMethod = new CreditCardPayment(cardholderName, creditCardNumber, expirationDate, cvv);
                    order = shipping(paymentMethod);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                }
            }
        }return order;
    }
    //choose shipping method and calculate shipping cost and total cost
    public Order shipping(PaymentMethod paymentMethod) {
        Scanner scanner = new Scanner(System.in);
        Order order = null;
        if (total > 100) {
            System.out.println("shipping will be free.");
        }
        else{
            while(true){
                System.out.println("choose shipping method: ");
                System.out.println("1. Standard Shipping");
                System.out.println("2. Express Shipping");
                System.out.println("3.exit");
                int choice2 = scanner.nextInt();
                ShippingMethod shippingMethod;
                if (choice2 == 1) {
                    shippingMethod = new StandardShipping();
                    ShippingManager shipping = new ShippingManager(shippingMethod, packageWeight);
                    System.out.println("Shipping cost: $" + shipping.calculateShippingCost());
                    System.out.println("Total cost: $" + (total + shipping.calculateShippingCost()));
                    order = finalizeOrder(paymentMethod);
                    break;
                }
                else if (choice2 == 2) {
                    shippingMethod = new ExpressShipping();
                    ShippingManager shipping = new ShippingManager(shippingMethod, packageWeight);
                    System.out.println("Shipping cost: $" + shipping.calculateShippingCost());
                    System.out.println("Total cost: $" + (total + shipping.calculateShippingCost()));
                    order = finalizeOrder(paymentMethod);
                    break;
                }
                else if(choice2==3)
                    System.exit(0);
                else {
                    System.out.println("Invalid choice.");
                    order = null;
                }
            }
        }
        return order;
    }
    // Finalize the order by choosing to complete or cancel the order if the order is completed the order will be added to the history and the quantity of the product will be decreased by 1
    public Order finalizeOrder(PaymentMethod paymentMethod ) {
        Scanner scanner = new Scanner(System.in);
        Order order = null;
        while (true) {
            System.out.println("do you want to finalize your order? ");
            System.out.println("1. yes");
            System.out.println("2. no");
            int choice3 = scanner.nextInt();
            switch (choice3) {
                case 1:
                    order = new Order(new ArrayList<>(items), total, paymentMethod, packageWeight);
                    for (Product product : items) {
                        if (product instanceof Clothing) {
                            Clothing clothing = (Clothing) product;
                            clothing.setSize(clothing.getQuantity() - 1);
                        } else if (product instanceof Makeup) {
                            Makeup makeup = (Makeup) product;
                            makeup.setQuantity(makeup.getQuantity() - 1);
                        } else if (product instanceof SkinCare) {
                            SkinCare skinCare = (SkinCare) product;
                            skinCare.setQuantity(skinCare.getQuantity() - 1);
                        }
                    }
                    items.clear();
                    total = 0.0;
                    System.out.println("OrderManger.ShoppingCart.Order completed successfully.");
                    break;
                case 2:
                    System.out.println("OrderManger.ShoppingCart.Order canceled.");
                    order = null;
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
            return order;
        }
    }
    // Shopping cart menu
    public  void shoppingCartMenu(Scanner scanner, User user, ProductCatalog catalog) {
        while (true) {
            System.out.println("Shopping Cart Menu:");
            System.out.println("1. Search products");
            System.out.println("2. Filter products");
            System.out.println("3. Add product to cart");
            System.out.println("4. View cart");
            System.out.println("5. Delete product from cart");
            System.out.println("6. Review a product");
            System.out.println("7. Complete order");
            System.out.println("8. History");
            System.out.println("9. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the product: ");
                    String keyword = scanner.next();
                    catalog.searchProducts(keyword);
                    break;
                case 2:
                    System.out.println("\nFilter Products:");
                    System.out.println("1. By Category");
                    System.out.println("2. By Price Range");
                    System.out.print("Enter your choice: ");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (filterChoice) {
                        case 1:
                            System.out.println("Enter the category to filter: ");
                            String category = scanner.nextLine();
                            catalog.filterProductsByCategory(category);
                            break;
                        case 2:
                            System.out.print("Enter the minimum price: ");
                            double minPrice = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Enter the maximum price: ");
                            double maxPrice = scanner.nextDouble();
                            scanner.nextLine();
                            catalog.filterProductsByPriceRange(minPrice, maxPrice);
                            break;
                        default:
                            System.out.println("Invalid choice. Returning to the main menu.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the ID of the product you want to add to your cart: ");
                    int productId = scanner.nextInt();
                    user.addToShoppingCart(productId,catalog);
                    break;
                case 4:
                    user.displayShoppingCart();
                    break;
                case 5:
                    System.out.println("Enter the ID of the product you want to remove from your cart: ");
                    int Id = scanner.nextInt();
                    user.deleteFromShoppingCart(Id);
                    break;
                case 6:
                    System.out.println("Enter the ID of the product you want to review: ");
                    int id = scanner.nextInt();
                    user.reviewProduct(id,catalog);
                    break;
                case 7:
                    user.completeOrder();
                    break;
                case 8:
                    System.out.println("OrderManger.ShoppingCart.History");
                    user.showHistory();
                    break;
                case 9:
                    System.out.println("Logging out. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


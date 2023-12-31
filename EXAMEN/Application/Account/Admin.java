package Account;

import Product.ProductCatalog;
import Product.*;

import java.util.Scanner;
/**
 * The `Account.Admin` class represents an administrator in the e-commerce application. It extends the `Account.Account` class,
 * inheriting basic account functionalities. The class provides specific functionalities for administrators,
 * such as adding, updating, and deleting products in the product catalog.
 *
 * The admin can perform various actions through the admin menu, including adding a new product, updating an
 * existing product, deleting a product, and viewing products in the catalog.
 */

public class Admin extends Account
{
    public Admin()
    {
        super();

    }
    /**
     * Collects product information from the administrator through user input.
     * The user is prompted to enter details such as product ID, category, name, price, brand, quantity, and weight.
     * Based on the category, it creates an instance of the appropriate product type (Product.Makeup, Product.SkinCare, or Product.Clothing).
     *
     * return A new `Product` object based on the entered information.
     */

    public Product collectProductInfo()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product details: ");
        System.out.println("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product category: ");
        String category = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter product brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter product weight: ");
        double weight = scanner.nextDouble();

        //Creating a New Product: The Product class is an abstract class, which means it cannot be instantiated directly. Instead, it serves as a base class for other classes like Product.Makeup, Product.SkinCare, and Product.Clothing.
        Product newProduct;
        if (category.equalsIgnoreCase("Product.Makeup"))
        {
            scanner.nextLine();

            newProduct = new Makeup(name, price, brand, quantity,id,weight);
        }
        else if (category.equalsIgnoreCase("Product.SkinCare"))
        {
            scanner.nextLine();
            System.out.print("Enter product purpose: ");
            String purpose = scanner.nextLine();
            newProduct = new SkinCare(name, price, brand, purpose,quantity, id,weight );
        }
        else if (category.equalsIgnoreCase("Product.Clothing"))
        {
            scanner.nextLine();
            System.out.print("Enter product size: ");
            int size = scanner.nextInt();
            newProduct = new Clothing(name, price, brand,size,quantity, id,weight);
        }
        else
        {
            System.out.println("Invalid category.");
            return null;
        }
        return newProduct;
    }
    //Adding, Updating, and Deleting Products:
    /**
     * Adds a new product to the product catalog. Calls the `collectProductInfo` method to gather product details
     * from the administrator.
     */
    public void addProductToCatalog(ProductCatalog productCatalog)
    {
        System.out.println("Enter new product details: ");
        Product newProduct = collectProductInfo();
        productCatalog.addProduct(newProduct.getClass().getSimpleName(), newProduct);
    }

    /**
     * Updates an existing product in the product catalog. Calls the `collectProductInfo` method to gather updated
     * product details from the administrator.
     */
    public void updateProductInCatalog(int id, ProductCatalog productCatalog)
    {
        System.out.println("Enter updated product details: ");
        Product updatedProduct = collectProductInfo();
        productCatalog.updateProduct(updatedProduct.getClass().getSimpleName(), id, updatedProduct);
    }
    /**
     * Deletes a product from the product catalog. The administrator is prompted to enter the product category and ID.
     */
    public void deleteProduct(  ProductCatalog productCatalog)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product category: ");
        String category = scanner.nextLine();
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        productCatalog.deleteProduct(category, productId);
    }
    //Viewing Products:
    /**
     * Displays products in the product catalog based on their categories.
     */
    public void viewProducts(ProductCatalog productCatalog)
    {
        for(String category : productCatalog.getCategories())
        {
            System.out.println("Category: " + category);
            productCatalog.displayProducts(category);
        }
    }
    //Account.Admin Menu:
    /**
     * Displays the admin menu, allowing the administrator to choose from various options such as adding a product,
     * updating a product, deleting a product, viewing products, or logging out.
     */
    public void adminMenu(Scanner scanner, Admin admin, ProductCatalog catalog) {
        while (true) {
            System.out.println("Account.Admin Menu:");
            System.out.println("1. Add product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("4. View products");
            System.out.println("5. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    admin.addProductToCatalog(catalog);
                    break;
                case 2:
                    System.out.println("Enter the ID of the product you want to update:");
                    int id = scanner.nextInt();
                    admin.updateProductInCatalog(id,catalog);
                    break;
                case 3:
                    admin.deleteProduct(catalog);
                    break;
                case 4:
                    admin.viewProducts(catalog);
                    break;
                case 5:
                    System.out.println("Logging out. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}






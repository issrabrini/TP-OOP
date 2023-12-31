package Main;
import Account.*;
import Product.*;
import OrderManager.Payment.*;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create a scanner object to read user input
        //create a user account
        //create an admin account
        //create a product catalog
        //create products
        //add products to catalog
        Scanner scanner = new Scanner(System.in);
        Account userAccount = new User();
        Account adminAccount = new Admin();
        ProductCatalog catalog = new ProductCatalog();
        Product mascara= new Makeup("mascara",12,"maybelline",20,111,0.5);
        Product eyeliner= new Makeup("eyeliner",12,"maybelline",0,112,2.1);
        Product lipstick= new Makeup("lipstick",12,"maybelline",20,113,2.1);
        Product cleanser= new SkinCare("cleanser",12,"maybelline","clean",20,114,0.5);
        Product moisturizer= new SkinCare("moisturizer",12,"garnier","moisturize",20,115,0.5);
        Product toner= new SkinCare("toner",12,"garnier","tone",20,116,0.5);
        Product shirt= new Clothing("shirt",12,"zara",10,20,117,0.5);
        Product pants= new Clothing("pants",12,"zara",10,20,118,0.5);
        Product dress= new Clothing("dress",12,"zara",10,20,119,0.5);
        catalog.addProduct("Product.Makeup",mascara);
        catalog.addProduct("Product.Makeup",eyeliner);
        catalog.addProduct("Product.Makeup",lipstick);
        catalog.addProduct("Product.SkinCare",cleanser);
        catalog.addProduct("Product.SkinCare",moisturizer);
        catalog.addProduct("Product.SkinCare",toner);
        catalog.addProduct("Product.Clothing",shirt);
        catalog.addProduct("Product.Clothing",pants);
        catalog.addProduct("Product.Clothing",dress);
        //creating the menu for the application
        while (true) {
            System.out.println("Welcome to the Commerce Application!");
            System.out.println("1. Register as a user");
            System.out.println("2. Login as a user");
            System.out.println("3. Register as an admin");
            System.out.println("4. Login as an admin");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                   userAccount.registerUser();
                    break;
                case 2:
                    userLogin(scanner, userAccount,catalog);
                    break;
                case 3:
                    adminAccount.registerUser();
                    break;
                case 4:
                    adminLogin(scanner, adminAccount,catalog);
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    //method to login as a user
    private static void userLogin(Scanner scanner, Account userAccount, ProductCatalog catalog) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (userAccount.authenticateUser(username, password)) {
            System.out.println("Login successful!");
            User user = (User) userAccount;
            user.getShoppingCart().shoppingCartMenu(scanner, user,catalog);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
    //method to login as an admin
    private static void adminLogin(Scanner scanner, Account adminAccount,ProductCatalog catalog) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (adminAccount.authenticateUser(username, password)) {
            System.out.println("Account.Admin login successful!");
            Admin admin = (Admin) adminAccount;
            admin.adminMenu(scanner, admin,catalog);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}

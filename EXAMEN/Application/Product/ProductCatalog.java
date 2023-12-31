package Product;

import Product.Clothing;
import Product.Product;
import Product.SkinCare;

import java.util.*;
/**
 * The Product.ProductCatalog class represents a catalog of products organized by categories.
 * It allows the addition, updating, and deletion of products, as well as displaying and searching for products.
 */
public class ProductCatalog
{
    // Instance variable to store the catalog using categories as keys and lists of products as values
    private Map<String, List<Product>> catalog;
    // Constructor
    public ProductCatalog()
    {
        catalog = new HashMap<>();
    }
    // Getter and setter methods
    public Map<String, List<Product>> getCatalog()
    {
        return catalog;
    }
    public String[] getCategories()
    {
        return catalog.keySet().toArray(new String[0]);
    }
    // addProduct() method to add a product to the catalog if it doesn't exist already
    public void addProduct(String category, Product product)
    {
        catalog.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        System.out.println("Product.Product added to category " + category + ".");
    }
    // updateProduct() method to update the details of a product in the catalog using the category and product ID
    public void updateProduct(String category, int productId, Product updatedProduct)
    {
        if (catalog.containsKey(category))
        {
            List<Product> productList = catalog.get(category);
            for (Product product : productList)
            {
                if (product.getId() == productId)
                {
                    // Update the common product details
                    product.setName(updatedProduct.getName());
                    product.setPrice(updatedProduct.getPrice());
                    product.setBrand(updatedProduct.getBrand());
                    product.setQuantity(updatedProduct.getQuantity());
                    product.setWeight(updatedProduct.getWeight());

                    // Update additional details based on the category type
                    if (updatedProduct instanceof Clothing && product instanceof Clothing) {
                        ((Clothing) product).setSize(((Clothing) updatedProduct).getSize());
                    }
                    else if (updatedProduct instanceof SkinCare && product instanceof SkinCare) {
                        ((SkinCare) product).setPurpose(((SkinCare) updatedProduct).getPurpose());
                    }
                    System.out.println("Product.Product updated successfully.");
                    return;
                }
            }
            System.out.println("Product.Product not found in category " + category + ".");
        }
        else{
            System.out.println("Category " + category + " not found.");
        }
    }
    // deleteProduct() method to delete a product from the catalog using the category and product ID
    public void deleteProduct(String category, int productId){
        if (catalog.containsKey(category)){
            List<Product> productList = catalog.get(category);
            productList.removeIf(product -> product.getId() == productId);
            System.out.println("Product.Product deleted successfully.");
        }
        else {
            System.out.println("Category " + category + " not found.");
        }
    }
    // displayProducts() method to display all the products in a category
    public void displayProducts(String category) {
        if (catalog.containsKey(category)) {
            List<Product> productList = catalog.get(category);
            for (Product product : productList) {
                product.displayInfo();
            }
        }
        else {
            System.out.println("Category " + category + " not found.");
        }
    }
    // displayAllProducts() method to display all the products in the catalog
    public void displayAllProducts()
    {
        for (String category : catalog.keySet())
        {
            displayProducts(category);
        }
    }
    // searchProducts() method to search for a product using a keyword
    public void searchProducts(String keyword) {
        for (List<Product> productList : catalog.values()) {
            for (Product product : productList) {
                if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                    product.displayInfo();
                }
                else {
                    System.out.println("No products found.");
                }
            }
        }
    }
    // filterProductsByCategory() method to filter products by category
    public void filterProductsByCategory(String category) {

        displayProducts(category);
    }
    // filterProductsByPriceRange() method to filter products by price range
    public void filterProductsByPriceRange(double minPrice, double maxPrice)
    {
        for (List<Product> productList : catalog.values()) {
            for (Product product : productList) {
                if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                    product.displayInfo();
                }
            }
        }
    }
    // getProductById() method to get a product using the product ID
    public Product getProductById(int id)
    {
        for (List<Product> productList : catalog.values()) {
            for (Product product : productList) {
                if (product.getId() == id) {
                    return product;
                }
            }
        }
        return null;
    }
}





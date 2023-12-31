Java E-Commerce Console Application is an e-commerce platform designed to simulate a real-world e-commerce experience. The application offers features such as user authentication, product management, shopping cart functionality, order processing, inventory management, dynamic product search and filtering, and payment processing.

The ShoppingCart class serves as the foundation for managing products in a user's cart. Users can add, update, and remove items from their cart, and the class also includes methods for displaying the cart and calculating the total cost of all products within it.

To facilitate a smooth transition from cart to order completion, the ShoppingCart class features a createOrder() method. This method generates an Order object, which includes the details of all products within the cart. Once the Order is created, the cart is cleared to ensure that it starts fresh for the next user interaction.

Inventory Management plays a crucial role in ensuring that customers have access to the products they want. This application provides an abstract Product class and an Order class to maintain records of user transactions.

The application also offers dynamic product search and filtering capabilities, enabling users to discover products based on their search criteria.

To ensure a seamless checkout experience, the application incorporates a basic payment transaction system.

The overall goal of this application is to provide a comprehensive simulation of real-world e-commerce functionalities. Users can interact with the application to add and remove products from their cart, create orders, and search for products based on specific criteria. Additionally, administrators can manage products, user accounts, and inventory levels to maintain a functional and efficient e-commerce platform.

Features:
Admin 's Functionalities:

1. Inventory Management:
   - Add, modify, or delete products within the inventory.
   - Update product details such as name, price, quantity, and description.


Customer Functionalities:

1. Browsing and Shopping:
   - Explore available products and their specifications.
   - Add desired items to the shopping cart.

2. Product Ratings:
   - Share your authentic feedback on purchased products to assist other customers in their decision-making.

3. Order Placement:
   - Progress to the checkout stage to finalize and confirm orders.

4. Order History:
   -  check previous orders.

5. Payment Process:
   - Choose the preferred payment method, whether it be cash or credit card.

6. Shipping Preferences:
   - Select between express and regular shipping options.

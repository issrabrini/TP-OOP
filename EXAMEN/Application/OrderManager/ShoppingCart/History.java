package OrderManager.ShoppingCart;

import java.util.ArrayList;

public class History {
    private ArrayList<Order> history;
    public History()
    {
        history = new ArrayList<Order>();
    }
    //This method adds a new order to the ArrayList. It uses the ArrayList's add() method, which adds the specified element to the end of the list.
    public void addToHistory(Order o)
    {
        history.add(o);
    }
    //This method displays all the orders in the ArrayList. It uses a for-each loop to iterate through each order in the ArrayList and calls the displayOrder() method to print the details of each order.
    public void afficheHistory()
    {
        for (Order o: history)
        {
         o.displayOrder();
        }
    }
}

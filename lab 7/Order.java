import java.util.ArrayList;
import java.util.Date;

public class Order {
    private Date date;
    private String invoiceID;
    private Customer customer;
    private ArrayList<OrderItem> cart;

    /**
     * Constructs an Order with the specified Customer.
     * 
     * @param customer the Customer associated with this Order
     */
    public Order(Customer customer) {
        this.customer = customer;
        this.date = setDate();
        this.invoiceID = createInvoiceID();
        this.cart = new ArrayList<>();
    }

    /**
     * Copy constructor for creating a deep copy of an Order.
     * 
     * @param other the Order to copy
     */
    public Order(Order other) {
        this.date = new Date(other.date.getTime());
        this.invoiceID = other.invoiceID;
        this.customer = new Customer();
        this.cart = new ArrayList<>();
        for (OrderItem item : other.cart) {
            this.cart.add(new OrderItem(item));
        }
    }

    /**
     * Adds a quantity of one single item to the cart. If the item already exists in the cart, 
     * simply increase the quantity.
     * 
     * @param menuItem the MenuItem to add
     */
    public void addItem(MenuItem menuItem) {
        addItem(menuItem, 1);
    }

    /**
     * Adds a specified quantity of an item to the cart. If the item already exists in the cart, 
     * simply increase the quantity.
     * 
     * @param menuItem the MenuItem to add
     * @param quantity the quantity to add
     */
    public void addItem(MenuItem menuItem, int quantity) {
        for (OrderItem item : cart) {
            if (item.getMenuItem().equals(menuItem)) {
                item.updateQuantity(quantity);
                return;
            }
        }
        cart.add(new OrderItem(menuItem, quantity));
    }

    /**
     * Removes and returns the specified item from the order.
     * 
     * @param menuItem the MenuItem to remove
     * @return the removed OrderItem, or null if not found
     */
    public OrderItem removeItem(MenuItem menuItem) {
        for (OrderItem item : cart) {
            if (item.getMenuItem().equals(menuItem)) {
                cart.remove(item);
                return item;
            }
        }
        return null;
    }

    /**
     * Calculates the total price of the order by summing the price * quantity of each item in the cart.
     * 
     * @return the total price of the order
     */
    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : cart) {
            total += item.getMenuItem().getPrice() * item.getQuantity();
        }
        return total;
    }

    /**
     * Calculates the tax amount of the order based on the given total.
     * 
     * @param total the total price of the order
     * @return the tax amount
     */
    public double calculateTax(double total) {
        // Assuming a fixed tax rate of 6%
        return total * 0.06;
    }

    /**
     * Writes the order to a file, creating a receipt.
     * The file name should be the invoiceID plus .txt.
     */
    public void writeToFile() {
        // Implementation of writing to file
    }

    // Private helper method to set the current date
    private Date setDate() {
        return new Date();
    }

    // Private helper method to create the invoice ID
    private String createInvoiceID() {
        // Implementation of creating the invoice ID
        return ""; // Placeholder
    }

    /**
     * Returns a nicely formatted string showing the order details.
     * Includes tax and the final order total.
     */
    @Override
    public String toString() {
        // Implementation of formatting the order details
        return ""; // Placeholder
    }

    /**
     * Performs a deep comparison on two orders.
     * 
     * @param otherOrder the other Order to compare
     * @return true if the Orders are equal, false otherwise
     */
    public boolean equals(Order otherOrder) {
        // Implementation of deep comparison
        return false; // Placeholder
    }

    /**
     * Specifies ordering of Order objects based on the ascending Date of the order.
     * 
     * @param otherOrder the other Order to compare
     * @return a negative integer, zero, or a positive integer as this order is before, equal to, or after the specified order
     */
    public int compareTo(Order otherOrder) {
        // Implementation of ordering based on Date
        return 0; // Placeholder
    }

    /**
     * Returns the Date of the order.
     * 
     * @return the Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Returns the InvoiceID of the order.
     * 
     * @return the InvoiceID
     */
    public String getInvoiceID() {
        return invoiceID;
    }

    /**
     * Returns the Customer of the order.
     * 
     * @return the Customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Returns the Cart (ArrayList of OrderItems) of the order.
     * 
     * @return the Cart
     */
    public ArrayList<OrderItem> getCart() {
        return cart;
    }
}

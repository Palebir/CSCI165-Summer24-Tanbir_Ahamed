import java.util.Objects;

public class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    /**
     * Constructs an OrderItem with the specified MenuItem and quantity.
     * 
     * @param menuItem the MenuItem associated with this OrderItem
     * @param quantity the quantity of MenuItem in this OrderItem
     */
    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    /**
     * Copy constructor for creating a deep copy of an OrderItem.
     * 
     * @param other the OrderItem to copy
     */
    public OrderItem(OrderItem other) {
        this.menuItem = new MenuItem();
        this.quantity = other.quantity;
    }

    /**
     * Increases or decreases the quantity of MenuItem by the given value.
     * 
     * @param amount the amount to increase or decrease the quantity
     */
    public void updateQuantity(int amount) {
        if (amount > 0) {
            quantity += amount;
        } else if (amount < 0 && Math.abs(amount) <= quantity) {
            quantity += amount;
        }
    }

    /**
     * Returns the MenuItem associated with this OrderItem.
     * 
     * @return the MenuItem
     */
    public MenuItem getMenuItem() {
        return menuItem;
    }

    /**
     * Returns the quantity of MenuItem in this OrderItem.
     * 
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns a nicely formatted String of this OrderItem's state.
     */
    @Override
    public String toString() {
        return quantity + " x " + menuItem.toString();
    }

    /**
     * Performs a deep comparison on OrderItems.
     * 
     * @param other the other OrderItem to compare
     * @return true if the OrderItems are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OrderItem other = (OrderItem) obj;
        return quantity == other.quantity &&
                Objects.equals(menuItem, other.menuItem);
    }
}



public class OrderItemTests {
    OrderItem orderItemOne;
    MenuItem menuItemOne, menuItemTwo;
    String msg;

    @BeforeEach
    public void setup() {
        orderItemOne = null;
        menuItemOne = null;
        menuItemTwo = null;
    }

    @Test
    public void testMenuItemPrivacyProtection() {
        // Create a menu item and add it to an order item
        menuItemOne = new MenuItem("Burger", 5.99, 700);       // name, price, calories
        orderItemOne = new OrderItem(menuItemOne, 2);          // item, quantity

        // Ensure that getMenuItem() returns a copy of the MenuItem
        MenuItem menuItemOneCopy = orderItemOne.getMenuItem(); // get the menu item
        msg = "The states are not the same. They should be.";
        assertTrue(menuItemOneCopy.equals(menuItemOne), msg);  // state check should be equal
        msg = "The identities are the same. They should not be.";
        assertFalse(menuItemOneCopy == menuItemOne, msg);      // identity check should be false

        // Test two
        menuItemOne = new MenuItem("Hakarl", 11.99, 300);      // name, price, calories
        orderItemOne = new OrderItem(menuItemOne, 7);          // item, quantity

        // Ensure that getMenuItem() returns a copy of the MenuItem
        menuItemOneCopy = orderItemOne.getMenuItem();          // get the menu item
        msg = "The states are not the same. They should be.";
        assertTrue(menuItemOneCopy.equals(menuItemOne), msg);  // state check should be equal
        msg = "The identities are the same. They should not be.";
        assertFalse(menuItemOneCopy == menuItemOne, msg);      // identity check should be false
    }

    @Test
    public void testConstructorPrivacyProtection() {
        // Test constructor privacy protection
        menuItemOne = new MenuItem("Tacos", 9.99, 623);        // create a menu item
        orderItemOne = new OrderItem(menuItemOne, 3);          // create an order item
        menuItemOne.setName("Pizza");                          // change the name of the menu item
        String name = orderItemOne.getMenuItem().getName();    // get the name of the menu item
        msg = "The name was incorrectly modified. It should be the same as the original name.";
        assertFalse(name.equals("Pizza"), msg);                // the name should not have changed
        
        // Test constructor privacy protection
        menuItemOne = new MenuItem("Tacos", 9.99, 623);        // create a menu item
        orderItemOne = new OrderItem(menuItemOne, 3);          // create an order item
        menuItemOne.setPrice(3);                               // change the price of the menu item
        double price = orderItemOne.getMenuItem().getPrice();  // get the price of the menu item
        msg = "The price was incorrectly modified. It should be the same as the original price.";
        assertFalse(price == 3, msg);                          // the price should not have changed
    }

    @Test
    public void testUpdateQuantity() {
        // Create a menu item and add it to an order item
        menuItemOne = new MenuItem("Burger", 5.99, 700);       // name, price, calories
        orderItemOne = new OrderItem(menuItemOne, 2);          // item, quantity

        // Update the quantity of the order item with a positive number
        orderItemOne.updateQuantity(3);                        // increase the quantity by 3
        msg = "The quantity was not updated correctly. It should be 5.";
        assertTrue(orderItemOne.getQuantity() == 5, msg);      // was the quantity updated correctly?

        // Test two: Allow negative numbers whose absolute value is less than or equal to the current quantity
        menuItemOne = new MenuItem("Hakarl", 11.99, 300);      // name, price, calories
        orderItemOne = new OrderItem(menuItemOne, 7);          // item, quantity
        orderItemOne.updateQuantity(-5);                       // decrease the quantity by 5
        msg = "The quantity was not updated correctly. It should be 2.";
        assertTrue(orderItemOne.getQuantity() == 2, msg);      // was the quantity updated correctly?

        // Test three: Prohibit negative numbers whose absolute value is greater than the current quantity
        menuItemOne = new MenuItem("Hakarl", 11.99, 300);      // name, price, calories
        orderItemOne = new OrderItem(menuItemOne, 7);          // item, quantity
        orderItemOne.updateQuantity(-10);                      // decrease the quantity by 10
        msg = "The quantity was updated when it should have remained unmodified. It should be 7.";
        assertTrue(orderItemOne.getQuantity() == 7, msg);      // was the quantity updated correctly?
    }

    @Test
    public void testEqualsMethod() {
        // Create a menu item and add it to an order item
        menuItemOne = new MenuItem("Burger", 5.99, 700);       // name, price, calories
        orderItemOne = new OrderItem(menuItemOne, 2);          // item, quantity

        // Create a second order item with the same menu item and quantity
        OrderItem itemTwo = new OrderItem(menuItemOne, 2);     // item, quantity
        msg = "The order items are not equal. They should be.";
        assertTrue(orderItemOne.equals(itemTwo), msg);         // should be equal

        // Update the quantity of the second order item. They should no longer be equal
        itemTwo.updateQuantity(3);                             // increase the quantity by 3
        msg = "The order items are equal. They should not be.";
        assertFalse(orderItemOne.equals(itemTwo), msg);        // should not be equal

        // Update the quantity of the first order item. They should now be equal
        orderItemOne.updateQuantity(3);                        // increase the quantity by 3
        msg = "The order items are not equal. They should be.";
        assertTrue(orderItemOne.equals(itemTwo), msg);         // should be equal

        // Create a third order item with a different menu item and quantity
        menuItemTwo = new MenuItem("Hakarl", 11.99, 300);      // name, price, calories
        OrderItem itemThree = new OrderItem(menuItemTwo, 7);   // item, quantity
        msg = "The order items are equal. They should not be.";
        assertFalse(orderItemOne.equals(itemThree), msg);      // should not be equal
    }

	private void assertFalse(boolean equals, String msg2) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'assertFalse'");
	}

	private void assertTrue(boolean equals, String msg2) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
	}
}

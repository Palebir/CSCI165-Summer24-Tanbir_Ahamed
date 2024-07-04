import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void testSetName() {
        customer.setName("John Doe");
        assertEquals("John Doe", customer.getName());

        customer.setName(null);
        assertEquals("John Doe", customer.getName(), "Name should not change when setting to null");
    }

    @Test
    public void testSetEmail() {
        customer.setEmail("example@example.com");
        assertEquals("example@example.com", customer.getEmail());

        customer.setEmail("invalidemail.com");
        assertEquals("example@example.com", customer.getEmail(), "Email should not change when setting to invalid email");

        customer.setEmail("prefix.toolongxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx@example.com");
        assertEquals("example@example.com", customer.getEmail(), "Email should not change when prefix is too long");

        customer.setEmail(".dotstart@example.com");
        assertEquals("example@example.com", customer.getEmail(), "Email should not change when prefix starts with a dot");

        customer.setEmail("dotend.@example.com");
        assertEquals("example@example.com", customer.getEmail(), "Email should not change when prefix ends with a dot");

        customer.setEmail("double..dot@example.com");
        assertEquals("example@example.com", customer.getEmail(), "Email should not change when prefix contains consecutive dots");

        customer.setEmail("valid.email@example.com");
        assertEquals("valid.email@example.com", customer.getEmail(), "Email should change to valid email");
    }

    @Test
    public void testSetPhone() {
        customer.setPhone("1234567890");
        assertEquals("1234567890", customer.getPhone());

        customer.setPhone("12345");
        assertEquals("1234567890", customer.getPhone(), "Phone should not change when setting to invalid phone number");

        customer.setPhone("abcdefghij");
        assertEquals("1234567890", customer.getPhone(), "Phone should not change when setting to non-numeric phone number");

        customer.setPhone("0987654321");
        assertEquals("0987654321", customer.getPhone(), "Phone should change to valid phone number");

        customer.setPhone(null);
        assertEquals("0987654321", customer.getPhone(), "Phone should not change when setting to null");
    }

    @Test
    public void testOverloadedConstructor() {
        Customer overloadedCustomer = new Customer("Alice", "alice@example.com", "0123456789");
        assertEquals("Alice", overloadedCustomer.getName());
        assertEquals("alice@example.com", overloadedCustomer.getEmail());
        assertEquals("0123456789", overloadedCustomer.getPhone());
    }

    @Test
    public void testToString() {
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        customer.setPhone("1234567890");

        String expected = "John Doe\njohn@example.com\n1234567890";
        assertEquals(expected, customer.toString());
    }

    @Test
    public void testEquals() {
        Customer customer1 = new Customer("John Doe", "john@example.com", "1234567890");
        Customer customer2 = new Customer("John Doe", "john@example.com", "1234567890");
        Customer customer3 = new Customer("Jane Doe", "jane@example.com", "0987654321");

        assertTrue(customer1.equals(customer2));
        assertFalse(customer1.equals(customer3));
        assertFalse(customer1.equals(null));
    }
}

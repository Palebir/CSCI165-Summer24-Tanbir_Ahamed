public class CustomerDriver {
    public static void main(String[] args) {
        // Test Customer class with various constructors and methods

        // Creating Date instances for testing
        Date joinDate1 = new Date(2022, 6, 1);
        Date joinDate2 = new Date(2023, 3, 10);

        // Creating Person instance for testing
        Person person1 = new Person("Alice", "Brown");

        // Test no-argument constructor
        Customer cust1 = new Customer();
        System.out.println("Testing no-argument constructor:");
        System.out.println(cust1);

        // Test overloaded constructor with all fields
        Customer cust2 = new Customer("John", "Smith", "123-456-7890", new Date(1990, 5, 15), joinDate1, "C001");
        System.out.println("\\nTesting overloaded constructor with all fields:");
        System.out.println(cust2);

        // Test overloaded constructor with Person, dateJoined, and custID
        Customer cust3 = new Customer(person1, joinDate2, "C002");
        System.out.println("\\nTesting overloaded constructor with Person, dateJoined, and custID:");
        System.out.println(cust3);

        // Test copy constructor
        Customer cust4 = new Customer(cust2);
        System.out.println("\\nTesting copy constructor:");
        System.out.println(cust4);

        // Test equals method
        System.out.println("\\nTesting equals method:");
        System.out.println("cust2 equals cust4: " + cust2.equals(cust4));
        System.out.println("cust2 equals cust3: " + cust2.equals(cust3));
    }
}

public class AccountDriver {
    public static void main(String[] args) {
        // Create instances of Employee and Customer
        Employee manager = new Employee("John", "Doe");
        Customer customer = new Customer("Jane", "Doe", "555-1234", new Date(1985, 6, 15), new Date(2022, 1, 5), "C123");

        // Test SavingsAccount
        SavingsAccount savings = new SavingsAccount(customer, manager, new Date(2022, 1, 5), 3.5);
        System.out.println("Testing SavingsAccount:");
        System.out.println(savings);
        savings.addInterest();
        System.out.println("After adding interest:");
        System.out.println(savings);

        // Test CheckingAccount
        CheckingAccount checking = new CheckingAccount(customer, manager, new Date(2022, 1, 5), 500.0);
        System.out.println("\\nTesting CheckingAccount:");
        System.out.println(checking);
        checking.withdraw(600);
        System.out.println("After attempting overdraft withdrawal:");
        System.out.println(checking);

        // Test equals method
        CheckingAccount checking2 = new CheckingAccount(checking);
        System.out.println("\\nTesting equals method:");
        System.out.println("checking equals checking2: " + checking.equals(checking2));
    }
}

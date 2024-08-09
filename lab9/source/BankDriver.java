public class BankDriver {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create instances of Employee and Customer
        Employee manager = new Employee("John", "Doe");
        Customer customer1 = new Customer("Jane", "Doe", "555-1234", new Date(1985, 6, 15), new Date(2022, 1, 5), "C123");
        Customer customer2 = new Customer("Jack", "Smith", "555-5678", new Date(1990, 2, 20), new Date(2021, 12, 10), "C124");

        // Create accounts
        SavingsAccount savings = new SavingsAccount(customer1, manager, new Date(2022, 1, 5), 3.5);
        CheckingAccount checking = new CheckingAccount(customer2, manager, new Date(2021, 12, 10), 500.0);

        // Open accounts in bank
        bank.openAccount(savings);
        bank.openAccount(checking);

        // Print bank accounts
        System.out.println("Initial bank accounts:");
        System.out.println(bank);

        // Update accounts
        bank.updateAccounts();

        // Pay dividend
        bank.payDividend(2.0);

        // Print bank accounts after updates
        System.out.println("\\nBank accounts after updates and dividends:");
        System.out.println(bank);
    }
}

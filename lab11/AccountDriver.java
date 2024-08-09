package lab;

public class AccountDriver {
    public static void main(String[] args) {
        try {
            Customer customer = new Customer("Jane", "Doe", "555-1234", new Date(1985, 6, 15), new Date(2022, 1, 5), "A123");
            CheckingAccount checkingAccount = new CheckingAccount(customer, new Employee("John", "Doe"), new Date(2022, 1, 5), "12345");

            checkingAccount.deposit(2000);
            System.out.println("Balance after deposit: " + checkingAccount.getBalance());

            checkingAccount.withdraw(2500);
            System.out.println("Balance after withdrawal: " + checkingAccount.getBalance());

            checkingAccount.deposit(9000);  // This should throw InvalidBalanceException
        } catch (InvalidAccountNumberException | InvalidBalanceException | OverdraftException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            Customer customer = new Customer("John", "Smith", "555-5678", new Date(1990, 2, 20), new Date(2021, 12, 10), "B124");
            SavingsAccount savingsAccount = new SavingsAccount(customer, new Employee("Alice", "Brown"), new Date(2022, 1, 5), "54321");

            savingsAccount.deposit(1000);
            System.out.println("Balance after deposit: " + savingsAccount.getBalance());

            savingsAccount.withdraw(600);  // This should throw InvalidBalanceException
        } catch (InvalidBalanceException | OverdraftException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}


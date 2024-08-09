package lab;

public class Driver {
    public static void main(String[] args) throws OverdraftException, InvalidBalanceException {
        // Create a Customer with an invalid ID
        Customer customer = new Customer(customer);
        try {
            customer.setID("1234"); // Invalid ID format
        } catch (IDNotWellFormedException e) {
            System.out.println("IDNotWellFormedException caught: " + e.getMessage());
        }

        // Create a CheckingAccount with an invalid deposit amount
        CheckingAccount checkingAccount = new CheckingAccount();
        try {
            checkingAccount.deposit(15000.0); // Deposit amount exceeds maximum balance
        } catch (InvalidBalanceException e) {
            System.out.println("InvalidBalanceException caught: " + e.getMessage());
        }

        // Create a SavingsAccount with an invalid withdrawal amount
        SavingsAccount savingsAccount = new SavingsAccount(savingsAccount);
        try {
            savingsAccount.withdraw(200.0); // Withdrawal amount would fall below minimum balance
        } catch (InvalidBalanceException e) {
            System.out.println("InvalidBalanceException caught: " + e.getMessage());
        }

        // Create a SavingsAccount with an invalid number of withdrawals
        SavingsAccount savingsAccount2 = new SavingsAccount(savingsAccount2);
        try {
            for (int i = 0; i < 6; i++) {
                savingsAccount2.withdraw(50.0); // Exceed maximum number of withdrawals
            }
        } catch (OverdraftException e) {
            System.out.println("OverdraftException caught: " + e.getMessage());
        }
    }
}


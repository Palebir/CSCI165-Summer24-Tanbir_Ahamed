package lab;

import java.sql.Date;

public class SavingsAccount extends Account {

    private static final double MIN_BALANCE = 500.0;
    private static final int MAX_WITHDRAWALS = 3;
    private static final double WITHDRAWAL_LIMIT = 1000.0;
    private int withdrawals = 0;

    public SavingsAccount(Customer owner, Employee manager, Date dateCreated, String accountNumber) throws InvalidAccountNumberException {
        super(owner, manager, dateCreated, accountNumber);
    }

    public SavingsAccount(Customer customer, Employee manager, lab.Date date, String accountNumber) {
        //TODO Auto-generated constructor stub
    }

    public SavingsAccount(SavingsAccount savingsAccount) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public void withdraw(double amount) throws InvalidBalanceException, OverdraftException {
        if (withdrawals >= MAX_WITHDRAWALS) {
            throw new OverdraftException("Maximum number of withdrawals exceeded.");
        }
        if (amount > WITHDRAWAL_LIMIT) {
            throw new OverdraftException("Withdrawal amount exceeds the withdrawal limit.");
        }
        if (getBalance() - amount < MIN_BALANCE) {
            throw new InvalidBalanceException("Withdrawal would result in a balance below the minimum allowed.");
        }
        super.withdraw(amount);
        withdrawals++;
    }
}

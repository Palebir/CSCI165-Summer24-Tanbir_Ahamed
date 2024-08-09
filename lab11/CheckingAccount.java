package lab;

public class CheckingAccount extends Account {

    public static final double MAX_BALANCE = 10000.0;
    private static final double OVERDRAFT_LIMIT = -500.0;

    public CheckingAccount(Customer owner, Employee manager, java.sql.Date dateCreated, String accountNumber) throws InvalidAccountNumberException {
        super(owner, manager, dateCreated, accountNumber);
    }

    public CheckingAccount() {
        //TODO Auto-generated constructor stub
    }

    @Override
    public void deposit(double amount) throws InvalidBalanceException {
        if (getBalance() + amount > MAX_BALANCE) {
            throw new InvalidBalanceException("Deposit would exceed maximum allowed balance.");
        }
        super.deposit(amount);
    }

    @Override
    public void withdraw(double amount) throws InvalidBalanceException, OverdraftException {
        if (getBalance() - amount < OVERDRAFT_LIMIT) {
            throw new OverdraftException("Withdrawal would exceed overdraft limits.");
        }
        super.withdraw(amount);
    }
}

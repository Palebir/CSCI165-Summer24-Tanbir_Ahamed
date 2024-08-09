import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void openAccount(Account account) {
        accounts.add(account);
    }

    public void closeAccount(Account account) {
        accounts.remove(account);
    }

    public void updateAccounts() {
        for (Account account : accounts) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).addInterest();
            } else if (account instanceof CheckingAccount) {
                if (((CheckingAccount) account).isInOverdraft()) {
                    System.out.println("Sending overdraft letter to: " + account.getOwner().getFirstName());
                }
            }
        }
    }

    public void payDividend(double percentage) {
        for (Account account : accounts) {
            double dividend = account.getBalance() * percentage / 100;
            account.deposit(dividend);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Account account : accounts) {
            sb.append(account.toString()).append("\\n");
        }
        return sb.toString();
    }
}

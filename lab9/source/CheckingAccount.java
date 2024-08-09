public class CheckingAccount extends Account {

    private double overdraftLimit;

    public CheckingAccount(Customer owner, Employee manager, Date dateCreated, double overdraftLimit) {
        super(owner, manager, dateCreated);
        this.overdraftLimit = overdraftLimit;
    }

    public CheckingAccount(CheckingAccount toCopy) {
        super(toCopy);
        this.overdraftLimit = toCopy.overdraftLimit;
    }

    public boolean isInOverdraft() {
        return getBalance() < 0;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= -overdraftLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal denied. Overdraft limit exceeded.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\\nOverdraft Limit: " + overdraftLimit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        CheckingAccount other = (CheckingAccount) obj;

        return Double.compare(other.overdraftLimit, overdraftLimit) == 0;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}

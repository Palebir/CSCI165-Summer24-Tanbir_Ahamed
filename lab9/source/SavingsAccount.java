public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(Customer owner, Employee manager, Date dateCreated, double interestRate) {
        super(owner, manager, dateCreated);
        this.interestRate = interestRate;
    }

    public SavingsAccount(SavingsAccount toCopy) {
        super(toCopy);
        this.interestRate = toCopy.interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }

    @Override
    public String toString() {
        return super.toString() + "\\nInterest Rate: " + interestRate + "%";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        SavingsAccount other = (SavingsAccount) obj;

        return Double.compare(other.interestRate, interestRate) == 0;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}

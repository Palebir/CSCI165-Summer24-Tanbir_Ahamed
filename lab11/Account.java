package lab;

import java.sql.Date;

/*
	File:	Account.java
	Author:	Ken Whitener
	Date:	4/15/2024

 	A class for bank accounts.
	This class provides the basic functionality of accounts.
	It allows deposits and withdrawals but not overdraft limits or interest rates.
*/

public class Account {

    private String accountNumber;
    private double balance;
    private Customer owner;
    private Employee manager;
    private Date dateCreated;

    public Account(Customer owner, Employee manager, Date dateCreated, String accountNumber) throws InvalidAccountNumberException {
        this.owner = owner;
        this.manager = manager;
        this.dateCreated = dateCreated;
        setAccountNumber(accountNumber);
    }

    public void setAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        if (accountNumber.length() != 5) {
            throw new InvalidAccountNumberException("Account number must be 5 digits. Offending account number: " + accountNumber);
        }
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidBalanceException {
        if (amount < 0) {
            throw new InvalidBalanceException("Cannot deposit a negative amount.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidBalanceException, OverdraftException {
        if (amount < 0) {
            throw new InvalidBalanceException("Cannot withdraw a negative amount.");
        }
        balance -= amount;
    }
}


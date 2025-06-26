package org.codeposito.structural.proxy.protection;

public class RealBankAccount implements BankAccount {
    private final String owner;
    private double balance;

    public RealBankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(owner + " deposited $" + amount + ". New balance: $" + balance);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(owner + " withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Withdrawal failed for " + owner + ": insufficient funds or invalid amount.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getOwner() {
        return owner;
    }
} 
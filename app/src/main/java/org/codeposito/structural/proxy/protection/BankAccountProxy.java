package org.codeposito.structural.proxy.protection;

public class BankAccountProxy implements BankAccount {
    private final RealBankAccount realAccount;
    private final String userRole; // e.g., "ADMIN" or "USER"

    public BankAccountProxy(RealBankAccount realAccount, String userRole) {
        this.realAccount = realAccount;
        this.userRole = userRole;
    }

    @Override
    public void deposit(double amount) {
        realAccount.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        if ("ADMIN".equalsIgnoreCase(userRole)) {
            realAccount.withdraw(amount);
        } else {
            System.out.println("Access denied: Only ADMIN can withdraw from this account.");
        }
    }

    @Override
    public double getBalance() {
        return realAccount.getBalance();
    }

    @Override
    public String getOwner() {
        return realAccount.getOwner();
    }
} 
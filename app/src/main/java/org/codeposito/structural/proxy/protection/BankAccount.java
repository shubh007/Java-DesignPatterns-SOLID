package org.codeposito.structural.proxy.protection;

public interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    String getOwner();
} 
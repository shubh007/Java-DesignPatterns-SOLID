package org.codeposito.structural.proxy.protection;

public class ProtectionProxyClient {
    public static void main(String[] args) {
        System.out.println("=== Protection Proxy Pattern Demo ===\n");

        RealBankAccount realAccount = new RealBankAccount("Alice", 1000.0);
        BankAccount adminProxy = new BankAccountProxy(realAccount, "ADMIN");
        BankAccount userProxy = new BankAccountProxy(realAccount, "USER");

        System.out.println("[ADMIN access]");
        adminProxy.deposit(500);
        adminProxy.withdraw(200);
        System.out.println("Balance: $" + adminProxy.getBalance());

        System.out.println("\n[USER access]");
        userProxy.deposit(100);
        userProxy.withdraw(50); // Should be denied
        System.out.println("Balance: $" + userProxy.getBalance());

        System.out.println("\n=== Protection Proxy Pattern Demo Complete ===");
    }
} 
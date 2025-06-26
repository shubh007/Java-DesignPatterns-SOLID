package org.codeposito.structural.proxy.protection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProtectionProxyTest {
    private RealBankAccount realAccount;
    private BankAccount adminProxy;
    private BankAccount userProxy;

    @BeforeEach
    void setUp() {
        realAccount = new RealBankAccount("Alice", 1000.0);
        adminProxy = new BankAccountProxy(realAccount, "ADMIN");
        userProxy = new BankAccountProxy(realAccount, "USER");
    }

    @Test
    void adminCanWithdraw() {
        adminProxy.withdraw(100);
        assertEquals(900.0, adminProxy.getBalance(), 0.01);
    }

    @Test
    void userCannotWithdraw() {
        userProxy.withdraw(100);
        // Balance should remain unchanged
        assertEquals(1000.0, userProxy.getBalance(), 0.01);
    }

    @Test
    void anyoneCanDeposit() {
        adminProxy.deposit(200);
        userProxy.deposit(300);
        assertEquals(1500.0, realAccount.getBalance(), 0.01);
    }

    @Test
    void getOwnerWorks() {
        assertEquals("Alice", adminProxy.getOwner());
        assertEquals("Alice", userProxy.getOwner());
    }
} 
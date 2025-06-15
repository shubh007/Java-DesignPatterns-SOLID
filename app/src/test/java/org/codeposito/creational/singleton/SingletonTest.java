package org.codeposito.creational.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {
    
    @Test
    void testDCLSingleton() {
        DCLSingleton instance1 = DCLSingleton.getInstance();
        DCLSingleton instance2 = DCLSingleton.getInstance();
        
        assertSame(instance1, instance2, "DCLSingleton instances should be the same");
    }
    
    @Test
    void testEagerSingleton() {
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        
        assertSame(instance1, instance2, "EagerSingleton instances should be the same");
    }
    
    @Test
    void testBillPughSingleton() {
        BillPughSingleton instance1 = BillPughSingleton.getInstance();
        BillPughSingleton instance2 = BillPughSingleton.getInstance();
        
        assertSame(instance1, instance2, "BillPughSingleton instances should be the same");
    }
    
    @Test
    void testSynchronizedMethodSingleton() {
        SynchronizedMethodSingleton instance1 = SynchronizedMethodSingleton.getInstance();
        SynchronizedMethodSingleton instance2 = SynchronizedMethodSingleton.getInstance();
        
        assertSame(instance1, instance2, "SynchronizedMethodSingleton instances should be the same");
    }
    
    @Test
    void testEnumSingleton() {
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        
        assertSame(instance1, instance2, "EnumSingleton instances should be the same");
    }
} 
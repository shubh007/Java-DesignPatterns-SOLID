/**
 * Bill Pugh Singleton Implementation
 * 
 * This implementation uses a static inner class to hold the singleton instance.
 * The inner class is not loaded into memory until the getInstance() method is called.
 * This is considered the most efficient and thread-safe way to implement the Singleton pattern.
 * 
 * Pros:
 * 1. Thread-safe by design - uses class loading mechanism
 * 2. Lazy initialization - instance is created only when first requested
 * 3. No synchronization needed - uses JVM's class loading mechanism
 * 4. Most efficient implementation - no performance overhead
 * 5. Clean and simple implementation
 * 
 * Cons:
 * 1. Can't handle exceptions during instance creation
 * 2. Can't be used if the singleton needs to be serializable
 * 3. Can't be used if the singleton needs to be cloneable
 */
package org.codeposito.creational.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class BillPughSingleton {
    private final AtomicInteger counter = new AtomicInteger(0);

    // Private constructor to prevent instantiation from other classes
    private BillPughSingleton() {
        // private constructor to prevent instantiation
    }

    // Static inner class that holds the singleton instance
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // Public method to get the singleton instance
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // This method is not thread safe but not a problem because it is not a shared resource
    public void doSomethingNotThreadSafe(int a) {
        for (int i = 0; i < a; i++) {
            System.out.println("Counter till a: " + i);
        }
    }

    // This method is thread-safe because it uses AtomicInteger for the shared counter resource
    public void doSomethingThreadSafeWithAtomic() {
        counter.incrementAndGet();
        System.out.println("Counter: " + counter.get());
    }
}

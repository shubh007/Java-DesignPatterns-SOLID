/**
 * Eager Singleton Implementation
 * 
 * This implementation creates the singleton instance at the time of class loading.
 * The instance is created before it is needed, regardless of whether it will be used or not.
 * 
 * Pros:
 * 1. Thread-safe by default - instance is created during class loading
 * 2. Simple and straightforward implementation
 * 3. No need for synchronization
 * 
 * Cons:
 * 1. Instance is created even if it's never used (wastes resources)
 * 2. No exception handling during instance creation
 * 3. No lazy initialization
 */
package org.codeposito.creational.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class EagerSingleton {
    // Private static instance created at class loading time
    private static final EagerSingleton instance = new EagerSingleton();
    private final AtomicInteger counter = new AtomicInteger(0);

    // Private constructor to prevent instantiation from other classes
    private EagerSingleton() {
        // private constructor to prevent instantiation
    }

    // Public method to get the singleton instance
    public static EagerSingleton getInstance() {
        return instance;
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

/**
 * Double-Checked Locking (DCL) Singleton Implementation
 * 
 * This implementation uses double-checked locking to reduce the overhead of acquiring
 * a lock by first testing the locking criterion without actually acquiring the lock.
 * The volatile keyword ensures that multiple threads handle the instance variable correctly.
 * 
 * Pros:
 * 1. Thread-safe - prevents multiple instance creation in multi-threaded environment
 * 2. Lazy initialization - instance is created only when first requested
 * 3. Better performance than synchronized method - synchronization only happens during first creation
 * 4. Reduces the overhead of acquiring a lock by checking the locking criterion first
 * 
 * Cons:
 * 1. Complex implementation - requires understanding of volatile keyword and memory model
 * 2. Can be broken in some JVM implementations if not implemented correctly
 * 3. Requires Java 5 or higher for the volatile keyword to work correctly
 */
package org.codeposito.creational.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class DCLSingleton {
    // Private static volatile instance
    // volatile ensures that multiple threads handle the instance variable correctly
    private static volatile DCLSingleton instance;
    private final AtomicInteger counter = new AtomicInteger(0);

    // Private constructor to prevent instantiation from other classes
    private DCLSingleton() {
        // private constructor to prevent instantiation
    }

    // Double-checked locking implementation
    public static DCLSingleton getInstance() {
        // First check (without locking)
        if (instance == null) {
            // Synchronized block for thread safety
            synchronized (DCLSingleton.class) {
                // Second check (with locking)
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
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

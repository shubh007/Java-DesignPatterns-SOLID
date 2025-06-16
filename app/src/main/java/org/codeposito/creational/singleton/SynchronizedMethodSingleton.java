/**
 * Synchronized Method Singleton Implementation
 * 
 * This implementation uses method-level synchronization to ensure thread safety.
 * The synchronized keyword is applied to the getInstance() method, which means
 * only one thread can execute this method at a time.
 * 
 * Pros:
 * 1. Thread-safe - prevents multiple instance creation in multi-threaded environment
 * 2. Lazy initialization - instance is created only when first requested
 * 3. Simple to understand and implement
 * 
 * Cons:
 * 1. Performance overhead - synchronization is expensive
 * 2. Synchronization is only needed during the first creation of the instance
 * 3. All subsequent calls to getInstance() will still be synchronized, even though they don't need to be
 */
package org.codeposito.creational.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedMethodSingleton {
    // Private static instance, not initialized at declaration
    private static SynchronizedMethodSingleton instance;
    private final AtomicInteger counter = new AtomicInteger(0);

    // Private constructor to prevent instantiation from other classes
    private SynchronizedMethodSingleton() {
        // private constructor to prevent instantiation
    }

    // Synchronized method to get the singleton instance
    public static synchronized SynchronizedMethodSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedMethodSingleton();
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

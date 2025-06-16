/**
 * Enum Singleton Implementation
 * 
 * This implementation uses Java's enum type to implement the Singleton pattern.
 * It is the simplest way to implement a thread-safe singleton in Java.
 * The enum type is guaranteed to be instantiated only once by the JVM.
 * 
 * Pros:
 * 1. Thread-safe by default - JVM guarantees single instance
 * 2. Serialization handled automatically
 * 3. Protection against reflection attacks
 * 4. Most concise implementation
 * 5. No need to implement readResolve() method
 * 
 * Cons:
 * 1. Not lazy initialized - instance is created when enum is loaded
 * 2. Less flexible than other implementations
 * 3. Can't extend another class (Java enums can't extend classes)
 * 4. Can't have instance fields that are not final
 */
package org.codeposito.creational.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public enum EnumSingleton {
    // Single instance of the enum
    INSTANCE;

    private final AtomicInteger counter = new AtomicInteger(0);

    // This method is not thread safe but not a problem because it is not a shared resource
    public void doSomethingNotThreadSafe(int a) {
        for (int i = 0; i < a; i++) {
            System.out.println("Counter till a: " + i);
        }
    }

    public void doSomethingThreadSafeWithAtomic() {
        counter.incrementAndGet();
        System.out.println("Counter: " + counter.get());
    }

    // Add your singleton methods here
    public void doSomething() {
        // Implementation
    }
}

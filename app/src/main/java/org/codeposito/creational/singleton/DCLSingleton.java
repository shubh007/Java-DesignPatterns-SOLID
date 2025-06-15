package org.codeposito.creational.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class DCLSingleton {
    private static volatile DCLSingleton instance;
    private final AtomicInteger counter = new AtomicInteger(0);

    private DCLSingleton() {
        // private constructor to prevent instantiation
    }

    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
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

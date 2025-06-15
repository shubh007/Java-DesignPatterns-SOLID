package org.codeposito.creational.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class BillPughSingleton {
    private final AtomicInteger counter = new AtomicInteger(0);

    private BillPughSingleton() {
        // private constructor to prevent instantiation
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

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

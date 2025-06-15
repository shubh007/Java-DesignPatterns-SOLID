package org.codeposito.creational.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public enum EnumSingleton {
    INSTANCE;

    private final AtomicInteger counter = new AtomicInteger(0);

    public void doSomethingThreadSafe(int a) {
        for (int i = 0; i < a; i++) {
            counter.incrementAndGet();
            System.out.println("Counter: " + counter.get());
        }
    }

    public void doSomethingThreadSafeWithAtomic() {
        counter.incrementAndGet();
        System.out.println("Counter: " + counter.get());
    }

}

package org.codeposito.creational.factory.regular;

// Step 2: Concrete Product Class : Car
public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started. Vroom!");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped. Silence.");
    }
}
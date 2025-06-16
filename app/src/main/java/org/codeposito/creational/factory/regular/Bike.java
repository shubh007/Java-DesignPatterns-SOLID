package org.codeposito.creational.factory.regular;

// Step 2: Concrete Product Class : Bike
public class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started. Vroom vroom!");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped. Phew.");
    }
}

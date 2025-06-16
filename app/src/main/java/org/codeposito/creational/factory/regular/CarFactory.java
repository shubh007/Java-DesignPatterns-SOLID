package org.codeposito.creational.factory.regular;

// Step 4: Concrete Creator Class : CarFactory
public class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car(); // Returns a specific Concrete Product
    }
}
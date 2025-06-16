package org.codeposito.creational.factory.regular;

// Step 4: Concrete Creator Class : BikeFactory
public class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bike(); // Returns a specific Concrete Product
    }
}

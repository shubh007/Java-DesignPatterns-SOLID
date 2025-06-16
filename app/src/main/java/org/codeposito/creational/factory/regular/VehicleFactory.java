package org.codeposito.creational.factory.regular;

//Step 3: Creator Abstract Class : VehicleFactory
public abstract class VehicleFactory {
    // The factory method - returns a Product type
    public abstract Vehicle createVehicle();

    // An operation that uses the factory method
    public void operateVehicle() {
        Vehicle vehicle = createVehicle(); // Calls the factory method to get a vehicle
        vehicle.start();
        vehicle.stop();
        System.out.println("Vehicle operation complete.");
    }
}
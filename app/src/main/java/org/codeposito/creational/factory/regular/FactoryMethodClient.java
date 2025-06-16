package org.codeposito.creational.factory.regular;

// Step 5: Client Class : FactoryMethodClient
public class FactoryMethodClient {
    public static void main(String[] args) {
       // Create a Car using CarFactory
       VehicleFactory carFactory = new CarFactory();
       System.out.println("--- Using CarFactory ---");
       carFactory.operateVehicle(); // Client interacts with Creator, not ConcreteProduct directly

       System.out.println("\n--- Using BikeFactory ---");
       // Create a Bike using BikeFactory
       VehicleFactory bikeFactory = new BikeFactory();
       bikeFactory.operateVehicle(); // Client interacts with Creator, not ConcreteProduct directly

       // You could also directly use createVehicle if operateVehicle wasn't needed
       System.out.println("\n--- Direct creation ---");
       Vehicle myNewCar = new CarFactory().createVehicle();
       myNewCar.start();
       myNewCar.stop();
    }
}

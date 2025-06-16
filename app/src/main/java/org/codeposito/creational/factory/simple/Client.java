package org.codeposito.creational.factory.simple;

//Step 4: Client
public class Client {
    public static void main(String[] args) {
        try {
            // Create and use Product A
            System.out.println("Creating Product A:");
            Product productA = SimpleProductFactory.createProduct(SimpleProductFactory.ProductType.TYPE_A);
            productA.operation();

            // Create and use Product B
            System.out.println("\nCreating Product B:");
            Product productB = SimpleProductFactory.createProduct(SimpleProductFactory.ProductType.TYPE_B);
            productB.operation();
        } catch (Exception e) {
            System.err.println("Error creating product: " + e.getMessage());
        }
    }
}

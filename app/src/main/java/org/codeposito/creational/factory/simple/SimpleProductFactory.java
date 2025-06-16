package org.codeposito.creational.factory.simple;

//Step 3: Simple Factory
public class SimpleProductFactory {
    // Product types enum for type safety
    public enum ProductType {
        TYPE_A,
        TYPE_B
    }

    public static Product createProduct(ProductType type) {
        return switch (type) {
            case TYPE_A -> new ConcreteProductA();
            case TYPE_B -> new ConcreteProductB();
        };
    }
}

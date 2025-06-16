package org.codeposito.creational.factory.simple;

//Step 2: Concrete Product B
public class ConcreteProductB implements Product {
    @Override
    public void operation() {
        System.out.println("Executing operation in ConcreteProductB");
    }
}
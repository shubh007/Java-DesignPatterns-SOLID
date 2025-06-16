package org.codeposito.creational.factory.simple;

//Step 2: Concrete Product A
public class ConcreteProductA implements Product {
    @Override
    public void operation() {
        System.out.println("Executing operation in ConcreteProductA");
    }
}

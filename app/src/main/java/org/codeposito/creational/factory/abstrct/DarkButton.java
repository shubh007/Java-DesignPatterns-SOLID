package org.codeposito.creational.factory.abstrct;

//Step 3: Concrete Product - DarkButton
public class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a dark theme button");
    }

    @Override
    public void onClick() {
        System.out.println("DarkButton clicked");
    }
}

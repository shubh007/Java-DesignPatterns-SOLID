package org.codeposito.creational.factory.abstrct;

//Step 3: Concrete Product - LightButton
public class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a light theme button");
    }

    @Override
    public void onClick() {
        System.out.println("LightButton clicked");
    }
}

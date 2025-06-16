package org.codeposito.creational.factory.abstrct;

//Step 3: Concrete Product - LightCheckbox
public class LightCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a light theme checkbox");
    }

    @Override
    public void onSelect() {
        System.out.println("LightCheckbox selected");
    }
}

package org.codeposito.creational.factory.abstrct;

//Step 3: Concrete Product - DarkCheckbox
public class DarkCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a dark theme checkbox");
    }

    @Override
    public void onSelect() {
        System.out.println("DarkCheckbox selected");
    }
}

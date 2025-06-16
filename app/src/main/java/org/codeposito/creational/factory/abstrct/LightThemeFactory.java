package org.codeposito.creational.factory.abstrct;

//Step 4: Concrete Factory - LightThemeFactory
public class LightThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}

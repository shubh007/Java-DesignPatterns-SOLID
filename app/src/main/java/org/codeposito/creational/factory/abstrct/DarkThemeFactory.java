package org.codeposito.creational.factory.abstrct;

//Step 4: Concrete Factory - DarkThemeFactory
public class DarkThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}

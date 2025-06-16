package org.codeposito.creational.factory.abstrct;

//Step 2: Abstract Factory Interface - GUIFactory
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

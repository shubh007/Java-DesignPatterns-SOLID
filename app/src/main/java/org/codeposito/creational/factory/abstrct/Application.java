package org.codeposito.creational.factory.abstrct;

//Step 5: Client - Application
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render() {
        button.render();
        checkbox.render();
    }

    public static void main(String[] args) {
        // Create application with light theme
        Application lightApp = new Application(new LightThemeFactory());
        System.out.println("Rendering Light Theme Application:");
        lightApp.render();

        // Create application with dark theme
        Application darkApp = new Application(new DarkThemeFactory());
        System.out.println("\nRendering Dark Theme Application:");
        darkApp.render();
    }
}

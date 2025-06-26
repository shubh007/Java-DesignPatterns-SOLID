package org.codeposito.structural.facade;

/**
 * Screen - Subsystem component that handles projection screen functionality.
 */
public class Screen {
    private boolean isDown = false;

    public void up() {
        isDown = false;
        System.out.println("🖥️ Screen going up");
    }

    public void down() {
        isDown = true;
        System.out.println("🖥️ Screen going down");
    }

    public boolean isDown() {
        return isDown;
    }

    @Override
    public String toString() {
        return "Screen";
    }
} 
package org.codeposito.structural.facade;

/**
 * PopcornPopper - Subsystem component that handles popcorn popping functionality.
 */
public class PopcornPopper {
    private boolean isOn = false;

    public void on() {
        isOn = true;
        System.out.println("🍿 Popcorn popper is ON");
    }

    public void off() {
        isOn = false;
        System.out.println("🍿 Popcorn popper is OFF");
    }

    public void pop() {
        System.out.println("🍿 Popcorn popper popping popcorn!");
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Popcorn Popper";
    }
} 
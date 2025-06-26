package org.codeposito.structural.facade;

/**
 * Projector - Subsystem component that handles video projection functionality.
 */
public class Projector {
    private boolean isOn = false;
    private String inputMode = "HDMI";

    public void on() {
        isOn = true;
        System.out.println("📽️ Projector is ON");
    }

    public void off() {
        isOn = false;
        System.out.println("📽️ Projector is OFF");
    }

    public void wideScreenMode() {
        System.out.println("📽️ Projector in widescreen mode");
    }

    public void tvMode() {
        System.out.println("📽️ Projector in TV mode");
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Projector";
    }
} 
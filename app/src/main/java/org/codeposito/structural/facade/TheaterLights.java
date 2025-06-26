package org.codeposito.structural.facade;

/**
 * TheaterLights - Subsystem component that handles theater lighting functionality.
 */
public class TheaterLights {
    private boolean isOn = false;
    private int dimLevel = 100;

    public void on() {
        isOn = true;
        dimLevel = 100;
        System.out.println("💡 Theater lights are ON");
    }

    public void off() {
        isOn = false;
        System.out.println("💡 Theater lights are OFF");
    }

    public void dim(int level) {
        this.dimLevel = level;
        System.out.println("💡 Theater lights dimming to " + level + "%");
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Theater Lights";
    }
} 
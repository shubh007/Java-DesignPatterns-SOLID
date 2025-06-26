package org.codeposito.structural.facade;

/**
 * Tuner - Subsystem component that handles radio tuning functionality.
 */
public class Tuner {
    private boolean isOn = false;
    private double frequency = 0.0;

    public void on() {
        isOn = true;
        System.out.println("📻 Tuner is ON");
    }

    public void off() {
        isOn = false;
        System.out.println("📻 Tuner is OFF");
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
        System.out.println("📻 Tuner set frequency to " + frequency);
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Tuner";
    }
} 
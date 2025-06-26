package org.codeposito.structural.facade;

/**
 * CdPlayer - Subsystem component that handles CD playback functionality.
 */
public class CdPlayer {
    private boolean isOn = false;
    private String currentCd = "";

    public void on() {
        isOn = true;
        System.out.println("💿 CD Player is ON");
    }

    public void off() {
        isOn = false;
        System.out.println("💿 CD Player is OFF");
    }

    public void play(String title) {
        currentCd = title;
        System.out.println("💿 CD Player playing \"" + title + "\"");
    }

    public void eject() {
        System.out.println("💿 CD Player eject");
        currentCd = "";
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "CD Player";
    }
} 
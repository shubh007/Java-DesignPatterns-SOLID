package org.codeposito.structural.facade;

/**
 * DvdPlayer - Subsystem component that handles DVD playback functionality.
 */
public class DvdPlayer {
    private boolean isOn = false;
    private String currentMovie = "";

    public void on() {
        isOn = true;
        System.out.println("📀 DVD Player is ON");
    }

    public void off() {
        isOn = false;
        System.out.println("📀 DVD Player is OFF");
    }

    public void play(String movie) {
        currentMovie = movie;
        System.out.println("📀 DVD Player playing \"" + movie + "\"");
    }

    public void stop() {
        System.out.println("📀 DVD Player stopped \"" + currentMovie + "\"");
        currentMovie = "";
    }

    public void eject() {
        System.out.println("📀 DVD Player eject");
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "DVD Player";
    }
} 
package org.codeposito.structural.facade;

/**
 * Amplifier - Subsystem component that handles audio amplification
 * and routing for the home theater system.
 */
public class Amplifier {
    private boolean isOn = false;
    private int volume = 0;
    private String currentSource = "None";
    private String soundMode = "Stereo";

    public void on() {
        isOn = true;
        System.out.println("🔊 Amplifier is ON");
    }

    public void off() {
        isOn = false;
        System.out.println("🔊 Amplifier is OFF");
    }

    public void setDvd(DvdPlayer dvdPlayer) {
        currentSource = "DVD";
        System.out.println("🔊 Amplifier setting DVD player to " + dvdPlayer);
    }

    public void setTuner(Tuner tuner) {
        currentSource = "Tuner";
        System.out.println("🔊 Amplifier setting Tuner to " + tuner);
    }

    public void setCd(CdPlayer cdPlayer) {
        currentSource = "CD";
        System.out.println("🔊 Amplifier setting CD player to " + cdPlayer);
    }

    public void setSurroundSound() {
        soundMode = "Surround";
        System.out.println("🔊 Amplifier surround sound on");
    }

    public void setStereoSound() {
        soundMode = "Stereo";
        System.out.println("🔊 Amplifier stereo sound on");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("🔊 Amplifier setting volume to " + volume);
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Amplifier";
    }
} 
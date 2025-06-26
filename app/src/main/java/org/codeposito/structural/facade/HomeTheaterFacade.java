package org.codeposito.structural.facade;

/**
 * HomeTheaterFacade - The Facade class that provides a simplified interface
 * to the complex home theater system. It encapsulates the complexity of
 * multiple subsystems and provides a unified interface for common operations.
 */
public class HomeTheaterFacade {
    private final Amplifier amplifier;
    private final Tuner tuner;
    private final DvdPlayer dvdPlayer;
    private final CdPlayer cdPlayer;
    private final Projector projector;
    private final TheaterLights lights;
    private final Screen screen;
    private final PopcornPopper popcornPopper;

    public HomeTheaterFacade() {
        this.amplifier = new Amplifier();
        this.tuner = new Tuner();
        this.dvdPlayer = new DvdPlayer();
        this.cdPlayer = new CdPlayer();
        this.projector = new Projector();
        this.lights = new TheaterLights();
        this.screen = new Screen();
        this.popcornPopper = new PopcornPopper();
    }

    /**
     * Watch a movie - orchestrates all components for movie viewing
     */
    public void watchMovie(String movie) {
        System.out.println("🎬 Getting ready to watch " + movie + "...");
        
        popcornPopper.on();
        popcornPopper.pop();
        
        lights.dim(10);
        screen.down();
        
        projector.on();
        projector.wideScreenMode();
        
        amplifier.on();
        amplifier.setDvd(dvdPlayer);
        amplifier.setSurroundSound();
        amplifier.setVolume(5);
        
        dvdPlayer.on();
        dvdPlayer.play(movie);
        
        System.out.println("🎬 Movie is ready to watch!");
    }

    /**
     * End movie - turns off all components used for movie viewing
     */
    public void endMovie() {
        System.out.println("🎬 Shutting down movie theater...");
        
        popcornPopper.off();
        lights.on();
        screen.up();
        projector.off();
        amplifier.off();
        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();
        
        System.out.println("🎬 Movie theater shutdown complete!");
    }

    /**
     * Listen to radio - orchestrates components for radio listening
     */
    public void listenToRadio(double frequency) {
        System.out.println("📻 Getting ready to listen to radio...");
        
        lights.on();
        amplifier.on();
        amplifier.setTuner(tuner);
        amplifier.setVolume(5);
        tuner.on();
        tuner.setFrequency(frequency);
        
        System.out.println("📻 Radio is ready to listen!");
    }

    /**
     * End radio - turns off radio-related components
     */
    public void endRadio() {
        System.out.println("📻 Shutting down radio...");
        
        tuner.off();
        amplifier.off();
        
        System.out.println("📻 Radio shutdown complete!");
    }

    /**
     * Listen to CD - orchestrates components for CD listening
     */
    public void listenToCd(String title) {
        System.out.println("💿 Getting ready to listen to CD...");
        
        lights.on();
        amplifier.on();
        amplifier.setCd(cdPlayer);
        amplifier.setStereoSound();
        amplifier.setVolume(5);
        cdPlayer.on();
        cdPlayer.play(title);
        
        System.out.println("💿 CD is ready to listen!");
    }

    /**
     * End CD - turns off CD-related components
     */
    public void endCd() {
        System.out.println("💿 Shutting down CD...");
        
        amplifier.off();
        cdPlayer.eject();
        cdPlayer.off();
        
        System.out.println("💿 CD shutdown complete!");
    }

    /**
     * Get system status - provides information about all components
     */
    public void getSystemStatus() {
        System.out.println("\n🏠 Home Theater System Status:");
        System.out.println("================================");
        System.out.println("Amplifier: " + (amplifier.isOn() ? "ON" : "OFF"));
        System.out.println("Tuner: " + (tuner.isOn() ? "ON" : "OFF"));
        System.out.println("DVD Player: " + (dvdPlayer.isOn() ? "ON" : "OFF"));
        System.out.println("CD Player: " + (cdPlayer.isOn() ? "ON" : "OFF"));
        System.out.println("Projector: " + (projector.isOn() ? "ON" : "OFF"));
        System.out.println("Lights: " + (lights.isOn() ? "ON" : "OFF"));
        System.out.println("Screen: " + (screen.isDown() ? "DOWN" : "UP"));
        System.out.println("Popcorn Popper: " + (popcornPopper.isOn() ? "ON" : "OFF"));
        System.out.println("================================");
    }
} 
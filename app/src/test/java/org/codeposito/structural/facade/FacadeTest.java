package org.codeposito.structural.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for the Facade pattern implementation.
 * Tests all subsystem components and the facade orchestration.
 */
@DisplayName("Facade Pattern Tests")
class FacadeTest {

    private HomeTheaterFacade homeTheater;
    private Amplifier amplifier;
    private Tuner tuner;
    private DvdPlayer dvdPlayer;
    private CdPlayer cdPlayer;
    private Projector projector;
    private TheaterLights lights;
    private Screen screen;
    private PopcornPopper popcornPopper;

    @BeforeEach
    void setUp() {
        homeTheater = new HomeTheaterFacade();
        amplifier = new Amplifier();
        tuner = new Tuner();
        dvdPlayer = new DvdPlayer();
        cdPlayer = new CdPlayer();
        projector = new Projector();
        lights = new TheaterLights();
        screen = new Screen();
        popcornPopper = new PopcornPopper();
    }

    @Test
    @DisplayName("Test Amplifier functionality")
    void testAmplifier() {
        assertFalse(amplifier.isOn());
        
        amplifier.on();
        assertTrue(amplifier.isOn());
        
        amplifier.off();
        assertFalse(amplifier.isOn());
        
        assertEquals("Amplifier", amplifier.toString());
    }

    @Test
    @DisplayName("Test Tuner functionality")
    void testTuner() {
        assertFalse(tuner.isOn());
        
        tuner.on();
        assertTrue(tuner.isOn());
        
        tuner.setFrequency(95.5);
        tuner.off();
        assertFalse(tuner.isOn());
        
        assertEquals("Tuner", tuner.toString());
    }

    @Test
    @DisplayName("Test DVD Player functionality")
    void testDvdPlayer() {
        assertFalse(dvdPlayer.isOn());
        
        dvdPlayer.on();
        assertTrue(dvdPlayer.isOn());
        
        dvdPlayer.play("Test Movie");
        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();
        assertFalse(dvdPlayer.isOn());
        
        assertEquals("DVD Player", dvdPlayer.toString());
    }

    @Test
    @DisplayName("Test CD Player functionality")
    void testCdPlayer() {
        assertFalse(cdPlayer.isOn());
        
        cdPlayer.on();
        assertTrue(cdPlayer.isOn());
        
        cdPlayer.play("Test CD");
        cdPlayer.eject();
        cdPlayer.off();
        assertFalse(cdPlayer.isOn());
        
        assertEquals("CD Player", cdPlayer.toString());
    }

    @Test
    @DisplayName("Test Projector functionality")
    void testProjector() {
        assertFalse(projector.isOn());
        
        projector.on();
        assertTrue(projector.isOn());
        
        projector.wideScreenMode();
        projector.tvMode();
        projector.off();
        assertFalse(projector.isOn());
        
        assertEquals("Projector", projector.toString());
    }

    @Test
    @DisplayName("Test Theater Lights functionality")
    void testTheaterLights() {
        assertFalse(lights.isOn());
        
        lights.on();
        assertTrue(lights.isOn());
        
        lights.dim(50);
        lights.off();
        assertFalse(lights.isOn());
        
        assertEquals("Theater Lights", lights.toString());
    }

    @Test
    @DisplayName("Test Screen functionality")
    void testScreen() {
        assertFalse(screen.isDown());
        
        screen.down();
        assertTrue(screen.isDown());
        
        screen.up();
        assertFalse(screen.isDown());
        
        assertEquals("Screen", screen.toString());
    }

    @Test
    @DisplayName("Test Popcorn Popper functionality")
    void testPopcornPopper() {
        assertFalse(popcornPopper.isOn());
        
        popcornPopper.on();
        assertTrue(popcornPopper.isOn());
        
        popcornPopper.pop();
        popcornPopper.off();
        assertFalse(popcornPopper.isOn());
        
        assertEquals("Popcorn Popper", popcornPopper.toString());
    }

    @Test
    @DisplayName("Test Facade movie watching functionality")
    void testFacadeWatchMovie() {
        // Test that facade can be created without errors
        assertNotNull(homeTheater);
        
        // Test movie watching (this will output to console)
        assertDoesNotThrow(() -> {
            homeTheater.watchMovie("Test Movie");
            homeTheater.getSystemStatus();
            homeTheater.endMovie();
        });
    }

    @Test
    @DisplayName("Test Facade radio listening functionality")
    void testFacadeListenToRadio() {
        assertDoesNotThrow(() -> {
            homeTheater.listenToRadio(95.5);
            homeTheater.getSystemStatus();
            homeTheater.endRadio();
        });
    }

    @Test
    @DisplayName("Test Facade CD listening functionality")
    void testFacadeListenToCd() {
        assertDoesNotThrow(() -> {
            homeTheater.listenToCd("Test Album");
            homeTheater.getSystemStatus();
            homeTheater.endCd();
        });
    }

    @Test
    @DisplayName("Test Facade system status functionality")
    void testFacadeSystemStatus() {
        assertDoesNotThrow(() -> {
            homeTheater.getSystemStatus();
        });
    }

    @Test
    @DisplayName("Test complete Facade workflow")
    void testCompleteFacadeWorkflow() {
        assertDoesNotThrow(() -> {
            // Complete movie experience
            homeTheater.watchMovie("Complete Test Movie");
            homeTheater.getSystemStatus();
            homeTheater.endMovie();
            
            // Complete radio experience
            homeTheater.listenToRadio(101.1);
            homeTheater.getSystemStatus();
            homeTheater.endRadio();
            
            // Complete CD experience
            homeTheater.listenToCd("Complete Test Album");
            homeTheater.getSystemStatus();
            homeTheater.endCd();
            
            // Final status check
            homeTheater.getSystemStatus();
        });
    }

    @Test
    @DisplayName("Test Facade with null and empty inputs")
    void testFacadeWithNullAndEmptyInputs() {
        assertDoesNotThrow(() -> {
            homeTheater.watchMovie("");
            homeTheater.endMovie();
            
            homeTheater.listenToCd("");
            homeTheater.endCd();
        });
    }

    @Test
    @DisplayName("Test Facade multiple operations")
    void testFacadeMultipleOperations() {
        assertDoesNotThrow(() -> {
            // Multiple movie operations
            homeTheater.watchMovie("Movie 1");
            homeTheater.endMovie();
            homeTheater.watchMovie("Movie 2");
            homeTheater.endMovie();
            
            // Multiple radio operations
            homeTheater.listenToRadio(95.5);
            homeTheater.endRadio();
            homeTheater.listenToRadio(101.1);
            homeTheater.endRadio();
            
            // Multiple CD operations
            homeTheater.listenToCd("Album 1");
            homeTheater.endCd();
            homeTheater.listenToCd("Album 2");
            homeTheater.endCd();
        });
    }
} 
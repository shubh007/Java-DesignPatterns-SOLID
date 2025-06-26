package org.codeposito.structural.facade;

/**
 * FacadeClient - Demonstrates the Facade pattern by showing how a complex
 * home theater system can be controlled through a simple interface.
 */
public class FacadeClient {
    public static void main(String[] args) {
        System.out.println("🏠 Home Theater Facade Pattern Demo");
        System.out.println("=====================================\n");

        // Create the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        // Demo 1: Watch a movie
        System.out.println("🎬 Demo 1: Watching a Movie");
        System.out.println("----------------------------");
        homeTheater.watchMovie("Raiders of the Lost Ark");
        
        // Show system status
        homeTheater.getSystemStatus();
        
        // End the movie
        homeTheater.endMovie();
        System.out.println();

        // Demo 2: Listen to radio
        System.out.println("📻 Demo 2: Listening to Radio");
        System.out.println("------------------------------");
        homeTheater.listenToRadio(95.5);
        
        // Show system status
        homeTheater.getSystemStatus();
        
        // End radio
        homeTheater.endRadio();
        System.out.println();

        // Demo 3: Listen to CD
        System.out.println("💿 Demo 3: Listening to CD");
        System.out.println("---------------------------");
        homeTheater.listenToCd("Greatest Hits Album");
        
        // Show system status
        homeTheater.getSystemStatus();
        
        // End CD
        homeTheater.endCd();
        System.out.println();

        // Demo 4: Complete movie experience
        System.out.println("🎬 Demo 4: Complete Movie Experience");
        System.out.println("------------------------------------");
        homeTheater.watchMovie("The Matrix");
        
        // Simulate movie watching
        System.out.println("\n🎬 Movie is playing... (simulating 2 hours of entertainment)");
        try {
            Thread.sleep(2000); // Simulate 2 seconds instead of 2 hours
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        homeTheater.endMovie();
        
        // Final system status
        System.out.println("\n🏠 Final System Status:");
        homeTheater.getSystemStatus();

        System.out.println("\n✅ Facade Pattern Demo Complete!");
        System.out.println("\n💡 Key Benefits Demonstrated:");
        System.out.println("   • Simplified interface to complex subsystem");
        System.out.println("   • Encapsulated complexity of multiple components");
        System.out.println("   • Easy to use high-level operations");
        System.out.println("   • Reduced coupling between client and subsystems");
    }
} 
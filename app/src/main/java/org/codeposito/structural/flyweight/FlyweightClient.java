package org.codeposito.structural.flyweight;

/**
 * FlyweightClient demonstrates the Flyweight design pattern.
 * Shows how the pattern reduces memory usage by sharing common state.
 */
public class FlyweightClient {
    public static void main(String[] args) {
        System.out.println("=== Flyweight Design Pattern Demo ===\n");

        // Create a text editor
        TextEditor editor = new TextEditor(10, 50);
        
        // Demonstrate memory efficiency with repeated characters
        demonstrateMemoryEfficiency(editor);
        
        // Demonstrate different character styles
        demonstrateCharacterStyles(editor);
        
        // Demonstrate large text with many repeated characters
        demonstrateLargeText(editor);
        
        // Print final statistics
        CharacterFactory.printStatistics();
        
        System.out.println("=== Flyweight Pattern Demo Complete ===");
    }

    /**
     * Demonstrates memory efficiency by using many repeated characters.
     */
    private static void demonstrateMemoryEfficiency(TextEditor editor) {
        System.out.println("1. Memory Efficiency Demonstration");
        System.out.println("Adding many repeated characters...\n");

        // Add the same character 'A' multiple times with same properties
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                editor.addCharacter(row, col, 'A', "Arial", 12, "black");
            }
        }

        // Add the same character 'B' multiple times with same properties
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                editor.addCharacter(row, col, 'B', "Arial", 12, "black");
            }
        }

        editor.displayText();
        editor.displayDetailedInfo();
        CharacterFactory.printStatistics();
    }

    /**
     * Demonstrates different character styles and their reuse.
     */
    private static void demonstrateCharacterStyles(TextEditor editor) {
        System.out.println("2. Character Styles Demonstration");
        System.out.println("Adding characters with different styles...\n");

        // Clear previous content
        editor.clear();
        CharacterFactory.clearCache();

        // Add characters with different styles
        editor.addCharacter(0, 0, 'H', "Arial", 16, "blue");
        editor.addCharacter(0, 1, 'e', "Arial", 16, "blue");
        editor.addCharacter(0, 2, 'l', "Arial", 16, "blue");
        editor.addCharacter(0, 3, 'l', "Arial", 16, "blue"); // Reused
        editor.addCharacter(0, 4, 'o', "Arial", 16, "blue");

        editor.addCharacter(1, 0, 'W', "Times", 14, "red");
        editor.addCharacter(1, 1, 'o', "Times", 14, "red");
        editor.addCharacter(1, 2, 'r', "Times", 14, "red");
        editor.addCharacter(1, 3, 'l', "Times", 14, "red"); // Different style, so new object
        editor.addCharacter(1, 4, 'd', "Times", 14, "red");

        editor.addCharacter(2, 0, '!', "Arial", 20, "green");
        editor.addCharacter(2, 1, '!', "Arial", 20, "green"); // Reused
        editor.addCharacter(2, 2, '!', "Arial", 20, "green"); // Reused

        editor.displayText();
        editor.displayDetailedInfo();
        CharacterFactory.printStatistics();
    }

    /**
     * Demonstrates large text with many repeated characters.
     */
    private static void demonstrateLargeText(TextEditor editor) {
        System.out.println("3. Large Text Demonstration");
        System.out.println("Adding a large amount of text with many repeated characters...\n");

        // Clear previous content
        editor.clear();
        CharacterFactory.clearCache();

        String[] words = {
            "THE", "QUICK", "BROWN", "FOX", "JUMPS", "OVER", "THE", "LAZY", "DOG"
        };

        int row = 0;
        int col = 0;
        int maxCols = 20;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (col >= maxCols) {
                    row++;
                    col = 0;
                }
                editor.addCharacter(row, col, c, "Courier", 12, "black");
                col++;
            }
            // Add space between words
            if (col >= maxCols) {
                row++;
                col = 0;
            }
            editor.addCharacter(row, col, ' ', "Courier", 12, "black");
            col++;
        }

        editor.displayText();
        
        System.out.println("Character count: " + editor.getCharacterCount());
        CharacterFactory.printStatistics();
        
        // Show memory savings
        int totalRequests = CharacterFactory.getTotalCharactersCreated() + CharacterFactory.getTotalCharactersReused();
        double memorySaved = (double) CharacterFactory.getTotalCharactersReused() / totalRequests * 100;
        System.out.printf("Memory saved through flyweight pattern: %.1f%%%n", memorySaved);
    }
} 
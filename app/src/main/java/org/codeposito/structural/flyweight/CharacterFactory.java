package org.codeposito.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * CharacterFactory is the Flyweight Factory that manages and shares Character objects.
 * It ensures that identical characters are reused rather than creating new instances.
 */
public class CharacterFactory {
    private static final Map<String, Character> characterCache = new HashMap<>();
    private static int totalCharactersCreated = 0;
    private static int totalCharactersReused = 0;

    /**
     * Gets or creates a Character object based on the provided parameters.
     * If a character with the same properties already exists, it returns the cached instance.
     * 
     * @param value the character value
     * @param font the font name
     * @param size the font size
     * @param color the font color
     * @return a Character object (either new or cached)
     */
    public static Character getCharacter(char value, String font, int size, String color) {
        String key = generateKey(value, font, size, color);
        
        if (characterCache.containsKey(key)) {
            totalCharactersReused++;
            System.out.printf("Reusing existing character: '%c' with font: %s, size: %d, color: %s%n",
                            value, font, size, color);
            return characterCache.get(key);
        } else {
            Character newCharacter = new Character(value, font, size, color);
            characterCache.put(key, newCharacter);
            totalCharactersCreated++;
            System.out.printf("Creating new character: '%c' with font: %s, size: %d, color: %s%n",
                            value, font, size, color);
            return newCharacter;
        }
    }

    /**
     * Generates a unique key for character caching based on character properties.
     */
    private static String generateKey(char value, String font, int size, String color) {
        return value + "|" + font + "|" + size + "|" + color;
    }

    /**
     * Gets the total number of characters created.
     */
    public static int getTotalCharactersCreated() {
        return totalCharactersCreated;
    }

    /**
     * Gets the total number of characters reused from cache.
     */
    public static int getTotalCharactersReused() {
        return totalCharactersReused;
    }

    /**
     * Gets the current cache size.
     */
    public static int getCacheSize() {
        return characterCache.size();
    }

    /**
     * Clears the character cache and resets statistics.
     */
    public static void clearCache() {
        characterCache.clear();
        totalCharactersCreated = 0;
        totalCharactersReused = 0;
        System.out.println("Character cache cleared.");
    }

    /**
     * Prints cache statistics.
     */
    public static void printStatistics() {
        System.out.println("\n=== Character Factory Statistics ===");
        System.out.println("Total characters created: " + totalCharactersCreated);
        System.out.println("Total characters reused: " + totalCharactersReused);
        System.out.println("Current cache size: " + getCacheSize());
        System.out.println("Memory saved: " + (totalCharactersReused * 100 / (totalCharactersCreated + totalCharactersReused)) + "%");
        System.out.println("=====================================\n");
    }
} 
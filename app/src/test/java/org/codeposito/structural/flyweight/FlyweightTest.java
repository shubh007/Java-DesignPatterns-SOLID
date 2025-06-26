package org.codeposito.structural.flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive tests for the Flyweight design pattern implementation.
 */
class FlyweightTest {

    private TextEditor editor;
    private CharacterFactory factory;

    @BeforeEach
    void setUp() {
        editor = new TextEditor(10, 20);
        CharacterFactory.clearCache();
    }

    @Test
    @DisplayName("Character creation and retrieval")
    void testCharacterCreationAndRetrieval() {
        // Create characters
        Character char1 = CharacterFactory.getCharacter('A', "Arial", 12, "black");
        Character char2 = CharacterFactory.getCharacter('A', "Arial", 12, "black");
        Character char3 = CharacterFactory.getCharacter('B', "Arial", 12, "black");

        // Test that identical characters are the same object (flyweight)
        assertSame(char1, char2);
        
        // Test that different characters are different objects
        assertNotSame(char1, char3);
        
        // Test character properties
        assertEquals('A', char1.getValue());
        assertEquals("Arial", char1.getFont());
        assertEquals(12, char1.getSize());
        assertEquals("black", char1.getColor());
    }

    @Test
    @DisplayName("Character context creation")
    void testCharacterContextCreation() {
        Character character = CharacterFactory.getCharacter('X', "Times", 14, "red");
        CharacterContext context = new CharacterContext(5, 10, character);

        assertEquals(5, context.getRow());
        assertEquals(10, context.getColumn());
        assertSame(character, context.getCharacter());
    }

    @Test
    @DisplayName("Text editor character addition")
    void testTextEditorCharacterAddition() {
        editor.addCharacter(0, 0, 'H', "Arial", 16, "blue");
        editor.addCharacter(0, 1, 'i', "Arial", 16, "blue");

        assertEquals(2, editor.getCharacterCount());
        
        // Test that characters are reused (flyweight pattern)
        editor.addCharacter(1, 0, 'H', "Arial", 16, "blue"); // Should reuse existing 'H'
        assertEquals(3, editor.getCharacterCount());
        assertEquals(2, CharacterFactory.getTotalCharactersCreated()); // Only 2 unique characters
        assertEquals(1, CharacterFactory.getTotalCharactersReused()); // 1 reused
    }

    @Test
    @DisplayName("Text editor bounds checking")
    void testTextEditorBoundsChecking() {
        // Test valid positions
        editor.addCharacter(0, 0, 'A', "Arial", 12, "black");
        editor.addCharacter(9, 19, 'Z', "Arial", 12, "black"); // Max valid position
        
        // Test invalid positions
        editor.addCharacter(-1, 0, 'X', "Arial", 12, "black"); // Invalid row
        editor.addCharacter(0, -1, 'X', "Arial", 12, "black"); // Invalid column
        editor.addCharacter(10, 0, 'X', "Arial", 12, "black"); // Row out of bounds
        editor.addCharacter(0, 20, 'X', "Arial", 12, "black"); // Column out of bounds

        // Should only have 2 valid characters
        assertEquals(2, editor.getCharacterCount());
    }

    @Test
    @DisplayName("Character factory statistics")
    void testCharacterFactoryStatistics() {
        // Create some characters
        CharacterFactory.getCharacter('A', "Arial", 12, "black");
        CharacterFactory.getCharacter('A', "Arial", 12, "black"); // Reused
        CharacterFactory.getCharacter('B', "Arial", 12, "black");
        CharacterFactory.getCharacter('A', "Arial", 12, "black"); // Reused again

        assertEquals(2, CharacterFactory.getTotalCharactersCreated());
        assertEquals(2, CharacterFactory.getTotalCharactersReused());
        assertEquals(2, CharacterFactory.getCacheSize());
    }

    @Test
    @DisplayName("Character factory cache clearing")
    void testCharacterFactoryCacheClearing() {
        // Create some characters
        CharacterFactory.getCharacter('A', "Arial", 12, "black");
        CharacterFactory.getCharacter('B', "Arial", 12, "black");

        assertEquals(2, CharacterFactory.getCacheSize());
        assertEquals(2, CharacterFactory.getTotalCharactersCreated());

        // Clear cache
        CharacterFactory.clearCache();

        assertEquals(0, CharacterFactory.getCacheSize());
        assertEquals(0, CharacterFactory.getTotalCharactersCreated());
        assertEquals(0, CharacterFactory.getTotalCharactersReused());
    }

    @Test
    @DisplayName("Text editor clearing")
    void testTextEditorClearing() {
        editor.addCharacter(0, 0, 'A', "Arial", 12, "black");
        editor.addCharacter(0, 1, 'B', "Arial", 12, "black");

        assertEquals(2, editor.getCharacterCount());

        editor.clear();

        assertEquals(0, editor.getCharacterCount());
        assertTrue(editor.getCharacters().isEmpty());
    }

    @Test
    @DisplayName("Character equality and hashCode")
    void testCharacterEqualityAndHashCode() {
        Character char1 = new Character('A', "Arial", 12, "black");
        Character char2 = new Character('A', "Arial", 12, "black");
        Character char3 = new Character('A', "Times", 12, "black");
        Character char4 = new Character('B', "Arial", 12, "black");

        // Test equality
        assertEquals(char1, char2);
        assertNotEquals(char1, char3);
        assertNotEquals(char1, char4);

        // Test hashCode consistency
        assertEquals(char1.hashCode(), char2.hashCode());
        assertNotEquals(char1.hashCode(), char3.hashCode());
        assertNotEquals(char1.hashCode(), char4.hashCode());
    }

    @Test
    @DisplayName("Character context toString")
    void testCharacterContextToString() {
        Character character = new Character('X', "Courier", 14, "green");
        CharacterContext context = new CharacterContext(3, 7, character);

        String expected = "CharacterContext{row=3, column=7, character=Character{value='X', font='Courier', size=14, color='green'}}";
        assertEquals(expected, context.toString());
    }

    @Test
    @DisplayName("Character toString")
    void testCharacterToString() {
        Character character = new Character('Z', "Verdana", 18, "purple");
        String expected = "Character{value='Z', font='Verdana', size=18, color='purple'}";
        assertEquals(expected, character.toString());
    }

    @Test
    @DisplayName("Memory efficiency with repeated characters")
    void testMemoryEfficiencyWithRepeatedCharacters() {
        // Add many repeated characters
        for (int i = 0; i < 100; i++) {
            editor.addCharacter(i / 10, i % 10, 'A', "Arial", 12, "black");
        }

        // Should have 100 contexts but only 1 unique character
        assertEquals(100, editor.getCharacterCount());
        assertEquals(1, CharacterFactory.getTotalCharactersCreated());
        assertEquals(99, CharacterFactory.getTotalCharactersReused());
        assertEquals(1, CharacterFactory.getCacheSize());
    }

    @Test
    @DisplayName("Different character styles create different objects")
    void testDifferentCharacterStylesCreateDifferentObjects() {
        Character char1 = CharacterFactory.getCharacter('A', "Arial", 12, "black");
        Character char2 = CharacterFactory.getCharacter('A', "Times", 12, "black");
        Character char3 = CharacterFactory.getCharacter('A', "Arial", 14, "black");
        Character char4 = CharacterFactory.getCharacter('A', "Arial", 12, "red");

        // All should be different objects
        assertNotSame(char1, char2);
        assertNotSame(char1, char3);
        assertNotSame(char1, char4);
        assertNotSame(char2, char3);
        assertNotSame(char2, char4);
        assertNotSame(char3, char4);

        assertEquals(4, CharacterFactory.getTotalCharactersCreated());
        assertEquals(0, CharacterFactory.getTotalCharactersReused());
    }
} 
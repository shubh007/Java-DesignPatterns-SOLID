package org.codeposito.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * TextEditor demonstrates the use of the Flyweight pattern.
 * It manages character contexts efficiently by reusing shared character objects.
 */
public class TextEditor {
    private final List<CharacterContext> characters;
    private final int maxRows;
    private final int maxColumns;

    public TextEditor(int maxRows, int maxColumns) {
        this.characters = new ArrayList<>();
        this.maxRows = maxRows;
        this.maxColumns = maxColumns;
    }

    /**
     * Adds a character to the text editor at the specified position.
     * Uses the flyweight pattern to reuse character objects when possible.
     */
    public void addCharacter(int row, int column, char value, String font, int size, String color) {
        if (row < 0 || row >= maxRows || column < 0 || column >= maxColumns) {
            System.out.printf("Position (%d, %d) is out of bounds. Max: (%d, %d)%n", 
                            row, column, maxRows - 1, maxColumns - 1);
            return;
        }

        // Get or create character using the flyweight factory
        Character character = CharacterFactory.getCharacter(value, font, size, color);
        
        // Create context with extrinsic state
        CharacterContext context = new CharacterContext(row, column, character);
        characters.add(context);
        
        System.out.printf("Added character '%c' at position (%d, %d)%n", value, row, column);
    }

    /**
     * Displays all characters in the text editor.
     */
    public void displayText() {
        System.out.println("\n=== Text Editor Content ===");
        if (characters.isEmpty()) {
            System.out.println("Text editor is empty.");
            return;
        }

        // Sort characters by row and column for proper display
        characters.sort((c1, c2) -> {
            if (c1.getRow() != c2.getRow()) {
                return Integer.compare(c1.getRow(), c2.getRow());
            }
            return Integer.compare(c1.getColumn(), c2.getColumn());
        });

        int currentRow = -1;
        for (CharacterContext context : characters) {
            if (context.getRow() != currentRow) {
                if (currentRow != -1) {
                    System.out.println(); // New line for new row
                }
                currentRow = context.getRow();
                System.out.printf("Row %d: ", currentRow);
            }
            System.out.print(context.getCharacter().getValue());
        }
        System.out.println("\n===========================\n");
    }

    /**
     * Displays detailed information about all character contexts.
     */
    public void displayDetailedInfo() {
        System.out.println("\n=== Detailed Character Information ===");
        if (characters.isEmpty()) {
            System.out.println("No characters to display.");
            return;
        }

        characters.sort((c1, c2) -> {
            if (c1.getRow() != c2.getRow()) {
                return Integer.compare(c1.getRow(), c2.getRow());
            }
            return Integer.compare(c1.getColumn(), c2.getColumn());
        });

        for (CharacterContext context : characters) {
            context.display();
        }
        System.out.println("=====================================\n");
    }

    /**
     * Gets the total number of character contexts.
     */
    public int getCharacterCount() {
        return characters.size();
    }

    /**
     * Clears all characters from the text editor.
     */
    public void clear() {
        characters.clear();
        System.out.println("Text editor cleared.");
    }

    /**
     * Gets the maximum number of rows.
     */
    public int getMaxRows() {
        return maxRows;
    }

    /**
     * Gets the maximum number of columns.
     */
    public int getMaxColumns() {
        return maxColumns;
    }

    /**
     * Gets all character contexts.
     */
    public List<CharacterContext> getCharacters() {
        return new ArrayList<>(characters);
    }
} 
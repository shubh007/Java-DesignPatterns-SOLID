package org.codeposito.structural.flyweight;

/**
 * CharacterContext class represents the extrinsic state (unique state) in the Flyweight pattern.
 * This class contains the data that varies between different contexts.
 */
public class CharacterContext {
    private final int row;
    private final int column;
    private final Character character;

    public CharacterContext(int row, int column, Character character) {
        this.row = row;
        this.column = column;
        this.character = character;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Character getCharacter() {
        return character;
    }

    public void display() {
        System.out.printf("Displaying '%c' at position (%d, %d) with font: %s, size: %d, color: %s%n",
                         character.getValue(), row, column, character.getFont(), 
                         character.getSize(), character.getColor());
    }

    @Override
    public String toString() {
        return String.format("CharacterContext{row=%d, column=%d, character=%s}", 
                           row, column, character);
    }
} 
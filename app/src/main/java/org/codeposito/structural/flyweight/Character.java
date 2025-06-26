package org.codeposito.structural.flyweight;

/**
 * Character class represents the intrinsic state (shared state) in the Flyweight pattern.
 * This class contains the data that is shared across multiple contexts.
 */
public class Character {
    private final char value;
    private final String font;
    private final int size;
    private final String color;

    public Character(char value, String font, int size, String color) {
        this.value = value;
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public char getValue() {
        return value;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("Character{value='%c', font='%s', size=%d, color='%s'}", 
                           value, font, size, color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Character character = (Character) obj;
        return value == character.value && 
               size == character.size && 
               font.equals(character.font) && 
               color.equals(character.color);
    }

    @Override
    public int hashCode() {
        int result = (int) value;
        result = 31 * result + font.hashCode();
        result = 31 * result + size;
        result = 31 * result + color.hashCode();
        return result;
    }
} 
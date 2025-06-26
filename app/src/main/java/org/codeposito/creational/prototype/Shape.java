package org.codeposito.creational.prototype;

import java.util.Objects;

/**
 * Abstract Shape class implementing prototype pattern with copy constructors
 * Demonstrates prototype pattern with inheritance hierarchy
 */
public abstract class Shape {
    protected String color;
    protected int x;
    protected int y;

    public Shape(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor for Shape
     * @param target the Shape to copy from
     */
    public Shape(Shape target) {
        if (target != null) {
            this.color = target.color;
            this.x = target.x;
            this.y = target.y;
        }
    }

    // Getters
    public String getColor() { return color; }
    public int getX() { return x; }
    public int getY() { return y; }

    // Setters
    public void setColor(String color) { this.color = color; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    /**
     * Abstract method for drawing the shape
     */
    public abstract void draw();

    /**
     * Abstract method for calculating area
     */
    public abstract double getArea();

    /**
     * Abstract clone method that creates a copy of the shape
     * Subclasses should override this to use their copy constructors
     */
    public abstract Shape clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Shape)) return false;
        Shape shape2 = (Shape) object2;
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
} 
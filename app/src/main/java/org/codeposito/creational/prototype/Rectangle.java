package org.codeposito.creational.prototype;

/**
 * Rectangle class extending Shape
 * Demonstrates prototype pattern with concrete shape implementation using copy constructors
 */
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, int x, int y, double width, double height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * Copy constructor for Rectangle
     * @param target the Rectangle to copy from
     */
    public Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
        }
    }

    // Getters and setters for width and height
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle: " + this);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    /**
     * Clone method that creates a copy of the rectangle using copy constructor
     */
    @Override
    public Rectangle clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) return false;
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
} 
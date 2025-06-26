package org.codeposito.creational.prototype;

/**
 * Circle class extending Shape
 * Demonstrates prototype pattern with concrete shape implementation using copy constructors
 */
public class Circle extends Shape {
    private double radius;

    public Circle(String color, int x, int y, double radius) {
        super(color, x, y);
        this.radius = radius;
    }

    /**
     * Copy constructor for Circle
     * @param target the Circle to copy from
     */
    public Circle(Circle target) {
        super(target);
        if (target != null) {
            this.radius = target.radius;
        }
    }

    // Getter and setter for radius
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    @Override
    public void draw() {
        System.out.println("Drawing Circle: " + this);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Clone method that creates a copy of the circle using copy constructor
     */
    @Override
    public Circle clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !super.equals(object2)) return false;
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
} 
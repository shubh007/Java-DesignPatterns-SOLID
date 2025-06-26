package org.codeposito.structural.bridge;

/**
 * Concrete implementation of Shape representing a circle.
 * This demonstrates the Bridge pattern by combining the Shape abstraction
 * with the DrawingAPI implementation.
 */
public class Circle extends Shape {
    
    private int x, y, radius;
    
    /**
     * Constructor for Circle shape.
     * 
     * @param x the x-coordinate of the circle center
     * @param y the y-coordinate of the circle center
     * @param radius the radius of the circle
     * @param drawingAPI the drawing API implementation to use
     */
    public Circle(int x, int y, int radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing " + getInfo());
        drawingAPI.drawCircle(x, y, radius);
    }
    
    @Override
    public String getShapeName() {
        return "Circle";
    }
    
    /**
     * Get the x-coordinate of the circle center.
     * 
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }
    
    /**
     * Get the y-coordinate of the circle center.
     * 
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }
    
    /**
     * Get the radius of the circle.
     * 
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }
} 
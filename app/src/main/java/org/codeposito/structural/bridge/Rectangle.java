package org.codeposito.structural.bridge;

/**
 * Concrete implementation of Shape representing a rectangle.
 * This demonstrates the Bridge pattern by combining the Shape abstraction
 * with the DrawingAPI implementation.
 */
public class Rectangle extends Shape {
    
    private int x, y, width, height;
    
    /**
     * Constructor for Rectangle shape.
     * 
     * @param x the x-coordinate of the top-left corner
     * @param y the y-coordinate of the top-left corner
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param drawingAPI the drawing API implementation to use
     */
    public Rectangle(int x, int y, int width, int height, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing " + getInfo());
        drawingAPI.drawRectangle(x, y, width, height);
    }
    
    @Override
    public String getShapeName() {
        return "Rectangle";
    }
    
    /**
     * Get the x-coordinate of the top-left corner.
     * 
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }
    
    /**
     * Get the y-coordinate of the top-left corner.
     * 
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }
    
    /**
     * Get the width of the rectangle.
     * 
     * @return the width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Get the height of the rectangle.
     * 
     * @return the height
     */
    public int getHeight() {
        return height;
    }
} 
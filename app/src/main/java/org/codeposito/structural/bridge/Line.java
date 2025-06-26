package org.codeposito.structural.bridge;

/**
 * Concrete implementation of Shape representing a line.
 * This demonstrates the Bridge pattern by combining the Shape abstraction
 * with the DrawingAPI implementation.
 */
public class Line extends Shape {
    
    private int x1, y1, x2, y2;
    
    /**
     * Constructor for Line shape.
     * 
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the ending point
     * @param y2 the y-coordinate of the ending point
     * @param drawingAPI the drawing API implementation to use
     */
    public Line(int x1, int y1, int x2, int y2, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing " + getInfo());
        drawingAPI.drawLine(x1, y1, x2, y2);
    }
    
    @Override
    public String getShapeName() {
        return "Line";
    }
    
    /**
     * Get the x-coordinate of the starting point.
     * 
     * @return the x-coordinate of the starting point
     */
    public int getX1() {
        return x1;
    }
    
    /**
     * Get the y-coordinate of the starting point.
     * 
     * @return the y-coordinate of the starting point
     */
    public int getY1() {
        return y1;
    }
    
    /**
     * Get the x-coordinate of the ending point.
     * 
     * @return the x-coordinate of the ending point
     */
    public int getX2() {
        return x2;
    }
    
    /**
     * Get the y-coordinate of the ending point.
     * 
     * @return the y-coordinate of the ending point
     */
    public int getY2() {
        return y2;
    }
} 
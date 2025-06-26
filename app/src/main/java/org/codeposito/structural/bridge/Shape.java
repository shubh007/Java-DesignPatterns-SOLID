package org.codeposito.structural.bridge;

/**
 * Abstract class representing a shape.
 * This is the abstraction side of the Bridge pattern.
 * It holds a reference to the DrawingAPI implementation.
 */
public abstract class Shape {
    
    protected DrawingAPI drawingAPI;
    
    /**
     * Constructor that takes a DrawingAPI implementation.
     * 
     * @param drawingAPI the drawing API implementation to use
     */
    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }
    
    /**
     * Abstract method that subclasses must implement to draw the shape.
     */
    public abstract void draw();
    
    /**
     * Get the name of the shape.
     * 
     * @return the name of the shape
     */
    public abstract String getShapeName();
    
    /**
     * Get information about the shape and its rendering API.
     * 
     * @return information about the shape and API
     */
    public String getInfo() {
        return getShapeName() + " using " + drawingAPI.getAPIName() + " API";
    }
} 
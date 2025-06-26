package org.codeposito.structural.bridge;

/**
 * Implementation interface for the Bridge pattern.
 * This defines the operations that different drawing engines can implement.
 */
public interface DrawingAPI {
    
    /**
     * Draw a circle at the specified coordinates with the given radius.
     * 
     * @param x the x-coordinate of the circle center
     * @param y the y-coordinate of the circle center
     * @param radius the radius of the circle
     */
    void drawCircle(int x, int y, int radius);
    
    /**
     * Draw a rectangle with the specified coordinates and dimensions.
     * 
     * @param x the x-coordinate of the top-left corner
     * @param y the y-coordinate of the top-left corner
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    void drawRectangle(int x, int y, int width, int height);
    
    /**
     * Draw a line from one point to another.
     * 
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the ending point
     * @param y2 the y-coordinate of the ending point
     */
    void drawLine(int x1, int y1, int x2, int y2);
    
    /**
     * Get the name of the drawing API implementation.
     * 
     * @return the name of the drawing API
     */
    String getAPIName();
} 
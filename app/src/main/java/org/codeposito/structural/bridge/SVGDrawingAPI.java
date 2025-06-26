package org.codeposito.structural.bridge;

/**
 * Concrete implementation of DrawingAPI using SVG.
 * This represents one side of the bridge - the implementation.
 */
public class SVGDrawingAPI implements DrawingAPI {
    
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("SVG: Drawing circle at (" + x + ", " + y + ") with radius " + radius);
        System.out.println("  - Generating SVG <circle> element");
        System.out.println("  - Vector-based graphics");
        System.out.println("  - Scalable without quality loss");
        System.out.println("  - XML output: <circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"" + radius + "\"/>");
    }
    
    @Override
    public void drawRectangle(int x, int y, int width, int height) {
        System.out.println("SVG: Drawing rectangle at (" + x + ", " + y + ") with size " + width + "x" + height);
        System.out.println("  - Generating SVG <rect> element");
        System.out.println("  - Vector-based graphics");
        System.out.println("  - Scalable without quality loss");
        System.out.println("  - XML output: <rect x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\"/>");
    }
    
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        System.out.println("SVG: Drawing line from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
        System.out.println("  - Generating SVG <line> element");
        System.out.println("  - Vector-based graphics");
        System.out.println("  - Scalable without quality loss");
        System.out.println("  - XML output: <line x1=\"" + x1 + "\" y1=\"" + y1 + "\" x2=\"" + x2 + "\" y2=\"" + y2 + "\"/>");
    }
    
    @Override
    public String getAPIName() {
        return "SVG";
    }
} 
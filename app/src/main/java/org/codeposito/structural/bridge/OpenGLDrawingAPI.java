package org.codeposito.structural.bridge;

/**
 * Concrete implementation of DrawingAPI using OpenGL.
 * This represents one side of the bridge - the implementation.
 */
public class OpenGLDrawingAPI implements DrawingAPI {
    
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("OpenGL: Drawing circle at (" + x + ", " + y + ") with radius " + radius);
        System.out.println("  - Using OpenGL primitives and shaders");
        System.out.println("  - Hardware accelerated rendering");
        System.out.println("  - High performance graphics");
    }
    
    @Override
    public void drawRectangle(int x, int y, int width, int height) {
        System.out.println("OpenGL: Drawing rectangle at (" + x + ", " + y + ") with size " + width + "x" + height);
        System.out.println("  - Using OpenGL vertex buffers");
        System.out.println("  - GPU-accelerated rendering");
        System.out.println("  - Real-time graphics processing");
    }
    
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        System.out.println("OpenGL: Drawing line from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
        System.out.println("  - Using OpenGL line primitives");
        System.out.println("  - Anti-aliasing enabled");
        System.out.println("  - Smooth line rendering");
    }
    
    @Override
    public String getAPIName() {
        return "OpenGL";
    }
} 
package org.codeposito.structural.bridge;

/**
 * Client class that demonstrates the Bridge pattern.
 * Shows how the same shapes can be drawn using different rendering APIs.
 */
public class BridgeClient {
    
    public static void main(String[] args) {
        System.out.println("=== Bridge Pattern Demo ===\n");
        
        // Create different drawing API implementations
        DrawingAPI openGLAPI = new OpenGLDrawingAPI();
        DrawingAPI svgAPI = new SVGDrawingAPI();
        
        System.out.println("1. Drawing shapes using OpenGL API:");
        System.out.println("===================================");
        
        // Create shapes with OpenGL API
        Shape circleOpenGL = new Circle(10, 10, 20, openGLAPI);
        Shape rectangleOpenGL = new Rectangle(20, 20, 15, 10, openGLAPI);
        Shape lineOpenGL = new Line(0, 0, 100, 100, openGLAPI);
        
        // Draw shapes using OpenGL
        circleOpenGL.draw();
        System.out.println();
        rectangleOpenGL.draw();
        System.out.println();
        lineOpenGL.draw();
        
        System.out.println("\n2. Drawing the same shapes using SVG API:");
        System.out.println("==========================================");
        
        // Create the same shapes with SVG API
        Shape circleSVG = new Circle(10, 10, 20, svgAPI);
        Shape rectangleSVG = new Rectangle(20, 20, 15, 10, svgAPI);
        Shape lineSVG = new Line(0, 0, 100, 100, svgAPI);
        
        // Draw shapes using SVG
        circleSVG.draw();
        System.out.println();
        rectangleSVG.draw();
        System.out.println();
        lineSVG.draw();
        
        System.out.println("\n3. Bridge Pattern Benefits:");
        System.out.println("===========================");
        System.out.println("✓ Same shapes can be rendered with different APIs");
        System.out.println("✓ New rendering APIs can be added without changing shapes");
        System.out.println("✓ New shapes can be added without changing rendering APIs");
        System.out.println("✓ Abstraction and implementation are decoupled");
        System.out.println("✓ Both can vary independently");
        
        System.out.println("\n4. Shape Information:");
        System.out.println("=====================");
        System.out.println(circleOpenGL.getInfo());
        System.out.println(circleSVG.getInfo());
        System.out.println(rectangleOpenGL.getInfo());
        System.out.println(rectangleSVG.getInfo());
        System.out.println(lineOpenGL.getInfo());
        System.out.println(lineSVG.getInfo());
    }
} 
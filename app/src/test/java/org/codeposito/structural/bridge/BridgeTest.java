package org.codeposito.structural.bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Bridge pattern implementation.
 */
public class BridgeTest {
    
    private DrawingAPI openGLAPI;
    private DrawingAPI svgAPI;
    
    @BeforeEach
    void setUp() {
        openGLAPI = new OpenGLDrawingAPI();
        svgAPI = new SVGDrawingAPI();
    }
    
    @Test
    void testOpenGLDrawingAPI() {
        assertEquals("OpenGL", openGLAPI.getAPIName());
        
        // Test that methods can be called without throwing exceptions
        assertDoesNotThrow(() -> openGLAPI.drawCircle(10, 20, 30));
        assertDoesNotThrow(() -> openGLAPI.drawRectangle(10, 20, 30, 40));
        assertDoesNotThrow(() -> openGLAPI.drawLine(10, 20, 30, 40));
    }
    
    @Test
    void testSVGDrawingAPI() {
        assertEquals("SVG", svgAPI.getAPIName());
        
        // Test that methods can be called without throwing exceptions
        assertDoesNotThrow(() -> svgAPI.drawCircle(10, 20, 30));
        assertDoesNotThrow(() -> svgAPI.drawRectangle(10, 20, 30, 40));
        assertDoesNotThrow(() -> svgAPI.drawLine(10, 20, 30, 40));
    }
    
    @Test
    void testCircleShape() {
        Circle circleOpenGL = new Circle(10, 20, 30, openGLAPI);
        Circle circleSVG = new Circle(15, 25, 35, svgAPI);
        
        assertEquals("Circle", circleOpenGL.getShapeName());
        assertEquals("Circle", circleSVG.getShapeName());
        
        assertEquals("Circle using OpenGL API", circleOpenGL.getInfo());
        assertEquals("Circle using SVG API", circleSVG.getInfo());
        
        assertEquals(10, circleOpenGL.getX());
        assertEquals(20, circleOpenGL.getY());
        assertEquals(30, circleOpenGL.getRadius());
        
        assertEquals(15, circleSVG.getX());
        assertEquals(25, circleSVG.getY());
        assertEquals(35, circleSVG.getRadius());
        
        // Test that draw method can be called without throwing exceptions
        assertDoesNotThrow(() -> circleOpenGL.draw());
        assertDoesNotThrow(() -> circleSVG.draw());
    }
    
    @Test
    void testRectangleShape() {
        Rectangle rectOpenGL = new Rectangle(10, 20, 30, 40, openGLAPI);
        Rectangle rectSVG = new Rectangle(15, 25, 35, 45, svgAPI);
        
        assertEquals("Rectangle", rectOpenGL.getShapeName());
        assertEquals("Rectangle", rectSVG.getShapeName());
        
        assertEquals("Rectangle using OpenGL API", rectOpenGL.getInfo());
        assertEquals("Rectangle using SVG API", rectSVG.getInfo());
        
        assertEquals(10, rectOpenGL.getX());
        assertEquals(20, rectOpenGL.getY());
        assertEquals(30, rectOpenGL.getWidth());
        assertEquals(40, rectOpenGL.getHeight());
        
        assertEquals(15, rectSVG.getX());
        assertEquals(25, rectSVG.getY());
        assertEquals(35, rectSVG.getWidth());
        assertEquals(45, rectSVG.getHeight());
        
        // Test that draw method can be called without throwing exceptions
        assertDoesNotThrow(() -> rectOpenGL.draw());
        assertDoesNotThrow(() -> rectSVG.draw());
    }
    
    @Test
    void testLineShape() {
        Line lineOpenGL = new Line(10, 20, 30, 40, openGLAPI);
        Line lineSVG = new Line(15, 25, 35, 45, svgAPI);
        
        assertEquals("Line", lineOpenGL.getShapeName());
        assertEquals("Line", lineSVG.getShapeName());
        
        assertEquals("Line using OpenGL API", lineOpenGL.getInfo());
        assertEquals("Line using SVG API", lineSVG.getInfo());
        
        assertEquals(10, lineOpenGL.getX1());
        assertEquals(20, lineOpenGL.getY1());
        assertEquals(30, lineOpenGL.getX2());
        assertEquals(40, lineOpenGL.getY2());
        
        assertEquals(15, lineSVG.getX1());
        assertEquals(25, lineSVG.getY1());
        assertEquals(35, lineSVG.getX2());
        assertEquals(45, lineSVG.getY2());
        
        // Test that draw method can be called without throwing exceptions
        assertDoesNotThrow(() -> lineOpenGL.draw());
        assertDoesNotThrow(() -> lineSVG.draw());
    }
    
    @Test
    void testBridgePatternDecoupling() {
        // Test that the same shape can work with different APIs
        Circle circle1 = new Circle(10, 20, 30, openGLAPI);
        Circle circle2 = new Circle(10, 20, 30, svgAPI);
        
        // Same shape properties
        assertEquals(circle1.getX(), circle2.getX());
        assertEquals(circle1.getY(), circle2.getY());
        assertEquals(circle1.getRadius(), circle2.getRadius());
        assertEquals(circle1.getShapeName(), circle2.getShapeName());
        
        // Different API information
        assertNotEquals(circle1.getInfo(), circle2.getInfo());
        assertTrue(circle1.getInfo().contains("OpenGL"));
        assertTrue(circle2.getInfo().contains("SVG"));
    }
    
    @Test
    void testShapePolymorphism() {
        // Test that different shapes can work with the same API
        Shape[] shapes = {
            new Circle(10, 20, 30, openGLAPI),
            new Rectangle(10, 20, 30, 40, openGLAPI),
            new Line(10, 20, 30, 40, openGLAPI)
        };
        
        for (Shape shape : shapes) {
            assertNotNull(shape.getShapeName());
            assertTrue(shape.getInfo().contains("OpenGL"));
            assertDoesNotThrow(() -> shape.draw());
        }
    }
} 
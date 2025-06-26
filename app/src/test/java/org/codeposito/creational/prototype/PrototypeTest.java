package org.codeposito.creational.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Prototype pattern implementation
 */
public class PrototypeTest {

    private Document originalDocument;
    private Circle originalCircle;
    private Rectangle originalRectangle;

    @BeforeEach
    void setUp() {
        // Setup test documents
        originalDocument = new Document("Test Document", "Test content");
        originalDocument.addTag("test");
        originalDocument.addTag("prototype");
        originalDocument.getMetadata().setAuthor("Test Author");
        originalDocument.getMetadata().setVersion("1.0");

        // Setup test shapes
        originalCircle = new Circle("red", 10, 20, 15.0);
        originalRectangle = new Rectangle("blue", 30, 40, 25.0, 15.0);
    }

    @Test
    void testDocumentShallowClone() {
        Document cloned = originalDocument.clone();
        
        // Test that clone is not the same object
        assertNotSame(originalDocument, cloned);
        
        // Test that primitive fields are copied
        assertEquals(originalDocument.getTitle(), cloned.getTitle());
        assertEquals(originalDocument.getContent(), cloned.getContent());
        
        // Test that tags are copied (new list)
        assertNotSame(originalDocument.getTags(), cloned.getTags());
        assertEquals(originalDocument.getTags(), cloned.getTags());
        
        // Test that metadata is shared (shallow copy)
        assertSame(originalDocument.getMetadata(), cloned.getMetadata());
    }

    @Test
    void testDocumentDeepClone() {
        Document cloned = originalDocument.deepClone();
        
        // Test that clone is not the same object
        assertNotSame(originalDocument, cloned);
        
        // Test that primitive fields are copied
        assertEquals(originalDocument.getTitle(), cloned.getTitle());
        assertEquals(originalDocument.getContent(), cloned.getContent());
        
        // Test that tags are copied
        assertNotSame(originalDocument.getTags(), cloned.getTags());
        assertEquals(originalDocument.getTags(), cloned.getTags());
        
        // Test that metadata is independent (deep copy)
        assertNotSame(originalDocument.getMetadata(), cloned.getMetadata());
        assertEquals(originalDocument.getMetadata().getAuthor(), cloned.getMetadata().getAuthor());
    }

    @Test
    void testDocumentShallowCopyModification() {
        Document cloned = originalDocument.clone();
        
        // Modify cloned document
        cloned.setTitle("Modified Title");
        cloned.addTag("modified");
        cloned.getMetadata().setAuthor("Modified Author");
        
        // Original should be affected by metadata change (shallow copy)
        assertEquals("Modified Author", originalDocument.getMetadata().getAuthor());
        
        // Original should not be affected by other changes
        assertNotEquals("Modified Title", originalDocument.getTitle());
        assertFalse(originalDocument.getTags().contains("modified"));
    }

    @Test
    void testDocumentDeepCopyModification() {
        Document cloned = originalDocument.deepClone();
        
        // Modify cloned document
        cloned.setTitle("Modified Title");
        cloned.addTag("modified");
        cloned.getMetadata().setAuthor("Modified Author");
        
        // Original should not be affected by any changes (deep copy)
        assertNotEquals("Modified Author", originalDocument.getMetadata().getAuthor());
        assertNotEquals("Modified Title", originalDocument.getTitle());
        assertFalse(originalDocument.getTags().contains("modified"));
    }

    @Test
    void testCircleClone() {
        Circle cloned = originalCircle.clone();
        
        // Test that clone is not the same object
        assertNotSame(originalCircle, cloned);
        
        // Test that all fields are copied
        assertEquals(originalCircle.getColor(), cloned.getColor());
        assertEquals(originalCircle.getX(), cloned.getX());
        assertEquals(originalCircle.getY(), cloned.getY());
        assertEquals(originalCircle.getRadius(), cloned.getRadius());
    }

    @Test
    void testRectangleClone() {
        Rectangle cloned = originalRectangle.clone();
        
        // Test that clone is not the same object
        assertNotSame(originalRectangle, cloned);
        
        // Test that all fields are copied
        assertEquals(originalRectangle.getColor(), cloned.getColor());
        assertEquals(originalRectangle.getX(), cloned.getX());
        assertEquals(originalRectangle.getY(), cloned.getY());
        assertEquals(originalRectangle.getWidth(), cloned.getWidth());
        assertEquals(originalRectangle.getHeight(), cloned.getHeight());
    }

    @Test
    void testShapePolymorphicClone() {
        Shape[] shapes = {originalCircle, originalRectangle};
        
        for (Shape shape : shapes) {
            Shape cloned = shape.clone();
            
            // Test that clone is not the same object
            assertNotSame(shape, cloned);
            
            // Test that clone has same type
            assertEquals(shape.getClass(), cloned.getClass());
            
            // Test that basic fields are copied
            assertEquals(shape.getColor(), cloned.getColor());
            assertEquals(shape.getX(), cloned.getX());
            assertEquals(shape.getY(), cloned.getY());
        }
    }

    @Test
    void testShapeRegistry() {
        // Test that registry has default shapes
        assertTrue(ShapeRegistry.getAvailableShapes().contains("red-circle"));
        assertTrue(ShapeRegistry.getAvailableShapes().contains("blue-circle"));
        assertTrue(ShapeRegistry.getAvailableShapes().contains("green-rectangle"));
        assertTrue(ShapeRegistry.getAvailableShapes().contains("yellow-rectangle"));
        
        // Test getting shapes from registry
        Circle redCircle = (Circle) ShapeRegistry.getShape("red-circle");
        assertNotNull(redCircle);
        assertEquals("red", redCircle.getColor());
        
        Rectangle greenRect = (Rectangle) ShapeRegistry.getShape("green-rectangle");
        assertNotNull(greenRect);
        assertEquals("green", greenRect.getColor());
    }

    @Test
    void testShapeRegistryClone() {
        Circle original = (Circle) ShapeRegistry.getShape("red-circle");
        Circle cloned = (Circle) ShapeRegistry.getShape("red-circle");
        
        // Test that clones are different objects
        assertNotSame(original, cloned);
        
        // Test that they have same initial values
        assertEquals(original.getColor(), cloned.getColor());
        assertEquals(original.getX(), cloned.getX());
        assertEquals(original.getY(), cloned.getY());
        assertEquals(original.getRadius(), cloned.getRadius());
    }

    @Test
    void testShapeRegistryModification() {
        Circle original = (Circle) ShapeRegistry.getShape("red-circle");
        Circle cloned = (Circle) ShapeRegistry.getShape("red-circle");
        
        // Modify cloned shape
        cloned.setColor("purple");
        cloned.setX(100);
        cloned.setY(200);
        
        // Get another clone from registry
        Circle anotherClone = (Circle) ShapeRegistry.getShape("red-circle");
        
        // Test that registry prototype is not affected
        assertEquals("red", anotherClone.getColor());
        assertEquals(0, anotherClone.getX());
        assertEquals(0, anotherClone.getY());
    }

    @Test
    void testShapeRegistryRegistration() {
        int initialSize = ShapeRegistry.getRegistrySize();
        
        // Register new shape
        Circle customCircle = new Circle("orange", 0, 0, 25.0);
        ShapeRegistry.registerShape("custom-circle", customCircle);
        
        // Test that size increased
        assertEquals(initialSize + 1, ShapeRegistry.getRegistrySize());
        
        // Test that new shape is available
        assertTrue(ShapeRegistry.getAvailableShapes().contains("custom-circle"));
        
        // Test getting the new shape
        Circle retrieved = (Circle) ShapeRegistry.getShape("custom-circle");
        assertNotNull(retrieved);
        assertEquals("orange", retrieved.getColor());
        assertEquals(25.0, retrieved.getRadius());
    }

    @Test
    void testShapeRegistryInvalidKey() {
        // Test getting non-existent shape
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeRegistry.getShape("non-existent-shape");
        });
    }

    @Test
    void testShapeAreaCalculation() {
        Circle circle = new Circle("red", 0, 0, 5.0);
        Rectangle rectangle = new Rectangle("blue", 0, 0, 10.0, 5.0);
        
        // Test circle area (π * r²)
        assertEquals(Math.PI * 25.0, circle.getArea(), 0.001);
        
        // Test rectangle area (width * height)
        assertEquals(50.0, rectangle.getArea(), 0.001);
    }

    @Test
    void testDocumentMetadataClone() {
        DocumentMetadata original = new DocumentMetadata();
        original.setAuthor("Original Author");
        original.setVersion("2.0");
        
        DocumentMetadata cloned = original.clone();
        
        // Test that clone is not the same object
        assertNotSame(original, cloned);
        
        // Test that fields are copied
        assertEquals(original.getAuthor(), cloned.getAuthor());
        assertEquals(original.getVersion(), cloned.getVersion());
        assertEquals(original.isPublic(), cloned.isPublic());
    }
} 
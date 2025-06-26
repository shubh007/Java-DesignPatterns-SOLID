package org.codeposito.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * PrototypeClient class demonstrating various prototype pattern implementations
 * Shows shallow copy, deep copy, and registry pattern usage
 */
public class PrototypeClient {
    
    public static void main(String[] args) {
        System.out.println("=== Prototype Pattern Demo ===\n");
        
        // Demo 1: Document cloning (shallow vs deep copy)
        demonstrateDocumentCloning();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Demo 2: Shape cloning with inheritance
        demonstrateShapeCloning();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Demo 3: Prototype registry pattern
        demonstrateShapeRegistry();
    }
    
    /**
     * Demonstrates document cloning with shallow and deep copy
     */
    private static void demonstrateDocumentCloning() {
        System.out.println("1. Document Cloning Demo (Shallow vs Deep Copy)");
        System.out.println("-".repeat(40));
        
        // Create original document
        Document original = new Document("Original Document", "This is the original content");
        original.addTag("important");
        original.addTag("draft");
        original.getMetadata().setAuthor("John Doe");
        original.getMetadata().setVersion("1.0");
        
        System.out.println("Original Document: " + original);
        System.out.println("Original Metadata: " + original.getMetadata());
        
        // Shallow copy
        Document shallowCopy = original.clone();
        shallowCopy.setTitle("Shallow Copy Document");
        shallowCopy.addTag("shallow");
        
        // Deep copy
        Document deepCopy = original.deepClone();
        deepCopy.setTitle("Deep Copy Document");
        deepCopy.addTag("deep");
        deepCopy.getMetadata().setAuthor("Jane Smith");
        
        System.out.println("\nAfter cloning:");
        System.out.println("Original: " + original);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Deep Copy: " + deepCopy);
        
        // Demonstrate the difference between shallow and deep copy
        System.out.println("\nMetadata comparison:");
        System.out.println("Original metadata: " + original.getMetadata());
        System.out.println("Shallow copy metadata: " + shallowCopy.getMetadata());
        System.out.println("Deep copy metadata: " + deepCopy.getMetadata());
        
        System.out.println("\nNote: In shallow copy, metadata is shared. In deep copy, metadata is independent.");
    }
    
    /**
     * Demonstrates shape cloning with inheritance hierarchy
     */
    private static void demonstrateShapeCloning() {
        System.out.println("2. Shape Cloning Demo (Inheritance Hierarchy)");
        System.out.println("-".repeat(40));
        
        // Create original shapes
        Circle originalCircle = new Circle("red", 10, 20, 15.0);
        Rectangle originalRectangle = new Rectangle("blue", 30, 40, 25.0, 15.0);
        
        System.out.println("Original Circle: " + originalCircle);
        System.out.println("Original Rectangle: " + originalRectangle);
        
        // Clone shapes
        Circle clonedCircle = originalCircle.clone();
        Rectangle clonedRectangle = originalRectangle.clone();
        
        // Modify cloned shapes
        clonedCircle.setColor("green");
        clonedCircle.setX(50);
        clonedCircle.setY(60);
        clonedCircle.setRadius(20.0);
        
        clonedRectangle.setColor("yellow");
        clonedRectangle.setX(70);
        clonedRectangle.setY(80);
        clonedRectangle.setWidth(30.0);
        clonedRectangle.setHeight(20.0);
        
        System.out.println("\nAfter cloning and modification:");
        System.out.println("Original Circle: " + originalCircle);
        System.out.println("Cloned Circle: " + clonedCircle);
        System.out.println("Original Rectangle: " + originalRectangle);
        System.out.println("Cloned Rectangle: " + clonedRectangle);
        
        // Demonstrate polymorphic cloning
        List<Shape> shapes = new ArrayList<>();
        shapes.add(originalCircle);
        shapes.add(originalRectangle);
        
        System.out.println("\nPolymorphic cloning demo:");
        for (Shape shape : shapes) {
            Shape cloned = shape.clone();
            cloned.setColor("purple");
            System.out.println("Original: " + shape);
            System.out.println("Cloned: " + cloned);
            System.out.println("Area: " + cloned.getArea());
            cloned.draw();
            System.out.println();
        }
    }
    
    /**
     * Demonstrates prototype registry pattern
     */
    private static void demonstrateShapeRegistry() {
        System.out.println("3. Shape Registry Demo (Prototype Registry Pattern)");
        System.out.println("-".repeat(40));
        
        System.out.println("Available shapes in registry:");
        for (String key : ShapeRegistry.getAvailableShapes()) {
            System.out.println("- " + key);
        }
        
        System.out.println("\nCloning shapes from registry:");
        
        // Clone shapes from registry
        try {
            Circle redCircle = (Circle) ShapeRegistry.getShape("red-circle");
            redCircle.setX(100);
            redCircle.setY(100);
            
            Circle blueCircle = (Circle) ShapeRegistry.getShape("blue-circle");
            blueCircle.setX(200);
            blueCircle.setY(200);
            
            Rectangle greenRect = (Rectangle) ShapeRegistry.getShape("green-rectangle");
            greenRect.setX(300);
            greenRect.setY(300);
            
            Rectangle yellowRect = (Rectangle) ShapeRegistry.getShape("yellow-rectangle");
            yellowRect.setX(400);
            yellowRect.setY(400);
            
            System.out.println("Red Circle: " + redCircle);
            System.out.println("Blue Circle: " + blueCircle);
            System.out.println("Green Rectangle: " + greenRect);
            System.out.println("Yellow Rectangle: " + yellowRect);
            
            // Register a new custom shape
            Circle customCircle = new Circle("orange", 0, 0, 25.0);
            ShapeRegistry.registerShape("custom-orange-circle", customCircle);
            
            System.out.println("\nAfter registering custom shape:");
            Circle clonedCustom = (Circle) ShapeRegistry.getShape("custom-orange-circle");
            clonedCustom.setX(500);
            clonedCustom.setY(500);
            System.out.println("Custom Circle: " + clonedCustom);
            
            System.out.println("\nRegistry size: " + ShapeRegistry.getRegistrySize());
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
} 
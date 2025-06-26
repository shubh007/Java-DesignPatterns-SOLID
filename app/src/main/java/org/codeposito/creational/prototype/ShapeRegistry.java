package org.codeposito.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * ShapeRegistry class implementing prototype registry pattern
 * Manages a collection of prototype shapes and provides cloning functionality
 */
public class ShapeRegistry {
    private static final Map<String, Shape> shapePrototypes = new HashMap<>();

    /**
     * Initialize the registry with default shapes
     */
    static {
        // Register default prototypes
        shapePrototypes.put("red-circle", new Circle("red", 0, 0, 10.0));
        shapePrototypes.put("blue-circle", new Circle("blue", 0, 0, 15.0));
        shapePrototypes.put("green-rectangle", new Rectangle("green", 0, 0, 20.0, 10.0));
        shapePrototypes.put("yellow-rectangle", new Rectangle("yellow", 0, 0, 25.0, 15.0));
    }

    /**
     * Register a new shape prototype
     */
    public static void registerShape(String key, Shape shape) {
        shapePrototypes.put(key, shape);
    }

    /**
     * Get a clone of a shape by key
     */
    public static Shape getShape(String key) {
        Shape prototype = shapePrototypes.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("Shape with key '" + key + "' not found in registry");
        }
        return prototype.clone();
    }

    /**
     * Get all available shape keys
     */
    public static java.util.Set<String> getAvailableShapes() {
        return shapePrototypes.keySet();
    }

    /**
     * Remove a shape from the registry
     */
    public static void removeShape(String key) {
        shapePrototypes.remove(key);
    }

    /**
     * Clear all shapes from the registry
     */
    public static void clearRegistry() {
        shapePrototypes.clear();
    }

    /**
     * Get the number of registered shapes
     */
    public static int getRegistrySize() {
        return shapePrototypes.size();
    }
} 
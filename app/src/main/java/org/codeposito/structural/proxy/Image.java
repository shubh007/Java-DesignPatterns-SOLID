package org.codeposito.structural.proxy;

/**
 * Image - The Subject interface in the Proxy pattern
 * Defines the common interface for both RealImage and ImageProxy
 */
public interface Image {
    
    /**
     * Display the image
     * This method will be implemented by both RealImage and ImageProxy
     */
    void display();
    
    /**
     * Get the filename of the image
     * @return the filename
     */
    String getFilename();
    
    /**
     * Get the size of the image in bytes
     * @return the size in bytes
     */
    long getSize();
    
    /**
     * Get the image format (e.g., "JPEG", "PNG", "GIF")
     * @return the image format
     */
    String getFormat();
    
    /**
     * Check if the image is loaded in memory
     * @return true if loaded, false otherwise
     */
    boolean isLoaded();
} 
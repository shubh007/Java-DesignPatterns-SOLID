package org.codeposito.structural.proxy.virtual;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ImageGallery - Demonstrates the Proxy pattern in a real-world scenario
 * Manages a collection of images using proxies for efficient memory usage
 */
public class ImageGallery {
    
    private final List<Image> images;
    private final String name;
    
    /**
     * Constructor for ImageGallery
     * @param name the name of the gallery
     */
    public ImageGallery(String name) {
        this.name = name;
        this.images = new ArrayList<>();
    }
    
    /**
     * Add an image to the gallery using a proxy
     * @param filename the name of the image file
     * @param size the size of the image in bytes
     * @param format the format of the image
     */
    public void addImage(String filename, long size, String format) {
        Image proxy = new ImageProxy(filename, size, format);
        images.add(proxy);
        System.out.println("Added image to gallery: " + filename + " (Proxy created)");
    }
    
    /**
     * Display a specific image by filename
     * @param filename the name of the image to display
     */
    public void displayImage(String filename) {
        Image image = findImage(filename);
        if (image != null) {
            System.out.println("\n--- Displaying Image: " + filename + " ---");
            image.display();
        } else {
            System.out.println("Image not found: " + filename);
        }
    }
    
    /**
     * Display all images in the gallery
     */
    public void displayAllImages() {
        System.out.println("\n=== Displaying All Images in Gallery: " + name + " ===");
        for (int i = 0; i < images.size(); i++) {
            Image image = images.get(i);
            System.out.println("\n--- Image " + (i + 1) + ": " + image.getFilename() + " ---");
            image.display();
        }
    }
    
    /**
     * Show gallery information without loading images
     */
    public void showGalleryInfo() {
        System.out.println("\n=== Gallery Information: " + name + " ===");
        System.out.println("Total images: " + images.size());
        
        long totalSize = images.stream()
                .mapToLong(Image::getSize)
                .sum();
        
        System.out.println("Total size: " + formatSize(totalSize));
        System.out.println("Formats: " + getUniqueFormats());
        
        System.out.println("\nImage List:");
        for (int i = 0; i < images.size(); i++) {
            Image image = images.get(i);
            System.out.printf("%d. %s (%s, %s, Loaded: %s)%n", 
                i + 1, 
                image.getFilename(), 
                image.getFormat(), 
                formatSize(image.getSize()),
                image.isLoaded() ? "Yes" : "No");
        }
    }
    
    /**
     * Get memory usage statistics
     */
    public void showMemoryUsage() {
        System.out.println("\n=== Memory Usage Statistics ===");
        
        long loadedImages = images.stream()
                .filter(Image::isLoaded)
                .count();
        
        long totalSize = images.stream()
                .mapToLong(Image::getSize)
                .sum();
        
        long loadedSize = images.stream()
                .filter(Image::isLoaded)
                .mapToLong(Image::getSize)
                .sum();
        
        System.out.println("Total images: " + images.size());
        System.out.println("Loaded images: " + loadedImages);
        System.out.println("Unloaded images: " + (images.size() - loadedImages));
        System.out.println("Total size: " + formatSize(totalSize));
        System.out.println("Loaded size: " + formatSize(loadedSize));
        System.out.println("Memory saved: " + formatSize(totalSize - loadedSize));
        
        double memoryEfficiency = (double) (totalSize - loadedSize) / totalSize * 100;
        System.out.printf("Memory efficiency: %.1f%%%n", memoryEfficiency);
    }
    
    /**
     * Find an image by filename
     * @param filename the filename to search for
     * @return the image if found, null otherwise
     */
    private Image findImage(String filename) {
        return images.stream()
                .filter(img -> img.getFilename().equals(filename))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Get unique formats in the gallery
     * @return comma-separated list of unique formats
     */
    private String getUniqueFormats() {
        return images.stream()
                .map(Image::getFormat)
                .distinct()
                .collect(Collectors.joining(", "));
    }
    
    /**
     * Format file size in human-readable format
     * @param bytes the size in bytes
     * @return formatted size string
     */
    private String formatSize(long bytes) {
        if (bytes < 1024) {
            return bytes + " B";
        } else if (bytes < 1024 * 1024) {
            return String.format("%.1f KB", bytes / 1024.0);
        } else {
            return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
        }
    }
    
    /**
     * Get the gallery name
     * @return the gallery name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the number of images in the gallery
     * @return the number of images
     */
    public int getImageCount() {
        return images.size();
    }
} 
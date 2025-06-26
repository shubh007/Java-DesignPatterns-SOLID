package org.codeposito.structural.proxy.virtual;

/**
 * RealImage - The RealSubject in the Proxy pattern
 * Represents the actual image that is expensive to load and display
 */
public class RealImage implements Image {
    
    private final String filename;
    private final long size;
    private final String format;
    private boolean loaded;
    
    /**
     * Constructor for RealImage
     * @param filename the name of the image file
     * @param size the size of the image in bytes
     * @param format the format of the image (JPEG, PNG, GIF, etc.)
     */
    public RealImage(String filename, long size, String format) {
        this.filename = filename;
        this.size = size;
        this.format = format;
        this.loaded = false;
    }
    
    @Override
    public void display() {
        if (!loaded) {
            loadFromDisk();
        }
        System.out.println("Displaying image: " + filename + " (" + format + ", " + formatSize(size) + ")");
        System.out.println("Image content: [Simulated image data for " + filename + "]");
    }
    
    @Override
    public String getFilename() {
        return filename;
    }
    
    @Override
    public long getSize() {
        return size;
    }
    
    @Override
    public String getFormat() {
        return format;
    }
    
    @Override
    public boolean isLoaded() {
        return loaded;
    }
    
    /**
     * Load the image from disk (expensive operation)
     * This simulates the expensive loading process
     */
    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + filename + " (This is an expensive operation)");
        
        // Simulate loading time based on file size
        try {
            long loadTime = Math.max(100, size / 1000); // Simulate load time proportional to size
            Thread.sleep(loadTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Loading interrupted for: " + filename);
        }
        
        loaded = true;
        System.out.println("Image loaded successfully: " + filename);
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
} 
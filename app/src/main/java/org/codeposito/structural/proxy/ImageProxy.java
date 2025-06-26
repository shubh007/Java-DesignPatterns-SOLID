package org.codeposito.structural.proxy;

/**
 * ImageProxy - The Proxy in the Proxy pattern
 * Controls access to the RealImage and provides lazy loading
 */
public class ImageProxy implements Image {
    
    private final String filename;
    private final long size;
    private final String format;
    private RealImage realImage;
    
    /**
     * Constructor for ImageProxy
     * @param filename the name of the image file
     * @param size the size of the image in bytes
     * @param format the format of the image (JPEG, PNG, GIF, etc.)
     */
    public ImageProxy(String filename, long size, String format) {
        this.filename = filename;
        this.size = size;
        this.format = format;
        this.realImage = null; // Lazy initialization
    }
    
    @Override
    public void display() {
        if (realImage == null) {
            // Create the real image only when needed (lazy loading)
            System.out.println("Proxy: Creating real image for " + filename);
            realImage = new RealImage(filename, size, format);
        }
        
        // Delegate to the real image
        realImage.display();
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
        return realImage != null && realImage.isLoaded();
    }
    
    /**
     * Get the real image instance (for testing purposes)
     * @return the real image instance, or null if not yet created
     */
    public RealImage getRealImage() {
        return realImage;
    }
    
    /**
     * Check if the real image has been created
     * @return true if real image exists, false otherwise
     */
    public boolean isRealImageCreated() {
        return realImage != null;
    }
} 
package org.codeposito.structural.proxy.virtual;

/**
 * Proxy Client - demonstrates the Proxy pattern in action
 * This class shows how the proxy provides lazy loading and memory efficiency
 */
public class ProxyClient {
    
    public static void main(String[] args) {
        System.out.println("=== Proxy Pattern Demo ===\n");
        
        // Demonstrate basic proxy functionality
        demonstrateBasicProxy();
        
        // Demonstrate proxy in a real-world scenario
        demonstrateImageGallery();
        
        // Demonstrate memory efficiency
        demonstrateMemoryEfficiency();
        
        System.out.println("\n=== Proxy Pattern Demo Complete ===");
    }
    
    /**
     * Demonstrate basic proxy functionality
     */
    private static void demonstrateBasicProxy() {
        System.out.println("1. Basic Proxy Functionality:");
        System.out.println("-----------------------------");
        
        // Create a proxy for a large image
        Image imageProxy = new ImageProxy("vacation_photo.jpg", 2048576, "JPEG");
        
        System.out.println("Proxy created for: " + imageProxy.getFilename());
        System.out.println("Image size: " + formatSize(imageProxy.getSize()));
        System.out.println("Image format: " + imageProxy.getFormat());
        System.out.println("Is loaded: " + imageProxy.isLoaded());
        
        System.out.println("\nNow displaying the image (this will trigger loading):");
        imageProxy.display();
        
        System.out.println("Is loaded after display: " + imageProxy.isLoaded());
        
        System.out.println("\nDisplaying again (should be instant this time):");
        imageProxy.display();
    }
    
    /**
     * Demonstrate proxy in a real-world scenario
     */
    private static void demonstrateImageGallery() {
        System.out.println("\n2. Real-World Scenario - Image Gallery:");
        System.out.println("----------------------------------------");
        
        // Create an image gallery
        ImageGallery gallery = new ImageGallery("Nature Photography");
        
        // Add various images to the gallery
        gallery.addImage("mountain_landscape.jpg", 1536000, "JPEG");
        gallery.addImage("forest_path.png", 2048000, "PNG");
        gallery.addImage("sunset_over_lake.gif", 512000, "GIF");
        gallery.addImage("wildlife_photo.jpg", 3072000, "JPEG");
        gallery.addImage("flower_macro.png", 1024000, "PNG");
        
        // Show gallery information without loading images
        gallery.showGalleryInfo();
        
        // Display only specific images (lazy loading)
        System.out.println("\nDisplaying specific images:");
        gallery.displayImage("mountain_landscape.jpg");
        gallery.displayImage("forest_path.png");
        
        // Show memory usage after displaying some images
        gallery.showMemoryUsage();
    }
    
    /**
     * Demonstrate memory efficiency of proxy pattern
     */
    private static void demonstrateMemoryEfficiency() {
        System.out.println("\n3. Memory Efficiency Comparison:");
        System.out.println("--------------------------------");
        
        // Create a gallery with proxies
        ImageGallery proxyGallery = new ImageGallery("Proxy Gallery");
        proxyGallery.addImage("large_image1.jpg", 5242880, "JPEG"); // 5MB
        proxyGallery.addImage("large_image2.jpg", 3145728, "JPEG"); // 3MB
        proxyGallery.addImage("large_image3.jpg", 2097152, "JPEG"); // 2MB
        
        // Show initial state
        System.out.println("Initial state (no images loaded):");
        proxyGallery.showMemoryUsage();
        
        // Load one image
        System.out.println("\nAfter loading one image:");
        proxyGallery.displayImage("large_image1.jpg");
        proxyGallery.showMemoryUsage();
        
        // Load all images
        System.out.println("\nAfter loading all images:");
        proxyGallery.displayAllImages();
        proxyGallery.showMemoryUsage();
        
        // Compare with direct loading approach
        System.out.println("\n4. Comparison with Direct Loading:");
        System.out.println("-----------------------------------");
        
        System.out.println("If we loaded all images directly without proxies:");
        System.out.println("- All images would be loaded immediately");
        System.out.println("- Memory usage would be: " + formatSize(5242880 + 3145728 + 2097152));
        System.out.println("- Application startup would be slower");
        System.out.println("- Memory would be allocated even for unused images");
        
        System.out.println("\nWith Proxy pattern:");
        System.out.println("- Images are loaded only when needed");
        System.out.println("- Memory is allocated incrementally");
        System.out.println("- Application startup is faster");
        System.out.println("- Unused images don't consume memory");
    }
    
    /**
     * Format file size in human-readable format
     * @param bytes the size in bytes
     * @return formatted size string
     */
    private static String formatSize(long bytes) {
        if (bytes < 1024) {
            return bytes + " B";
        } else if (bytes < 1024 * 1024) {
            return String.format("%.1f KB", bytes / 1024.0);
        } else {
            return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
        }
    }
} 
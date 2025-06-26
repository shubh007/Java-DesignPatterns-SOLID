package org.codeposito.structural.proxy.virtual;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Proxy pattern implementation
 */
@DisplayName("Proxy Pattern Tests")
class ProxyTest {
    
    private ImageProxy imageProxy;
    private RealImage realImage;
    private ImageGallery gallery;
    
    @BeforeEach
    void setUp() {
        imageProxy = new ImageProxy("test_image.jpg", 1024000, "JPEG");
        realImage = new RealImage("test_real.jpg", 512000, "PNG");
        gallery = new ImageGallery("Test Gallery");
    }
    
    @Test
    @DisplayName("ImageProxy should have correct initial properties")
    void testImageProxyInitialProperties() {
        assertEquals("test_image.jpg", imageProxy.getFilename());
        assertEquals(1024000, imageProxy.getSize());
        assertEquals("JPEG", imageProxy.getFormat());
        assertFalse(imageProxy.isLoaded());
        assertFalse(imageProxy.isRealImageCreated());
    }
    
    @Test
    @DisplayName("RealImage should have correct properties")
    void testRealImageProperties() {
        assertEquals("test_real.jpg", realImage.getFilename());
        assertEquals(512000, realImage.getSize());
        assertEquals("PNG", realImage.getFormat());
        assertFalse(realImage.isLoaded());
    }
    
    @Test
    @DisplayName("ImageProxy should create RealImage on first display")
    void testImageProxyLazyLoading() {
        // Before display, real image should not exist
        assertFalse(imageProxy.isRealImageCreated());
        assertFalse(imageProxy.isLoaded());
        
        // After display, real image should be created
        imageProxy.display();
        
        assertTrue(imageProxy.isRealImageCreated());
        assertTrue(imageProxy.isLoaded());
        assertNotNull(imageProxy.getRealImage());
    }
    
    @Test
    @DisplayName("ImageProxy should reuse RealImage on subsequent displays")
    void testImageProxyReuse() {
        // First display
        imageProxy.display();
        RealImage firstRealImage = imageProxy.getRealImage();
        
        // Second display
        imageProxy.display();
        RealImage secondRealImage = imageProxy.getRealImage();
        
        // Should be the same instance
        assertSame(firstRealImage, secondRealImage);
    }
    
    @Test
    @DisplayName("RealImage should load on first display")
    void testRealImageLoading() {
        assertFalse(realImage.isLoaded());
        
        realImage.display();
        
        assertTrue(realImage.isLoaded());
    }
    
    @Test
    @DisplayName("ImageGallery should add images correctly")
    void testImageGalleryAddImage() {
        assertEquals(0, gallery.getImageCount());
        
        gallery.addImage("test1.jpg", 1024000, "JPEG");
        gallery.addImage("test2.png", 2048000, "PNG");
        
        assertEquals(2, gallery.getImageCount());
        assertEquals("Test Gallery", gallery.getName());
    }
    
    @Test
    @DisplayName("ImageGallery should find images by filename")
    void testImageGalleryFindImage() {
        gallery.addImage("test1.jpg", 1024000, "JPEG");
        gallery.addImage("test2.png", 2048000, "PNG");
        
        // Test reflection to access private method
        try {
            java.lang.reflect.Method findImageMethod = ImageGallery.class.getDeclaredMethod("findImage", String.class);
            findImageMethod.setAccessible(true);
            
            Image foundImage = (Image) findImageMethod.invoke(gallery, "test1.jpg");
            assertNotNull(foundImage);
            assertEquals("test1.jpg", foundImage.getFilename());
            
            Image notFoundImage = (Image) findImageMethod.invoke(gallery, "nonexistent.jpg");
            assertNull(notFoundImage);
        } catch (Exception e) {
            fail("Reflection test failed: " + e.getMessage());
        }
    }
    
    @Test
    @DisplayName("ImageGallery should display specific images")
    void testImageGalleryDisplaySpecificImage() {
        gallery.addImage("test1.jpg", 1024000, "JPEG");
        gallery.addImage("test2.png", 2048000, "PNG");
        
        // Should not throw exception
        assertDoesNotThrow(() -> gallery.displayImage("test1.jpg"));
        assertDoesNotThrow(() -> gallery.displayImage("nonexistent.jpg"));
    }
    
    @Test
    @DisplayName("ImageGallery should show gallery info")
    void testImageGalleryShowInfo() {
        gallery.addImage("test1.jpg", 1024000, "JPEG");
        gallery.addImage("test2.png", 2048000, "PNG");
        
        // Should not throw exception
        assertDoesNotThrow(() -> gallery.showGalleryInfo());
    }
    
    @Test
    @DisplayName("ImageGallery should show memory usage")
    void testImageGalleryShowMemoryUsage() {
        gallery.addImage("test1.jpg", 1024000, "JPEG");
        gallery.addImage("test2.png", 2048000, "PNG");
        
        // Should not throw exception
        assertDoesNotThrow(() -> gallery.showMemoryUsage());
    }
    
    @Test
    @DisplayName("ImageGallery should display all images")
    void testImageGalleryDisplayAllImages() {
        gallery.addImage("test1.jpg", 1024000, "JPEG");
        gallery.addImage("test2.png", 2048000, "PNG");
        
        // Should not throw exception
        assertDoesNotThrow(() -> gallery.displayAllImages());
    }
    
    @Test
    @DisplayName("Proxy and RealImage should implement same interface")
    void testInterfaceCompatibility() {
        Image[] images = {imageProxy, realImage};
        
        for (Image image : images) {
            assertNotNull(image.getFilename());
            assertTrue(image.getSize() > 0);
            assertNotNull(image.getFormat());
            assertFalse(image.isLoaded()); // Initially not loaded
        }
    }
    
    @Test
    @DisplayName("ImageProxy should delegate to RealImage correctly")
    void testImageProxyDelegation() {
        // Create proxy and display to load real image
        imageProxy.display();
        
        RealImage realImage = imageProxy.getRealImage();
        assertNotNull(realImage);
        
        // Both should have same properties
        assertEquals(imageProxy.getFilename(), realImage.getFilename());
        assertEquals(imageProxy.getSize(), realImage.getSize());
        assertEquals(imageProxy.getFormat(), realImage.getFormat());
    }
    
    @Test
    @DisplayName("Multiple proxies should work independently")
    void testMultipleProxies() {
        ImageProxy proxy1 = new ImageProxy("image1.jpg", 1024000, "JPEG");
        ImageProxy proxy2 = new ImageProxy("image2.png", 2048000, "PNG");
        
        // Initially both should be unloaded
        assertFalse(proxy1.isLoaded());
        assertFalse(proxy2.isLoaded());
        
        // Load only first proxy
        proxy1.display();
        
        assertTrue(proxy1.isLoaded());
        assertFalse(proxy2.isLoaded());
        
        // Load second proxy
        proxy2.display();
        
        assertTrue(proxy1.isLoaded());
        assertTrue(proxy2.isLoaded());
    }
} 
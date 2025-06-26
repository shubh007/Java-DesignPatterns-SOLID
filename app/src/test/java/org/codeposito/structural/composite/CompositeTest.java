package org.codeposito.structural.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Test class for the Composite pattern implementation
 */
public class CompositeTest {
    
    private Directory root;
    private Directory documents;
    private File readmeFile;
    private Directory workDir;
    
    @BeforeEach
    void setUp() {
        // Create a simple test structure
        root = new Directory("root", "rwxr-xr-x");
        documents = new Directory("documents", "rwxr-xr-x");
        workDir = new Directory("work", "rwxr-xr-x");
        
        readmeFile = new File("README.md", 1024, "rw-r--r--", "md", "# Test Documentation");
        
        root.add(documents);
        documents.add(readmeFile);
        documents.add(workDir);
    }
    
    @Test
    void testFileIsLeaf() {
        assertTrue(readmeFile.isLeaf());
        assertFalse(documents.isLeaf());
        assertFalse(root.isLeaf());
    }
    
    @Test
    void testFileSize() {
        assertEquals(1024, readmeFile.getSize());
        assertEquals(1024, readmeFile.getTotalSize());
    }
    
    @Test
    void testDirectorySize() {
        assertEquals(1024, documents.getTotalSize());
        assertEquals(1024, root.getTotalSize());
    }
    
    @Test
    void testAddAndRemoveComponents() {
        File newFile = new File("test.txt", 512, "rw-r--r--", "txt", "Test content");
        documents.add(newFile);
        
        assertEquals(1536, documents.getTotalSize()); // 1024 + 512
        assertEquals(2, documents.getItemCount());
        
        documents.remove(newFile);
        assertEquals(1024, documents.getTotalSize());
        assertEquals(1, documents.getItemCount());
    }
    
    @Test
    void testGetChild() {
        FileSystemComponent child = documents.getChild("README.md");
        assertNotNull(child);
        assertEquals("README.md", child.getName());
        assertTrue(child.isLeaf());
        
        FileSystemComponent nonExistent = documents.getChild("nonexistent.txt");
        assertNull(nonExistent);
    }
    
    @Test
    void testSearch() {
        List<FileSystemComponent> results = root.search("README");
        assertEquals(1, results.size());
        assertEquals("README.md", results.get(0).getName());
        
        List<FileSystemComponent> noResults = root.search("nonexistent");
        assertEquals(0, noResults.size());
    }
    
    @Test
    void testSearchCaseInsensitive() {
        List<FileSystemComponent> results = root.search("readme");
        assertEquals(1, results.size());
        assertEquals("README.md", results.get(0).getName());
    }
    
    @Test
    void testFileOperations() {
        assertEquals("md", readmeFile.getExtension());
        assertEquals("# Test Documentation", readmeFile.getContent());
        
        readmeFile.setContent("New content");
        assertEquals("New content", readmeFile.getContent());
        assertEquals(12, readmeFile.getSize()); // "New content".length()
    }
    
    @Test
    void testDirectoryStatistics() {
        assertEquals(1, documents.getFileCount());
        assertEquals(1, documents.getDirectoryCount());
        assertEquals(2, documents.getItemCount());
        
        assertEquals(1, root.getFileCount());
        assertEquals(2, root.getDirectoryCount());
        assertEquals(3, root.getItemCount());
    }
    
    @Test
    void testLeafOperationsThrowException() {
        assertThrows(UnsupportedOperationException.class, () -> readmeFile.add(new File("test.txt", 100, "rw-r--r--", "txt", "")));
        assertThrows(UnsupportedOperationException.class, () -> readmeFile.remove(new File("test.txt", 100, "rw-r--r--", "txt", "")));
        assertThrows(UnsupportedOperationException.class, () -> readmeFile.getChildren());
        assertThrows(UnsupportedOperationException.class, () -> readmeFile.getChild("test"));
    }
    
    @Test
    void testFileSystemManager() {
        Directory sampleRoot = FileSystemManager.createSampleFileSystem();
        assertNotNull(sampleRoot);
        assertTrue(sampleRoot.getTotalSize() > 0);
        
        // Test search functionality
        List<FileSystemComponent> javaFiles = sampleRoot.search("java");
        assertTrue(javaFiles.size() >= 2); // Should find Main.java, Utils.java, MainTest.java
        
        // Test largest file finding
        File largestFile = FileSystemManager.findLargestFile(sampleRoot);
        assertNotNull(largestFile);
        assertTrue(largestFile.getSize() > 0);
    }
    
    @Test
    void testSizeFormatting() {
        assertEquals("1024 B", FileSystemManager.formatSize(1024));
        assertEquals("1.0 KB", FileSystemManager.formatSize(1024));
        assertEquals("1.0 MB", FileSystemManager.formatSize(1024 * 1024));
        assertEquals("1.0 GB", FileSystemManager.formatSize(1024L * 1024 * 1024));
    }
    
    @Test
    void testComplexStructure() {
        // Create a more complex structure
        Directory src = new Directory("src", "rwxr-xr-x");
        File mainJava = new File("Main.java", 2048, "rw-r--r--", "java", "public class Main {}");
        File utilJava = new File("Utils.java", 1536, "rw-r--r--", "java", "public class Utils {}");
        
        src.add(mainJava);
        src.add(utilJava);
        documents.add(src);
        
        // Test total size calculation
        assertEquals(4608, root.getTotalSize()); // 1024 + 2048 + 1536
        
        // Test file count
        assertEquals(3, root.getFileCount()); // README.md + Main.java + Utils.java
        
        // Test directory count
        assertEquals(3, root.getDirectoryCount()); // documents + work + src
        
        // Test search across complex structure
        List<FileSystemComponent> javaResults = root.search("java");
        assertEquals(2, javaResults.size());
    }
} 
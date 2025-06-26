package org.codeposito.structural.composite;

import java.util.List;

/**
 * Utility class for managing file system operations.
 * Provides high-level operations for working with the composite file system structure.
 */
public class FileSystemManager {
    
    /**
     * Create a sample file system structure for demonstration
     */
    public static Directory createSampleFileSystem() {
        // Create root directory
        Directory root = new Directory("root", "rwxr-xr-x");
        
        // Create documents directory
        Directory documents = new Directory("documents", "rwxr-xr-x");
        root.add(documents);
        
        // Add files to documents
        File readme = new File("README.md", 1024, "rw-r--r--", "md", "# Project Documentation\nThis is a sample project.");
        documents.add(readme);
        
        File config = new File("config.json", 512, "rw-r--r--", "json", "{\"version\": \"1.0\", \"debug\": true}");
        documents.add(config);
        
        // Create work directory
        Directory work = new Directory("work", "rwxr-xr-x");
        documents.add(work);
        
        // Add files to work
        File report = new File("annual_report.pdf", 2048576, "rw-r--r--", "pdf", "Annual financial report for 2024");
        work.add(report);
        
        File presentation = new File("presentation.pptx", 1048576, "rw-r--r--", "pptx", "Quarterly presentation slides");
        work.add(presentation);
        
        // Create personal directory
        Directory personal = new Directory("personal", "rwxr-xr-x");
        documents.add(personal);
        
        // Add files to personal
        File photo = new File("vacation_photo.jpg", 3145728, "rw-r--r--", "jpg", "Photo from summer vacation");
        personal.add(photo);
        
        File notes = new File("notes.txt", 256, "rw-r--r--", "txt", "Personal notes and reminders");
        personal.add(notes);
        
        // Create applications directory
        Directory applications = new Directory("applications", "rwxr-xr-x");
        root.add(applications);
        
        // Create src directory in applications
        Directory src = new Directory("src", "rwxr-xr-x");
        applications.add(src);
        
        // Add source code files
        File mainJava = new File("Main.java", 2048, "rw-r--r--", "java", "public class Main {\n    public static void main(String[] args) {\n        System.out.println(\"Hello World!\");\n    }\n}");
        src.add(mainJava);
        
        File utilJava = new File("Utils.java", 1536, "rw-r--r--", "java", "public class Utils {\n    public static void helper() {\n        // Helper methods\n    }\n}");
        src.add(utilJava);
        
        // Create test directory
        Directory test = new Directory("test", "rwxr-xr-x");
        applications.add(test);
        
        // Add test files
        File testJava = new File("MainTest.java", 1024, "rw-r--r--", "java", "public class MainTest {\n    @Test\n    public void testMain() {\n        // Test implementation\n    }\n}");
        test.add(testJava);
        
        return root;
    }
    
    /**
     * Display file system statistics
     */
    public static void displayStatistics(FileSystemComponent component) {
        System.out.println("\n📊 File System Statistics:");
        System.out.println("==========================");
        
        if (component.isLeaf()) {
            System.out.println("Type: File");
            System.out.println("Size: " + formatSize(component.getSize()));
        } else {
            Directory dir = (Directory) component;
            System.out.println("Type: Directory");
            System.out.println("Total Size: " + formatSize(dir.getTotalSize()));
            System.out.println("Items: " + dir.getItemCount());
            System.out.println("Files: " + dir.getFileCount());
            System.out.println("Directories: " + dir.getDirectoryCount());
        }
        
        System.out.println("Name: " + component.getName());
        System.out.println("Permissions: " + component.getPermissions());
    }
    
    /**
     * Search for components by pattern
     */
    public static void searchAndDisplay(FileSystemComponent component, String pattern) {
        System.out.println("\n🔍 Search Results for '" + pattern + "':");
        System.out.println("=====================================");
        
        List<FileSystemComponent> results = component.search(pattern);
        
        if (results.isEmpty()) {
            System.out.println("No components found matching the pattern.");
        } else {
            System.out.println("Found " + results.size() + " component(s):");
            for (FileSystemComponent result : results) {
                String type = result.isLeaf() ? "📄 File" : "📁 Directory";
                System.out.println("  " + type + ": " + result.getName() + " (" + formatSize(result.getTotalSize()) + ")");
            }
        }
    }
    
    /**
     * Display the complete file system tree
     */
    public static void displayFileSystem(FileSystemComponent component) {
        System.out.println("\n📂 File System Structure:");
        System.out.println("=========================");
        component.display("");
    }
    
    /**
     * Find the largest file in the file system
     */
    public static File findLargestFile(FileSystemComponent component) {
        if (component.isLeaf()) {
            return (File) component;
        }
        
        File largestFile = null;
        long maxSize = 0;
        
        Directory dir = (Directory) component;
        for (FileSystemComponent child : dir.getChildren()) {
            File childLargest = findLargestFile(child);
            if (childLargest != null && childLargest.getSize() > maxSize) {
                largestFile = childLargest;
                maxSize = childLargest.getSize();
            }
        }
        
        return largestFile;
    }
    
    /**
     * Calculate total disk usage
     */
    public static long calculateTotalUsage(FileSystemComponent component) {
        return component.getTotalSize();
    }
    
    /**
     * Format size in human-readable format
     */
    public static String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
        return String.format("%.1f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    }
} 
package org.codeposito.structural.composite;

/**
 * Composite Client - demonstrates the Composite pattern in action
 * This class shows how the composite pattern allows treating individual objects
 * and compositions of objects uniformly.
 */
public class CompositeClient {
    
    public static void main(String[] args) {
        System.out.println("=== Composite Pattern Demo ===\n");
        
        // Create a sample file system structure
        Directory root = FileSystemManager.createSampleFileSystem();
        
        // Demonstrate the composite pattern
        demonstrateCompositePattern(root);
        
        // Demonstrate file system operations
        demonstrateFileSystemOperations(root);
        
        // Demonstrate dynamic structure modification
        demonstrateDynamicModification(root);
        
        System.out.println("\n=== Composite Pattern Demo Complete ===");
    }
    
    /**
     * Demonstrate the core composite pattern concepts
     */
    private static void demonstrateCompositePattern(FileSystemComponent root) {
        System.out.println("1. Composite Pattern Core Concepts:");
        System.out.println("===================================");
        
        // Show that we can treat files and directories uniformly
        System.out.println("Treating individual files and directories uniformly:");
        
        // Get a file (leaf)
        FileSystemComponent readmeFile = root.getChild("documents").getChild("README.md");
        System.out.println("File: " + readmeFile.getName() + " - Is Leaf: " + readmeFile.isLeaf());
        System.out.println("File Size: " + FileSystemManager.formatSize(readmeFile.getTotalSize()));
        
        // Get a directory (composite)
        FileSystemComponent documentsDir = root.getChild("documents");
        System.out.println("Directory: " + documentsDir.getName() + " - Is Leaf: " + documentsDir.isLeaf());
        System.out.println("Directory Total Size: " + FileSystemManager.formatSize(documentsDir.getTotalSize()));
        
        // Both can be displayed the same way
        System.out.println("\nDisplaying file:");
        readmeFile.display("  ");
        
        System.out.println("\nDisplaying directory:");
        documentsDir.display("  ");
        
        // Both can be searched the same way
        System.out.println("\nSearching in file:");
        readmeFile.search("README").forEach(result -> 
            System.out.println("  Found: " + result.getName()));
        
        System.out.println("\nSearching in directory:");
        documentsDir.search("work").forEach(result -> 
            System.out.println("  Found: " + result.getName()));
    }
    
    /**
     * Demonstrate various file system operations
     */
    private static void demonstrateFileSystemOperations(FileSystemComponent root) {
        System.out.println("\n2. File System Operations:");
        System.out.println("==========================");
        
        // Display the complete file system
        FileSystemManager.displayFileSystem(root);
        
        // Show statistics
        FileSystemManager.displayStatistics(root);
        
        // Search operations
        FileSystemManager.searchAndDisplay(root, "java");
        FileSystemManager.searchAndDisplay(root, "report");
        FileSystemManager.searchAndDisplay(root, "nonexistent");
        
        // Find largest file
        File largestFile = FileSystemManager.findLargestFile(root);
        if (largestFile != null) {
            System.out.println("\n📄 Largest File:");
            System.out.println("================");
            System.out.println("Name: " + largestFile.getName());
            System.out.println("Size: " + FileSystemManager.formatSize(largestFile.getSize()));
            System.out.println("Extension: " + largestFile.getExtension());
        }
        
        // Calculate total usage
        long totalUsage = FileSystemManager.calculateTotalUsage(root);
        System.out.println("\n💾 Total Disk Usage: " + FileSystemManager.formatSize(totalUsage));
    }
    
    /**
     * Demonstrate dynamic structure modification
     */
    private static void demonstrateDynamicModification(FileSystemComponent root) {
        System.out.println("\n3. Dynamic Structure Modification:");
        System.out.println("==================================");
        
        Directory documents = (Directory) root.getChild("documents");
        
        System.out.println("Before modification - Documents directory:");
        documents.display("  ");
        
        // Add a new file
        File newFile = new File("new_document.txt", 1024, "rw-r--r--", "txt", "This is a newly created document");
        documents.add(newFile);
        
        // Add a new directory
        Directory newDir = new Directory("new_folder", "rwxr-xr-x");
        documents.add(newDir);
        
        // Add a file to the new directory
        File subFile = new File("sub_file.txt", 512, "rw-r--r--", "txt", "File inside new folder");
        newDir.add(subFile);
        
        System.out.println("\nAfter modification - Documents directory:");
        documents.display("  ");
        
        // Remove a file
        documents.remove(newFile);
        
        System.out.println("\nAfter removing new_document.txt:");
        documents.display("  ");
        
        // Show updated statistics
        FileSystemManager.displayStatistics(documents);
    }
    
    /**
     * Utility method to format size (moved from FileSystemManager for demo purposes)
     */
    private static String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
        return String.format("%.1f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    }
} 
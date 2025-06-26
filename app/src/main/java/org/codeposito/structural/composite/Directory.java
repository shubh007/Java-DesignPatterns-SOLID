package org.codeposito.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite class representing a directory in the file system.
 * This is a concrete implementation of FileSystemComponent that can contain other components.
 */
public class Directory extends FileSystemComponent {
    
    private List<FileSystemComponent> children;
    
    public Directory(String name, String permissions) {
        super(name, 0, permissions);
        this.children = new ArrayList<>();
    }
    
    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
        updateSize();
    }
    
    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
        updateSize();
    }
    
    @Override
    public List<FileSystemComponent> getChildren() {
        return new ArrayList<>(children);
    }
    
    @Override
    public FileSystemComponent getChild(String name) {
        return children.stream()
                .filter(child -> child.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public void display(String indent) {
        System.out.println(indent + "📁 " + name + " (" + formatSize(getTotalSize()) + ") [" + permissions + "]");
        
        // Sort children: directories first, then files
        List<FileSystemComponent> sortedChildren = new ArrayList<>(children);
        sortedChildren.sort((a, b) -> {
            if (a.isLeaf() != b.isLeaf()) {
                return a.isLeaf() ? 1 : -1; // Directories first
            }
            return a.getName().compareToIgnoreCase(b.getName());
        });
        
        for (FileSystemComponent child : sortedChildren) {
            child.display(indent + "  ");
        }
    }
    
    @Override
    public boolean isLeaf() {
        return false;
    }
    
    @Override
    public long getTotalSize() {
        return children.stream()
                .mapToLong(FileSystemComponent::getTotalSize)
                .sum();
    }
    
    @Override
    public List<FileSystemComponent> search(String pattern) {
        List<FileSystemComponent> results = new ArrayList<>();
        
        // Check if this directory matches the pattern
        if (name.toLowerCase().contains(pattern.toLowerCase())) {
            results.add(this);
        }
        
        // Search in all children recursively
        for (FileSystemComponent child : children) {
            results.addAll(child.search(pattern));
        }
        
        return results;
    }
    
    /**
     * Get the number of items in this directory
     */
    public int getItemCount() {
        return children.size();
    }
    
    /**
     * Get the number of files in this directory (recursive)
     */
    public int getFileCount() {
        return (int) children.stream()
                .mapToLong(child -> child.isLeaf() ? 1 : ((Directory) child).getFileCount())
                .sum();
    }
    
    /**
     * Get the number of directories in this directory (recursive)
     */
    public int getDirectoryCount() {
        return (int) children.stream()
                .mapToLong(child -> child.isLeaf() ? 0 : 1 + ((Directory) child).getDirectoryCount())
                .sum();
    }
    
    /**
     * Update the directory size based on children
     */
    private void updateSize() {
        this.size = getTotalSize();
    }
    
    /**
     * Format size in human-readable format
     */
    private String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
        return String.format("%.1f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    }
} 
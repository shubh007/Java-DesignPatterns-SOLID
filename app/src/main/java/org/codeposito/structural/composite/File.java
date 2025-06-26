package org.codeposito.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Leaf class representing a file in the file system.
 * This is a concrete implementation of FileSystemComponent that cannot have children.
 */
public class File extends FileSystemComponent {
    
    private String extension;
    private String content;
    
    public File(String name, long size, String permissions, String extension, String content) {
        super(name, size, permissions);
        this.extension = extension;
        this.content = content;
    }
    
    /**
     * Get the file extension
     */
    public String getExtension() {
        return extension;
    }
    
    /**
     * Get the file content
     */
    public String getContent() {
        return content;
    }
    
    /**
     * Set the file content
     */
    public void setContent(String content) {
        this.content = content;
        // Update size based on content length
        this.size = content != null ? content.getBytes().length : 0;
    }
    
    @Override
    public void display(String indent) {
        System.out.println(indent + "📄 " + name + " (" + formatSize(size) + ") [" + permissions + "]");
        if (content != null && !content.isEmpty()) {
            System.out.println(indent + "   Content: " + content.substring(0, Math.min(content.length(), 50)) + 
                             (content.length() > 50 ? "..." : ""));
        }
    }
    
    @Override
    public boolean isLeaf() {
        return true;
    }
    
    @Override
    public long getTotalSize() {
        return size;
    }
    
    @Override
    public List<FileSystemComponent> search(String pattern) {
        List<FileSystemComponent> results = new ArrayList<>();
        if (name.toLowerCase().contains(pattern.toLowerCase())) {
            results.add(this);
        }
        return results;
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
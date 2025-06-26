package org.codeposito.structural.composite;

import java.util.List;

/**
 * Abstract component class for the Composite pattern.
 * Defines the common interface for both leaf and composite objects.
 * This represents a file system component that can be either a file or a directory.
 */
public abstract class FileSystemComponent {
    
    protected String name;
    protected long size;
    protected String permissions;
    
    public FileSystemComponent(String name, long size, String permissions) {
        this.name = name;
        this.size = size;
        this.permissions = permissions;
    }
    
    /**
     * Get the name of the component
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the size of the component (in bytes)
     */
    public long getSize() {
        return size;
    }
    
    /**
     * Get the permissions of the component
     */
    public String getPermissions() {
        return permissions;
    }
    
    /**
     * Display the component information
     */
    public abstract void display(String indent);
    
    /**
     * Add a child component (only meaningful for composite objects)
     */
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot add to leaf component");
    }
    
    /**
     * Remove a child component (only meaningful for composite objects)
     */
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot remove from leaf component");
    }
    
    /**
     * Get child components (only meaningful for composite objects)
     */
    public List<FileSystemComponent> getChildren() {
        throw new UnsupportedOperationException("Leaf component has no children");
    }
    
    /**
     * Get a specific child by name (only meaningful for composite objects)
     */
    public FileSystemComponent getChild(String name) {
        throw new UnsupportedOperationException("Leaf component has no children");
    }
    
    /**
     * Check if this component is a leaf (file)
     */
    public abstract boolean isLeaf();
    
    /**
     * Get the total size including all children (recursive for directories)
     */
    public abstract long getTotalSize();
    
    /**
     * Search for components by name pattern
     */
    public abstract List<FileSystemComponent> search(String pattern);
} 
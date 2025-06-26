package org.codeposito.creational.prototype;

import java.time.LocalDateTime;

/**
 * DocumentMetadata class implementing Cloneable interface
 * Contains metadata information for documents
 */
public class DocumentMetadata implements Cloneable {
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String version;
    private boolean isPublic;

    public DocumentMetadata() {
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
        this.version = "1.0";
        this.isPublic = false;
    }

    // Getters
    public String getAuthor() { return author; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getModifiedAt() { return modifiedAt; }
    public String getVersion() { return version; }
    public boolean isPublic() { return isPublic; }

    // Setters
    public void setAuthor(String author) { 
        this.author = author; 
        this.modifiedAt = LocalDateTime.now();
    }
    public void setVersion(String version) { 
        this.version = version; 
        this.modifiedAt = LocalDateTime.now();
    }
    public void setPublic(boolean isPublic) { 
        this.isPublic = isPublic; 
        this.modifiedAt = LocalDateTime.now();
    }

    /**
     * Clone implementation for DocumentMetadata
     */
    @Override
    public DocumentMetadata clone() {
        try {
            DocumentMetadata cloned = (DocumentMetadata) super.clone();
            // LocalDateTime is immutable, so no need for deep copy
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    @Override
    public String toString() {
        return "DocumentMetadata{" +
                "author='" + author + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", version='" + version + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }
} 
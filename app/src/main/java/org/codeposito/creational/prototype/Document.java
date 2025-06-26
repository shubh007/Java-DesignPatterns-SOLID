package org.codeposito.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Document class implementing Cloneable interface for prototype pattern
 * Demonstrates shallow copy implementation
 */
public class Document implements Cloneable {
    private String title;
    private String content;
    private List<String> tags;
    private DocumentMetadata metadata;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
        this.tags = new ArrayList<>();
        this.metadata = new DocumentMetadata();
    }

    // Getters
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public List<String> getTags() { return tags; }
    public DocumentMetadata getMetadata() { return metadata; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void addTag(String tag) { this.tags.add(tag); }
    public void setMetadata(DocumentMetadata metadata) { this.metadata = metadata; }

    /**
     * Shallow copy implementation using Cloneable interface
     * Note: This creates a shallow copy - nested objects are shared
     */
    @Override
    public Document clone() {
        try {
            Document cloned = (Document) super.clone();
            // For shallow copy, we need to manually clone mutable objects
            cloned.tags = new ArrayList<>(this.tags);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    /**
     * Deep copy implementation
     * Creates completely independent copy of the document
     */
    public Document deepClone() {
        Document cloned = new Document(this.title, this.content);
        cloned.tags = new ArrayList<>(this.tags);
        cloned.metadata = this.metadata.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tags=" + tags +
                ", metadata=" + metadata +
                '}';
    }
} 
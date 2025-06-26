package org.codeposito.behavioral.chainOfResponsibility;

/**
 * Represents a request that will be processed by the chain of responsibility.
 */
public class Request {
    private final RequestType type;
    private final String description;
    private final int priority;

    public Request(RequestType type, String description, int priority) {
        this.type = type;
        this.description = description;
        this.priority = priority;
    }

    public RequestType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type=" + type +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
} 
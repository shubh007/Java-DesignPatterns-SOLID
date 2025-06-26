package org.codeposito.behavioral.chainOfResponsibility;

/**
 * Abstract handler class that defines the interface for the Chain of Responsibility pattern.
 * Each handler can either handle the request or pass it to the next handler in the chain.
 */
public abstract class Handler {
    protected Handler nextHandler;

    /**
     * Sets the next handler in the chain.
     * @param handler The next handler to be called if this handler cannot process the request.
     * @return The handler that was set (for method chaining).
     */
    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        return handler;
    }

    /**
     * Template method that defines the algorithm for handling requests.
     * @param request The request to be handled.
     */
    public void handle(Request request) {
        if (canHandle(request)) {
            processRequest(request);
        } else if (nextHandler != null) {
            nextHandler.handle(request);
        } else {
            System.out.println("No handler found for request: " + request.getType());
        }
    }

    /**
     * Abstract method that concrete handlers must implement to determine if they can handle the request.
     * @param request The request to be evaluated.
     * @return true if this handler can process the request, false otherwise.
     */
    protected abstract boolean canHandle(Request request);

    /**
     * Abstract method that concrete handlers must implement to process the request.
     * @param request The request to be processed.
     */
    protected abstract void processRequest(Request request);
} 
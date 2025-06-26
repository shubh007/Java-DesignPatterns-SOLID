package org.codeposito.behavioral.chainOfResponsibility;

/**
 * Concrete handler for processing complaint requests.
 */
public class ComplaintHandler extends Handler {

    @Override
    protected boolean canHandle(Request request) {
        return request.getType() == RequestType.COMPLAINT;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("ComplaintHandler: Processing complaint request - " + request.getDescription());
        System.out.println("ComplaintHandler: Recording complaint details...");
        System.out.println("ComplaintHandler: Escalating to appropriate department...");
        System.out.println("ComplaintHandler: Complaint request processed successfully.");
    }
} 
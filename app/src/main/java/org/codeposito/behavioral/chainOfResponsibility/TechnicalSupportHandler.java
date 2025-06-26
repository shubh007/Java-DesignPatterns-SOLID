package org.codeposito.behavioral.chainOfResponsibility;

/**
 * Concrete handler for processing technical support requests.
 */
public class TechnicalSupportHandler extends Handler {

    @Override
    protected boolean canHandle(Request request) {
        return request.getType() == RequestType.TECHNICAL_SUPPORT;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("TechnicalSupportHandler: Processing technical support request - " + request.getDescription());
        System.out.println("TechnicalSupportHandler: Analyzing technical issue...");
        System.out.println("TechnicalSupportHandler: Providing technical assistance...");
        System.out.println("TechnicalSupportHandler: Technical support request processed successfully.");
    }
} 
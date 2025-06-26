package org.codeposito.behavioral.chainOfResponsibility;

/**
 * Concrete handler for processing purchase requests.
 */
public class PurchaseHandler extends Handler {

    @Override
    protected boolean canHandle(Request request) {
        return request.getType() == RequestType.PURCHASE;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("PurchaseHandler: Processing purchase request - " + request.getDescription());
        System.out.println("PurchaseHandler: Validating payment information...");
        System.out.println("PurchaseHandler: Processing payment and confirming order...");
        System.out.println("PurchaseHandler: Purchase request processed successfully.");
    }
} 
package org.codeposito.behavioral.chainOfResponsibility;

/**
 * Concrete handler for processing refund requests.
 */
public class RefundHandler extends Handler {

    @Override
    protected boolean canHandle(Request request) {
        return request.getType() == RequestType.REFUND;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("RefundHandler: Processing refund request - " + request.getDescription());
        System.out.println("RefundHandler: Validating refund eligibility...");
        System.out.println("RefundHandler: Processing refund and updating records...");
        System.out.println("RefundHandler: Refund request processed successfully.");
    }
} 
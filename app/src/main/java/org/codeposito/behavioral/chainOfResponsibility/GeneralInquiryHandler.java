package org.codeposito.behavioral.chainOfResponsibility;

/**
 * Concrete handler for processing general inquiry requests.
 */
public class GeneralInquiryHandler extends Handler {

    @Override
    protected boolean canHandle(Request request) {
        return request.getType() == RequestType.GENERAL_INQUIRY;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("GeneralInquiryHandler: Processing general inquiry request - " + request.getDescription());
        System.out.println("GeneralInquiryHandler: Providing general information...");
        System.out.println("GeneralInquiryHandler: Directing to appropriate resources...");
        System.out.println("GeneralInquiryHandler: General inquiry request processed successfully.");
    }
} 
package org.codeposito.behavioral.chainOfResponsibility;

/**
 * Client class that demonstrates the Chain of Responsibility pattern.
 * Sets up a chain of handlers and processes various types of requests.
 */
public class ChainOfResponsibilityClient {

    public static void main(String[] args) {
        System.out.println("=== Chain of Responsibility Pattern Demo ===\n");

        // Create handlers
        Handler loginHandler = new LoginHandler();
        Handler purchaseHandler = new PurchaseHandler();
        Handler refundHandler = new RefundHandler();
        Handler complaintHandler = new ComplaintHandler();
        Handler technicalSupportHandler = new TechnicalSupportHandler();
        Handler generalInquiryHandler = new GeneralInquiryHandler();

        // Set up the chain
        loginHandler
                .setNext(purchaseHandler)
                .setNext(refundHandler)
                .setNext(complaintHandler)
                .setNext(technicalSupportHandler)
                .setNext(generalInquiryHandler);

        // Create various requests
        Request[] requests = {
                new Request(RequestType.LOGIN, "User login request", 1),
                new Request(RequestType.PURCHASE, "Product purchase request", 2),
                new Request(RequestType.REFUND, "Order refund request", 3),
                new Request(RequestType.COMPLAINT, "Customer complaint", 4),
                new Request(RequestType.TECHNICAL_SUPPORT, "Software issue", 5),
                new Request(RequestType.GENERAL_INQUIRY, "Product information", 6)
        };

        // Process each request through the chain
        for (Request request : requests) {
            System.out.println("Processing: " + request);
            loginHandler.handle(request);
            System.out.println();
        }

        // Demonstrate handling an unknown request type
        System.out.println("=== Testing Unknown Request Type ===");
        Request unknownRequest = new Request(RequestType.GENERAL_INQUIRY, "Unknown request", 7);
        // Note: This will be handled by the GeneralInquiryHandler since it's the last in the chain
        loginHandler.handle(unknownRequest);
    }
} 
package org.codeposito.structural.adapter;

/**
 * Legacy Payment System - represents an old payment system with a different interface
 * This is the "Adaptee" class that needs to be adapted to work with modern payment interfaces
 */
public class LegacyPaymentSystem {
    
    /**
     * Process payment using the old legacy format
     * @param accountNumber The account number in legacy format (e.g., "ACC123456789")
     * @param amount The amount in cents (e.g., 1500 for $15.00)
     * @param currencyCode The currency code in legacy format (e.g., "USD001")
     * @return Legacy payment result with status code and message
     */
    public LegacyPaymentResult processLegacyPayment(String accountNumber, int amount, String currencyCode) {
        // Simulate legacy payment processing
        System.out.println("Processing legacy payment:");
        System.out.println("  Account: " + accountNumber);
        System.out.println("  Amount: " + amount + " cents");
        System.out.println("  Currency: " + currencyCode);
        
        // Simulate processing delay
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Simulate success/failure based on amount
        boolean success = amount > 0 && amount <= 1000000; // Max $10,000
        int statusCode = success ? 200 : 400;
        String message = success ? "Payment processed successfully" : "Payment failed - invalid amount";
        
        return new LegacyPaymentResult(statusCode, message);
    }
    
    /**
     * Get account balance using legacy format
     * @param accountNumber The account number in legacy format
     * @return Balance in cents
     */
    public int getLegacyBalance(String accountNumber) {
        // Simulate balance retrieval
        System.out.println("Getting legacy balance for account: " + accountNumber);
        
        // Simulate processing delay
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Return a mock balance (in cents)
        return 50000; // $500.00
    }
    
    /**
     * Legacy payment result class
     */
    public static class LegacyPaymentResult {
        private final int statusCode;
        private final String message;
        
        public LegacyPaymentResult(int statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }
        
        public int getStatusCode() {
            return statusCode;
        }
        
        public String getMessage() {
            return message;
        }
        
        public boolean isSuccess() {
            return statusCode == 200;
        }
    }
} 
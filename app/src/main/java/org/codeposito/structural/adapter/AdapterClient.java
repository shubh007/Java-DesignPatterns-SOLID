package org.codeposito.structural.adapter;

import java.math.BigDecimal;

/**
 * Adapter Client - demonstrates the Adapter pattern in action
 * This class shows how the adapter allows modern clients to work with legacy systems
 */
public class AdapterClient {
    
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern Demo ===\n");
        
        // Create the legacy payment system (the adaptee)
        LegacyPaymentSystem legacySystem = new LegacyPaymentSystem();
        
        // Create the adapter that wraps the legacy system
        ModernPaymentProcessor adapter = new LegacyPaymentAdapter(legacySystem);
        
        // Create the modern payment service that uses the adapter
        ModernPaymentService paymentService = new ModernPaymentService(adapter);
        
        // Demonstrate the adapter pattern in action
        demonstrateAdapterPattern(paymentService, legacySystem);
    }
    
    /**
     * Demonstrate the adapter pattern by showing both legacy and modern interfaces
     */
    private static void demonstrateAdapterPattern(ModernPaymentService paymentService, 
                                                 LegacyPaymentSystem legacySystem) {
        
        System.out.println("1. Direct Legacy System Usage:");
        System.out.println("-------------------------------");
        
        // Use the legacy system directly
        LegacyPaymentSystem.LegacyPaymentResult legacyResult = 
            legacySystem.processLegacyPayment("ACC000001234", 1500, "USD001");
        System.out.println("Legacy Result: " + legacyResult.getMessage() + " (Status: " + legacyResult.getStatusCode() + ")");
        
        int legacyBalance = legacySystem.getLegacyBalance("ACC000001234");
        System.out.println("Legacy Balance: " + legacyBalance + " cents\n");
        
        System.out.println("2. Modern Interface Usage (via Adapter):");
        System.out.println("----------------------------------------");
        
        // Use the modern interface through the adapter
        ModernPaymentProcessor.PaymentResponse modernResponse = 
            paymentService.makePayment("1234", new BigDecimal("15.00"), "USD", "Coffee purchase");
        System.out.println("Modern Response: " + modernResponse.getMessage());
        if (modernResponse.isSuccess()) {
            System.out.println("Transaction ID: " + modernResponse.getTransactionId());
        }
        
        ModernPaymentProcessor.AccountBalance modernBalance = paymentService.getBalance("1234");
        System.out.println("Modern Balance: " + modernBalance.getBalance() + " " + modernBalance.getCurrency() + "\n");
        
        System.out.println("3. Multiple Payment Scenarios:");
        System.out.println("------------------------------");
        
        // Test different payment scenarios
        testPaymentScenarios(paymentService);
        
        System.out.println("4. Error Handling:");
        System.out.println("------------------");
        
        // Test error scenarios
        testErrorScenarios(paymentService);
        
        System.out.println("\n=== Adapter Pattern Demo Complete ===");
    }
    
    /**
     * Test various payment scenarios
     */
    private static void testPaymentScenarios(ModernPaymentService paymentService) {
        // Small payment
        ModernPaymentProcessor.PaymentResponse response1 = 
            paymentService.makePayment("5678", new BigDecimal("5.99"), "USD", "Lunch");
        System.out.println("Small payment result: " + response1.getMessage());
        
        // Large payment
        ModernPaymentProcessor.PaymentResponse response2 = 
            paymentService.makePayment("9012", new BigDecimal("999.99"), "USD", "Electronics purchase");
        System.out.println("Large payment result: " + response2.getMessage());
        
        // Different currency
        ModernPaymentProcessor.PaymentResponse response3 = 
            paymentService.makePayment("3456", new BigDecimal("25.50"), "EUR", "European purchase");
        System.out.println("EUR payment result: " + response3.getMessage());
    }
    
    /**
     * Test error handling scenarios
     */
    private static void testErrorScenarios(ModernPaymentService paymentService) {
        // Invalid amount (negative)
        ModernPaymentProcessor.PaymentResponse response1 = 
            paymentService.makePayment("9999", new BigDecimal("-10.00"), "USD", "Invalid payment");
        System.out.println("Negative amount result: " + response1.getMessage());
        
        // Very large amount (exceeds limit)
        ModernPaymentProcessor.PaymentResponse response2 = 
            paymentService.makePayment("8888", new BigDecimal("15000.00"), "USD", "Excessive amount");
        System.out.println("Excessive amount result: " + response2.getMessage());
    }
} 
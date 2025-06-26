package org.codeposito.structural.adapter;

import java.math.BigDecimal;

/**
 * Modern Payment Service - represents a client that uses the modern payment interface
 * This class demonstrates how clients can work with the modern interface without knowing
 * about the underlying legacy system implementation
 */
public class ModernPaymentService {
    
    private final ModernPaymentProcessor paymentProcessor;
    
    public ModernPaymentService(ModernPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
    
    /**
     * Process a payment using the modern payment interface
     * @param accountId The account ID
     * @param amount The payment amount
     * @param currency The currency code
     * @param description Payment description
     * @return Payment response
     */
    public ModernPaymentProcessor.PaymentResponse makePayment(String accountId, BigDecimal amount, 
                                                             String currency, String description) {
        System.out.println("Modern Payment Service: Processing payment request");
        System.out.println("  Account: " + accountId);
        System.out.println("  Amount: " + amount + " " + currency);
        System.out.println("  Description: " + description);
        
        // Check if payment processor is available
        if (!paymentProcessor.isAvailable()) {
            return new ModernPaymentProcessor.PaymentResponse(false, null, "Payment processor unavailable");
        }
        
        // Create modern payment request
        ModernPaymentProcessor.PaymentRequest request = 
            new ModernPaymentProcessor.PaymentRequest(accountId, amount, currency, description);
        
        // Process payment using the modern interface
        ModernPaymentProcessor.PaymentResponse response = paymentProcessor.processPayment(request);
        
        // Log the result
        if (response.isSuccess()) {
            System.out.println("Payment successful! Transaction ID: " + response.getTransactionId());
        } else {
            System.out.println("Payment failed: " + response.getMessage());
        }
        
        return response;
    }
    
    /**
     * Get account balance using the modern payment interface
     * @param accountId The account ID
     * @return Account balance
     */
    public ModernPaymentProcessor.AccountBalance getBalance(String accountId) {
        System.out.println("Modern Payment Service: Getting balance for account: " + accountId);
        
        // Check if payment processor is available
        if (!paymentProcessor.isAvailable()) {
            throw new RuntimeException("Payment processor unavailable");
        }
        
        // Get balance using the modern interface
        ModernPaymentProcessor.AccountBalance balance = paymentProcessor.getAccountBalance(accountId);
        
        System.out.println("Balance retrieved: " + balance.getBalance() + " " + balance.getCurrency());
        
        return balance;
    }
    
    /**
     * Check if the payment service is available
     * @return true if available, false otherwise
     */
    public boolean isServiceAvailable() {
        return paymentProcessor.isAvailable();
    }
} 
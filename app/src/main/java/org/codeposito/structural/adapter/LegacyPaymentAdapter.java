package org.codeposito.structural.adapter;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Legacy Payment Adapter - adapts the legacy payment system to work with modern payment interface
 * This is the "Adapter" class that implements the target interface and delegates to the adaptee
 */
public class LegacyPaymentAdapter implements ModernPaymentProcessor {
    
    private final LegacyPaymentSystem legacySystem;
    
    public LegacyPaymentAdapter(LegacyPaymentSystem legacySystem) {
        this.legacySystem = legacySystem;
    }
    
    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        System.out.println("Adapter: Converting modern payment request to legacy format");
        
        // Convert modern account ID to legacy account number format
        String legacyAccountNumber = convertToLegacyAccountNumber(paymentRequest.getAccountId());
        
        // Convert modern amount (BigDecimal) to legacy amount (cents as int)
        int legacyAmount = convertToLegacyAmount(paymentRequest.getAmount());
        
        // Convert modern currency to legacy currency code
        String legacyCurrencyCode = convertToLegacyCurrencyCode(paymentRequest.getCurrency());
        
        // Process payment using legacy system
        LegacyPaymentSystem.LegacyPaymentResult legacyResult = 
            legacySystem.processLegacyPayment(legacyAccountNumber, legacyAmount, legacyCurrencyCode);
        
        // Convert legacy result to modern response format
        return convertToModernResponse(legacyResult, paymentRequest);
    }
    
    @Override
    public AccountBalance getAccountBalance(String accountId) {
        System.out.println("Adapter: Converting modern account ID to legacy format for balance check");
        
        // Convert modern account ID to legacy account number
        String legacyAccountNumber = convertToLegacyAccountNumber(accountId);
        
        // Get balance using legacy system
        int legacyBalance = legacySystem.getLegacyBalance(legacyAccountNumber);
        
        // Convert legacy balance (cents) to modern balance (BigDecimal)
        BigDecimal modernBalance = convertToModernBalance(legacyBalance);
        
        // Return modern account balance format
        return new AccountBalance(accountId, modernBalance, "USD");
    }
    
    @Override
    public boolean isAvailable() {
        // The legacy system is always available in this implementation
        return true;
    }
    
    /**
     * Convert modern account ID to legacy account number format
     * @param modernAccountId Modern account ID (e.g., "12345")
     * @return Legacy account number (e.g., "ACC000012345")
     */
    private String convertToLegacyAccountNumber(String modernAccountId) {
        return "ACC" + String.format("%09d", Integer.parseInt(modernAccountId));
    }
    
    /**
     * Convert modern amount (BigDecimal) to legacy amount (cents as int)
     * @param modernAmount Modern amount (e.g., 15.50)
     * @return Legacy amount in cents (e.g., 1550)
     */
    private int convertToLegacyAmount(BigDecimal modernAmount) {
        return modernAmount.multiply(BigDecimal.valueOf(100)).intValue();
    }
    
    /**
     * Convert modern currency to legacy currency code
     * @param modernCurrency Modern currency (e.g., "USD")
     * @return Legacy currency code (e.g., "USD001")
     */
    private String convertToLegacyCurrencyCode(String modernCurrency) {
        return modernCurrency + "001";
    }
    
    /**
     * Convert legacy balance (cents) to modern balance (BigDecimal)
     * @param legacyBalance Legacy balance in cents
     * @return Modern balance as BigDecimal
     */
    private BigDecimal convertToModernBalance(int legacyBalance) {
        return BigDecimal.valueOf(legacyBalance).divide(BigDecimal.valueOf(100)).setScale(2);
    }
    
    /**
     * Convert legacy payment result to modern payment response
     * @param legacyResult Legacy payment result
     * @param originalRequest Original modern payment request
     * @return Modern payment response
     */
    private PaymentResponse convertToModernResponse(LegacyPaymentSystem.LegacyPaymentResult legacyResult, 
                                                   PaymentRequest originalRequest) {
        boolean success = legacyResult.isSuccess();
        String transactionId = success ? generateTransactionId() : null;
        String message = legacyResult.getMessage();
        
        return new PaymentResponse(success, transactionId, message);
    }
    
    /**
     * Generate a unique transaction ID
     * @return Unique transaction ID
     */
    private String generateTransactionId() {
        return "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
} 
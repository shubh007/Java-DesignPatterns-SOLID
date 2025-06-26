package org.codeposito.structural.adapter;

import java.math.BigDecimal;

/**
 * Modern Payment Processor - represents the target interface that clients expect
 * This is the interface that the adapter will implement
 */
public interface ModernPaymentProcessor {
    
    /**
     * Process a payment using modern payment format
     * @param paymentRequest The payment request with modern format
     * @return Payment response with modern format
     */
    PaymentResponse processPayment(PaymentRequest paymentRequest);
    
    /**
     * Get account balance using modern format
     * @param accountId The account ID in modern format
     * @return Account balance in modern format
     */
    AccountBalance getAccountBalance(String accountId);
    
    /**
     * Check if the payment processor is available
     * @return true if available, false otherwise
     */
    boolean isAvailable();
    
    /**
     * Modern payment request class
     */
    class PaymentRequest {
        private final String accountId;
        private final BigDecimal amount;
        private final String currency;
        private final String description;
        
        public PaymentRequest(String accountId, BigDecimal amount, String currency, String description) {
            this.accountId = accountId;
            this.amount = amount;
            this.currency = currency;
            this.description = description;
        }
        
        public String getAccountId() {
            return accountId;
        }
        
        public BigDecimal getAmount() {
            return amount;
        }
        
        public String getCurrency() {
            return currency;
        }
        
        public String getDescription() {
            return description;
        }
        
        @Override
        public String toString() {
            return String.format("PaymentRequest{accountId='%s', amount=%s, currency='%s', description='%s'}", 
                accountId, amount, currency, description);
        }
    }
    
    /**
     * Modern payment response class
     */
    class PaymentResponse {
        private final boolean success;
        private final String transactionId;
        private final String message;
        private final long timestamp;
        
        public PaymentResponse(boolean success, String transactionId, String message) {
            this.success = success;
            this.transactionId = transactionId;
            this.message = message;
            this.timestamp = System.currentTimeMillis();
        }
        
        public boolean isSuccess() {
            return success;
        }
        
        public String getTransactionId() {
            return transactionId;
        }
        
        public String getMessage() {
            return message;
        }
        
        public long getTimestamp() {
            return timestamp;
        }
        
        @Override
        public String toString() {
            return String.format("PaymentResponse{success=%s, transactionId='%s', message='%s', timestamp=%d}", 
                success, transactionId, message, timestamp);
        }
    }
    
    /**
     * Modern account balance class
     */
    class AccountBalance {
        private final String accountId;
        private final BigDecimal balance;
        private final String currency;
        private final long lastUpdated;
        
        public AccountBalance(String accountId, BigDecimal balance, String currency) {
            this.accountId = accountId;
            this.balance = balance;
            this.currency = currency;
            this.lastUpdated = System.currentTimeMillis();
        }
        
        public String getAccountId() {
            return accountId;
        }
        
        public BigDecimal getBalance() {
            return balance;
        }
        
        public String getCurrency() {
            return currency;
        }
        
        public long getLastUpdated() {
            return lastUpdated;
        }
        
        @Override
        public String toString() {
            return String.format("AccountBalance{accountId='%s', balance=%s, currency='%s', lastUpdated=%d}", 
                accountId, balance, currency, lastUpdated);
        }
    }
} 
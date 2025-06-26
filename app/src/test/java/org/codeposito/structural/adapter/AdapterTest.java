package org.codeposito.structural.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

/**
 * Comprehensive tests for the Adapter pattern implementation
 */
@DisplayName("Adapter Pattern Tests")
class AdapterTest {
    
    private LegacyPaymentSystem legacySystem;
    private LegacyPaymentAdapter adapter;
    private ModernPaymentService paymentService;
    
    @BeforeEach
    void setUp() {
        legacySystem = new LegacyPaymentSystem();
        adapter = new LegacyPaymentAdapter(legacySystem);
        paymentService = new ModernPaymentService(adapter);
    }
    
    @Test
    @DisplayName("Adapter should implement ModernPaymentProcessor interface")
    void testAdapterImplementsInterface() {
        assertTrue(adapter instanceof ModernPaymentProcessor);
    }
    
    @Test
    @DisplayName("Adapter should be available")
    void testAdapterAvailability() {
        assertTrue(adapter.isAvailable());
        assertTrue(paymentService.isServiceAvailable());
    }
    
    @Test
    @DisplayName("Successful payment should return success response")
    void testSuccessfulPayment() {
        ModernPaymentProcessor.PaymentRequest request = 
            new ModernPaymentProcessor.PaymentRequest("1234", new BigDecimal("15.00"), "USD", "Test payment");
        
        ModernPaymentProcessor.PaymentResponse response = adapter.processPayment(request);
        
        assertTrue(response.isSuccess());
        assertNotNull(response.getTransactionId());
        assertTrue(response.getTransactionId().startsWith("TXN-"));
        assertEquals("Payment processed successfully", response.getMessage());
        assertTrue(response.getTimestamp() > 0);
    }
    
    @Test
    @DisplayName("Failed payment should return failure response")
    void testFailedPayment() {
        ModernPaymentProcessor.PaymentRequest request = 
            new ModernPaymentProcessor.PaymentRequest("1234", new BigDecimal("-10.00"), "USD", "Invalid payment");
        
        ModernPaymentProcessor.PaymentResponse response = adapter.processPayment(request);
        
        assertFalse(response.isSuccess());
        assertNull(response.getTransactionId());
        assertEquals("Payment failed - invalid amount", response.getMessage());
    }
    
    @Test
    @DisplayName("Account balance should be converted correctly")
    void testAccountBalance() {
        ModernPaymentProcessor.AccountBalance balance = adapter.getAccountBalance("1234");
        
        assertEquals("1234", balance.getAccountId());
        assertEquals(new BigDecimal("500.00"), balance.getBalance());
        assertEquals("USD", balance.getCurrency());
        assertTrue(balance.getLastUpdated() > 0);
    }
    
    @Test
    @DisplayName("Payment service should process payments correctly")
    void testPaymentServicePayment() {
        ModernPaymentProcessor.PaymentResponse response = 
            paymentService.makePayment("5678", new BigDecimal("25.50"), "USD", "Service test");
        
        assertTrue(response.isSuccess());
        assertNotNull(response.getTransactionId());
    }
    
    @Test
    @DisplayName("Payment service should get balance correctly")
    void testPaymentServiceBalance() {
        ModernPaymentProcessor.AccountBalance balance = paymentService.getBalance("5678");
        
        assertEquals("5678", balance.getAccountId());
        assertEquals(new BigDecimal("500.00"), balance.getBalance());
        assertEquals("USD", balance.getCurrency());
    }
    
    @Test
    @DisplayName("Account number conversion should work correctly")
    void testAccountNumberConversion() {
        // Test through the adapter by making a payment
        ModernPaymentProcessor.PaymentRequest request = 
            new ModernPaymentProcessor.PaymentRequest("123", new BigDecimal("10.00"), "USD", "Test");
        
        ModernPaymentProcessor.PaymentResponse response = adapter.processPayment(request);
        
        // If conversion works, payment should succeed
        assertTrue(response.isSuccess());
    }
    
    @Test
    @DisplayName("Amount conversion should work correctly")
    void testAmountConversion() {
        // Test different amounts
        BigDecimal[] amounts = {
            new BigDecimal("0.01"),  // 1 cent
            new BigDecimal("1.00"),  // 1 dollar
            new BigDecimal("99.99"), // 99.99 dollars
            new BigDecimal("1000.00") // 1000 dollars
        };
        
        for (BigDecimal amount : amounts) {
            ModernPaymentProcessor.PaymentRequest request = 
                new ModernPaymentProcessor.PaymentRequest("1234", amount, "USD", "Amount test");
            
            ModernPaymentProcessor.PaymentResponse response = adapter.processPayment(request);
            
            // All valid amounts should succeed
            assertTrue(response.isSuccess(), "Payment should succeed for amount: " + amount);
        }
    }
    
    @Test
    @DisplayName("Currency conversion should work correctly")
    void testCurrencyConversion() {
        String[] currencies = {"USD", "EUR", "GBP", "JPY"};
        
        for (String currency : currencies) {
            ModernPaymentProcessor.PaymentRequest request = 
                new ModernPaymentProcessor.PaymentRequest("1234", new BigDecimal("10.00"), currency, "Currency test");
            
            ModernPaymentProcessor.PaymentResponse response = adapter.processPayment(request);
            
            // All valid currencies should succeed
            assertTrue(response.isSuccess(), "Payment should succeed for currency: " + currency);
        }
    }
    
    @Test
    @DisplayName("Large amount should be rejected")
    void testLargeAmountRejection() {
        ModernPaymentProcessor.PaymentRequest request = 
            new ModernPaymentProcessor.PaymentRequest("1234", new BigDecimal("15000.00"), "USD", "Large amount");
        
        ModernPaymentProcessor.PaymentResponse response = adapter.processPayment(request);
        
        assertFalse(response.isSuccess());
        assertEquals("Payment failed - invalid amount", response.getMessage());
    }
    
    @Test
    @DisplayName("Zero amount should be rejected")
    void testZeroAmountRejection() {
        ModernPaymentProcessor.PaymentRequest request = 
            new ModernPaymentProcessor.PaymentRequest("1234", new BigDecimal("0.00"), "USD", "Zero amount");
        
        ModernPaymentProcessor.PaymentResponse response = adapter.processPayment(request);
        
        assertFalse(response.isSuccess());
        assertEquals("Payment failed - invalid amount", response.getMessage());
    }
    
    @Test
    @DisplayName("Request and response objects should have correct toString methods")
    void testToStringMethods() {
        ModernPaymentProcessor.PaymentRequest request = 
            new ModernPaymentProcessor.PaymentRequest("1234", new BigDecimal("15.00"), "USD", "Test payment");
        
        ModernPaymentProcessor.PaymentResponse response = adapter.processPayment(request);
        
        // Test toString methods
        assertTrue(request.toString().contains("1234"));
        assertTrue(request.toString().contains("15.00"));
        assertTrue(request.toString().contains("USD"));
        assertTrue(request.toString().contains("Test payment"));
        
        assertTrue(response.toString().contains("success=true"));
        assertTrue(response.toString().contains("TXN-"));
        assertTrue(response.toString().contains("Payment processed successfully"));
    }
    
    @Test
    @DisplayName("Account balance object should have correct toString method")
    void testAccountBalanceToString() {
        ModernPaymentProcessor.AccountBalance balance = adapter.getAccountBalance("1234");
        
        assertTrue(balance.toString().contains("1234"));
        assertTrue(balance.toString().contains("500.00"));
        assertTrue(balance.toString().contains("USD"));
    }
} 
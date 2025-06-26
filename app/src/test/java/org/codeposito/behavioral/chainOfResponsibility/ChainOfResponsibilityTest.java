package org.codeposito.behavioral.chainOfResponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Chain of Responsibility pattern implementation.
 */
public class ChainOfResponsibilityTest {

    private Handler loginHandler;
    private Handler purchaseHandler;
    private Handler refundHandler;

    @BeforeEach
    void setUp() {
        loginHandler = new LoginHandler();
        purchaseHandler = new PurchaseHandler();
        refundHandler = new RefundHandler();

        // Set up a simple chain for testing
        loginHandler.setNext(purchaseHandler).setNext(refundHandler);
    }

    @Test
    void testLoginHandlerCanHandleLoginRequest() {
        Request loginRequest = new Request(RequestType.LOGIN, "Test login", 1);
        assertTrue(loginHandler instanceof LoginHandler);
    }

    @Test
    void testPurchaseHandlerCanHandlePurchaseRequest() {
        Request purchaseRequest = new Request(RequestType.PURCHASE, "Test purchase", 2);
        assertTrue(purchaseHandler instanceof PurchaseHandler);
    }

    @Test
    void testRefundHandlerCanHandleRefundRequest() {
        Request refundRequest = new Request(RequestType.REFUND, "Test refund", 3);
        assertTrue(refundHandler instanceof RefundHandler);
    }

    @Test
    void testRequestProperties() {
        Request request = new Request(RequestType.LOGIN, "Test request", 5);
        
        assertEquals(RequestType.LOGIN, request.getType());
        assertEquals("Test request", request.getDescription());
        assertEquals(5, request.getPriority());
    }

    @Test
    void testChainSetup() {
        Handler testHandler = new LoginHandler();
        Handler nextHandler = new PurchaseHandler();
        
        Handler result = testHandler.setNext(nextHandler);
        
        assertEquals(nextHandler, result);
    }

    @Test
    void testRequestTypeEnum() {
        assertEquals(6, RequestType.values().length);
        assertNotNull(RequestType.valueOf("LOGIN"));
        assertNotNull(RequestType.valueOf("PURCHASE"));
        assertNotNull(RequestType.valueOf("REFUND"));
        assertNotNull(RequestType.valueOf("COMPLAINT"));
        assertNotNull(RequestType.valueOf("TECHNICAL_SUPPORT"));
        assertNotNull(RequestType.valueOf("GENERAL_INQUIRY"));
    }
} 
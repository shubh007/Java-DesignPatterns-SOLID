package org.codeposito.structural.proxy.logging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoggingProxyTest {
    private Calculator realCalculator;
    private Calculator loggingProxy;

    @BeforeEach
    void setUp() {
        realCalculator = new SimpleCalculator();
        loggingProxy = new LoggingCalculatorProxy(realCalculator);
    }

    @Test
    void addTest() {
        assertEquals(8, loggingProxy.add(5, 3));
    }

    @Test
    void subtractTest() {
        assertEquals(6, loggingProxy.subtract(10, 4));
    }

    @Test
    void multiplyTest() {
        assertEquals(42, loggingProxy.multiply(6, 7));
    }

    @Test
    void divideTest() {
        assertEquals(4, loggingProxy.divide(20, 5));
    }

    @Test
    void divideByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> loggingProxy.divide(10, 0));
    }
} 
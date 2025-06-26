package org.codeposito.structural.proxy.logging;

public class LoggingProxyClient {
    public static void main(String[] args) {
        System.out.println("=== Logging Proxy Pattern Demo ===\n");
        Calculator realCalculator = new SimpleCalculator();
        Calculator loggingProxy = new LoggingCalculatorProxy(realCalculator);

        loggingProxy.add(5, 3);
        loggingProxy.subtract(10, 4);
        loggingProxy.multiply(6, 7);
        loggingProxy.divide(20, 5);

        System.out.println("\n=== Logging Proxy Pattern Demo Complete ===");
    }
} 
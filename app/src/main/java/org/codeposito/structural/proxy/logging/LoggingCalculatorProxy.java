package org.codeposito.structural.proxy.logging;

public class LoggingCalculatorProxy implements Calculator {
    private final Calculator realCalculator;

    public LoggingCalculatorProxy(Calculator realCalculator) {
        this.realCalculator = realCalculator;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("[LOG] add(" + a + ", " + b + ")");
        int result = realCalculator.add(a, b);
        System.out.println("[LOG] Result: " + result);
        return result;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("[LOG] subtract(" + a + ", " + b + ")");
        int result = realCalculator.subtract(a, b);
        System.out.println("[LOG] Result: " + result);
        return result;
    }

    @Override
    public int multiply(int a, int b) {
        System.out.println("[LOG] multiply(" + a + ", " + b + ")");
        int result = realCalculator.multiply(a, b);
        System.out.println("[LOG] Result: " + result);
        return result;
    }

    @Override
    public int divide(int a, int b) {
        System.out.println("[LOG] divide(" + a + ", " + b + ")");
        int result = realCalculator.divide(a, b);
        System.out.println("[LOG] Result: " + result);
        return result;
    }
} 
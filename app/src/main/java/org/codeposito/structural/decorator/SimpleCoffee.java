package org.codeposito.structural.decorator;

/**
 * SimpleCoffee - the ConcreteComponent in the Decorator pattern.
 * Represents a basic coffee without any add-ons.
 */
public class SimpleCoffee implements Coffee {
    
    private final String name;
    private final double baseCost;
    private final int basePreparationTime;
    
    public SimpleCoffee(String name, double baseCost, int basePreparationTime) {
        this.name = name;
        this.baseCost = baseCost;
        this.basePreparationTime = basePreparationTime;
    }
    
    @Override
    public double getCost() {
        return baseCost;
    }
    
    @Override
    public String getDescription() {
        return name;
    }
    
    @Override
    public int getPreparationTime() {
        return basePreparationTime;
    }
} 
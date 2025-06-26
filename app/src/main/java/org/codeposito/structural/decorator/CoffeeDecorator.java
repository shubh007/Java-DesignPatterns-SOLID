package org.codeposito.structural.decorator;

/**
 * CoffeeDecorator - the abstract Decorator class in the Decorator pattern.
 * Provides the base functionality for all coffee decorators.
 * Implements the Coffee interface and holds a reference to a Coffee object.
 */
public abstract class CoffeeDecorator implements Coffee {
    
    protected final Coffee coffee;
    
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    
    @Override
    public double getCost() {
        return coffee.getCost();
    }
    
    @Override
    public String getDescription() {
        return coffee.getDescription();
    }
    
    @Override
    public int getPreparationTime() {
        return coffee.getPreparationTime();
    }
} 
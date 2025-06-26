package org.codeposito.structural.decorator;

/**
 * SugarDecorator - a ConcreteDecorator that adds sugar to coffee.
 * Extends the functionality of any coffee by adding sugar.
 */
public class SugarDecorator extends CoffeeDecorator {
    
    private static final double SUGAR_COST = 0.25;
    private static final int SUGAR_PREPARATION_TIME = 1;
    
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double getCost() {
        return coffee.getCost() + SUGAR_COST;
    }
    
    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Sugar";
    }
    
    @Override
    public int getPreparationTime() {
        return coffee.getPreparationTime() + SUGAR_PREPARATION_TIME;
    }
} 
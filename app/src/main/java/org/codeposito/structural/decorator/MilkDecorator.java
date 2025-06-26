package org.codeposito.structural.decorator;

/**
 * MilkDecorator - a ConcreteDecorator that adds milk to coffee.
 * Extends the functionality of any coffee by adding milk.
 */
public class MilkDecorator extends CoffeeDecorator {
    
    private static final double MILK_COST = 0.50;
    private static final int MILK_PREPARATION_TIME = 1;
    
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double getCost() {
        return coffee.getCost() + MILK_COST;
    }
    
    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Milk";
    }
    
    @Override
    public int getPreparationTime() {
        return coffee.getPreparationTime() + MILK_PREPARATION_TIME;
    }
} 
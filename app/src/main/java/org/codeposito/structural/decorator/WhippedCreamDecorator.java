package org.codeposito.structural.decorator;

/**
 * WhippedCreamDecorator - a ConcreteDecorator that adds whipped cream to coffee.
 * Extends the functionality of any coffee by adding whipped cream.
 */
public class WhippedCreamDecorator extends CoffeeDecorator {
    
    private static final double WHIPPED_CREAM_COST = 0.75;
    private static final int WHIPPED_CREAM_PREPARATION_TIME = 2;
    
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double getCost() {
        return coffee.getCost() + WHIPPED_CREAM_COST;
    }
    
    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Whipped Cream";
    }
    
    @Override
    public int getPreparationTime() {
        return coffee.getPreparationTime() + WHIPPED_CREAM_PREPARATION_TIME;
    }
} 
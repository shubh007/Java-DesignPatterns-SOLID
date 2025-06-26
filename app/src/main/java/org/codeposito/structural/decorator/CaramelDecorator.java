package org.codeposito.structural.decorator;

/**
 * CaramelDecorator - a ConcreteDecorator that adds caramel to coffee.
 * Extends the functionality of any coffee by adding caramel.
 */
public class CaramelDecorator extends CoffeeDecorator {
    
    private static final double CARAMEL_COST = 1.00;
    private static final int CARAMEL_PREPARATION_TIME = 2;
    
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double getCost() {
        return coffee.getCost() + CARAMEL_COST;
    }
    
    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Caramel";
    }
    
    @Override
    public int getPreparationTime() {
        return coffee.getPreparationTime() + CARAMEL_PREPARATION_TIME;
    }
} 
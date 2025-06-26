package org.codeposito.structural.decorator;

/**
 * Coffee interface - the Component in the Decorator pattern.
 * Defines the common contract for all coffee types and decorators.
 */
public interface Coffee {
    
    /**
     * Get the cost of the coffee.
     * @return the cost in dollars
     */
    double getCost();
    
    /**
     * Get the description of the coffee.
     * @return the description string
     */
    String getDescription();
    
    /**
     * Get the preparation time in minutes.
     * @return preparation time
     */
    int getPreparationTime();
} 
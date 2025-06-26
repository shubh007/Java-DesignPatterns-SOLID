package org.codeposito.structural.decorator;

/**
 * CoffeeShop - utility class for creating different coffee types.
 * Demonstrates the decorator pattern by creating various coffee combinations.
 */
public class CoffeeShop {
    
    // Predefined coffee types
    public static final Coffee ESPRESSO = new SimpleCoffee("Espresso", 2.50, 3);
    public static final Coffee AMERICANO = new SimpleCoffee("Americano", 3.00, 4);
    public static final Coffee CAPPUCCINO = new SimpleCoffee("Cappuccino", 4.00, 5);
    public static final Coffee LATTE = new SimpleCoffee("Latte", 4.50, 6);
    public static final Coffee MOCHA = new SimpleCoffee("Mocha", 5.00, 7);
    
    /**
     * Create a coffee with milk.
     * @param coffee the base coffee
     * @return coffee with milk
     */
    public static Coffee withMilk(Coffee coffee) {
        return new MilkDecorator(coffee);
    }
    
    /**
     * Create a coffee with sugar.
     * @param coffee the base coffee
     * @return coffee with sugar
     */
    public static Coffee withSugar(Coffee coffee) {
        return new SugarDecorator(coffee);
    }
    
    /**
     * Create a coffee with whipped cream.
     * @param coffee the base coffee
     * @return coffee with whipped cream
     */
    public static Coffee withWhippedCream(Coffee coffee) {
        return new WhippedCreamDecorator(coffee);
    }
    
    /**
     * Create a coffee with caramel.
     * @param coffee the base coffee
     * @return coffee with caramel
     */
    public static Coffee withCaramel(Coffee coffee) {
        return new CaramelDecorator(coffee);
    }
    
    /**
     * Create a coffee with multiple add-ons.
     * @param coffee the base coffee
     * @param addMilk whether to add milk
     * @param addSugar whether to add sugar
     * @param addWhippedCream whether to add whipped cream
     * @param addCaramel whether to add caramel
     * @return decorated coffee
     */
    public static Coffee customize(Coffee coffee, boolean addMilk, boolean addSugar, 
                                 boolean addWhippedCream, boolean addCaramel) {
        Coffee customized = coffee;
        
        if (addMilk) {
            customized = new MilkDecorator(customized);
        }
        if (addSugar) {
            customized = new SugarDecorator(customized);
        }
        if (addWhippedCream) {
            customized = new WhippedCreamDecorator(customized);
        }
        if (addCaramel) {
            customized = new CaramelDecorator(customized);
        }
        
        return customized;
    }
    
    /**
     * Print coffee details in a formatted way.
     * @param coffee the coffee to print
     */
    public static void printCoffeeDetails(Coffee coffee) {
        System.out.printf("☕ %s%n", coffee.getDescription());
        System.out.printf("   Cost: $%.2f%n", coffee.getCost());
        System.out.printf("   Preparation Time: %d minutes%n", coffee.getPreparationTime());
        System.out.println();
    }
} 
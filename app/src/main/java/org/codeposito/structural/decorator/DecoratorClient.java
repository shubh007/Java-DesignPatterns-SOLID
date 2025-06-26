package org.codeposito.structural.decorator;

/**
 * DecoratorClient - demonstrates the Decorator pattern with coffee shop example.
 * Shows how decorators can be combined to create complex objects from simple ones.
 */
public class DecoratorClient {
    
    public static void main(String[] args) {
        System.out.println("=== Coffee Shop - Decorator Pattern Demo ===\n");
        
        // Demonstrate basic coffee types
        System.out.println("1. Basic Coffee Types:");
        System.out.println("======================");
        CoffeeShop.printCoffeeDetails(CoffeeShop.ESPRESSO);
        CoffeeShop.printCoffeeDetails(CoffeeShop.AMERICANO);
        CoffeeShop.printCoffeeDetails(CoffeeShop.CAPPUCCINO);
        
        // Demonstrate single decorators
        System.out.println("2. Coffee with Single Add-ons:");
        System.out.println("==============================");
        CoffeeShop.printCoffeeDetails(CoffeeShop.withMilk(CoffeeShop.ESPRESSO));
        CoffeeShop.printCoffeeDetails(CoffeeShop.withSugar(CoffeeShop.AMERICANO));
        CoffeeShop.printCoffeeDetails(CoffeeShop.withWhippedCream(CoffeeShop.CAPPUCCINO));
        CoffeeShop.printCoffeeDetails(CoffeeShop.withCaramel(CoffeeShop.LATTE));
        
        // Demonstrate multiple decorators
        System.out.println("3. Coffee with Multiple Add-ons:");
        System.out.println("================================");
        CoffeeShop.printCoffeeDetails(CoffeeShop.withMilk(CoffeeShop.withSugar(CoffeeShop.ESPRESSO)));
        CoffeeShop.printCoffeeDetails(CoffeeShop.withWhippedCream(CoffeeShop.withCaramel(CoffeeShop.LATTE)));
        
        // Demonstrate complex combinations
        System.out.println("4. Complex Coffee Combinations:");
        System.out.println("===============================");
        Coffee complexCoffee = CoffeeShop.withMilk(
            CoffeeShop.withSugar(
                CoffeeShop.withWhippedCream(
                    CoffeeShop.withCaramel(CoffeeShop.MOCHA)
                )
            )
        );
        CoffeeShop.printCoffeeDetails(complexCoffee);
        
        // Demonstrate using the customize method
        System.out.println("5. Customized Coffee Orders:");
        System.out.println("============================");
        Coffee customized1 = CoffeeShop.customize(CoffeeShop.ESPRESSO, true, true, false, false);
        Coffee customized2 = CoffeeShop.customize(CoffeeShop.LATTE, false, false, true, true);
        CoffeeShop.printCoffeeDetails(customized1);
        CoffeeShop.printCoffeeDetails(customized2);
        
        // Demonstrate decorator flexibility
        System.out.println("6. Decorator Flexibility:");
        System.out.println("========================");
        Coffee baseCoffee = CoffeeShop.AMERICANO;
        System.out.println("Base coffee:");
        CoffeeShop.printCoffeeDetails(baseCoffee);
        
        // Add decorators dynamically
        Coffee withMilk = CoffeeShop.withMilk(baseCoffee);
        System.out.println("After adding milk:");
        CoffeeShop.printCoffeeDetails(withMilk);
        
        Coffee withMilkAndSugar = CoffeeShop.withSugar(withMilk);
        System.out.println("After adding sugar:");
        CoffeeShop.printCoffeeDetails(withMilkAndSugar);
        
        Coffee withMilkSugarAndCream = CoffeeShop.withWhippedCream(withMilkAndSugar);
        System.out.println("After adding whipped cream:");
        CoffeeShop.printCoffeeDetails(withMilkSugarAndCream);
        
        // Demonstrate cost calculation
        System.out.println("7. Cost Analysis:");
        System.out.println("================");
        System.out.printf("Base Espresso: $%.2f%n", CoffeeShop.ESPRESSO.getCost());
        System.out.printf("Espresso + Milk: $%.2f%n", CoffeeShop.withMilk(CoffeeShop.ESPRESSO).getCost());
        System.out.printf("Espresso + Milk + Sugar: $%.2f%n", 
            CoffeeShop.withSugar(CoffeeShop.withMilk(CoffeeShop.ESPRESSO)).getCost());
        System.out.printf("Espresso + Milk + Sugar + Whipped Cream: $%.2f%n", 
            CoffeeShop.withWhippedCream(CoffeeShop.withSugar(CoffeeShop.withMilk(CoffeeShop.ESPRESSO))).getCost());
        
        // Demonstrate preparation time
        System.out.println("\n8. Preparation Time Analysis:");
        System.out.println("============================");
        System.out.printf("Base Espresso: %d minutes%n", CoffeeShop.ESPRESSO.getPreparationTime());
        System.out.printf("Espresso + Milk: %d minutes%n", CoffeeShop.withMilk(CoffeeShop.ESPRESSO).getPreparationTime());
        System.out.printf("Espresso + Milk + Sugar: %d minutes%n", 
            CoffeeShop.withSugar(CoffeeShop.withMilk(CoffeeShop.ESPRESSO)).getPreparationTime());
        System.out.printf("Espresso + Milk + Sugar + Whipped Cream: %d minutes%n", 
            CoffeeShop.withWhippedCream(CoffeeShop.withSugar(CoffeeShop.withMilk(CoffeeShop.ESPRESSO))).getPreparationTime());
        
        System.out.println("\n=== Decorator Pattern Benefits ===");
        System.out.println("✅ Open/Closed Principle: New decorators can be added without modifying existing code");
        System.out.println("✅ Single Responsibility: Each decorator has one specific responsibility");
        System.out.println("✅ Flexibility: Decorators can be combined in any order");
        System.out.println("✅ Transparency: Clients treat decorated objects the same as base objects");
        System.out.println("✅ Dynamic Composition: Decorators can be added/removed at runtime");
    }
} 
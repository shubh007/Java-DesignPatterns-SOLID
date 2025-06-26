package org.codeposito.creational.builder;

// Step 5: Pizza Builder Client demonstrating different pizza configurations
public class PizzaClient {
    public static void main(String[] args) {
        System.out.println("=== Pizza Builder Pattern Demo ===\n");
        
        // Method 1: Building a simple pizza
        System.out.println("1. Building a simple Margherita pizza:");
        Pizza margherita = new PizzaBuilder()
                .size("Medium")
                .crust("Thin")
                .addToppings("Tomato", "Mozzarella", "Basil")
                .build();
        
        System.out.println("Margherita: " + margherita);
        
        // Method 2: Building a complex pizza with all options
        System.out.println("\n2. Building a complex Supreme pizza:");
        Pizza supreme = new PizzaBuilder()
                .size("Large")
                .crust("Thick")
                .addToppings("Pepperoni", "Sausage", "Mushrooms", "Bell Peppers", "Onions", "Olives")
                .extraCheese(true)
                .extraSauce(true)
                .sauceType("BBQ")
                .cheeseType("Cheddar")
                .stuffedCrust(true)
                .build();
        
        System.out.println("Supreme: " + supreme);
        
        // Method 3: Building a vegetarian pizza
        System.out.println("\n3. Building a vegetarian pizza:");
        Pizza vegetarian = new PizzaBuilder()
                .size("Medium")
                .crust("Whole Wheat")
                .addToppings("Mushrooms", "Bell Peppers", "Onions", "Tomatoes", "Spinach", "Artichokes")
                .extraCheese(true)
                .sauceType("Pesto")
                .cheeseType("Feta")
                .build();
        
        System.out.println("Vegetarian: " + vegetarian);
        
        // Method 4: Building a minimal pizza (using defaults)
        System.out.println("\n4. Building a minimal pizza with defaults:");
        Pizza minimal = new PizzaBuilder()
                .size("Small")
                .crust("Regular")
                .addTopping("Cheese")
                .build();
        
        System.out.println("Minimal: " + minimal);
        
        // Method 5: Demonstrating validation
        System.out.println("\n5. Demonstrating validation:");
        try {
            Pizza invalidPizza = new PizzaBuilder()
                    .addTopping("Pepperoni")
                    // Missing required size and crust
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
        
        // Method 6: Building multiple pizzas for an order
        System.out.println("\n6. Building multiple pizzas for an order:");
        Pizza[] order = {
            new PizzaBuilder()
                .size("Large")
                .crust("Thin")
                .addToppings("Pepperoni", "Mushrooms")
                .extraCheese(true)
                .build(),
                
            new PizzaBuilder()
                .size("Medium")
                .crust("Stuffed")
                .addToppings("Chicken", "Bacon", "Ranch")
                .sauceType("Ranch")
                .build(),
                
            new PizzaBuilder()
                .size("Small")
                .crust("Regular")
                .addTopping("Cheese")
                .build()
        };
        
        for (int i = 0; i < order.length; i++) {
            System.out.println("Pizza " + (i + 1) + ": " + order[i]);
        }
    }
} 
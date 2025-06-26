package org.codeposito.creational.builder;

// Step 3: Separate Builder class for Pizza
public class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder() {
        pizza = new Pizza();
    }

    public PizzaBuilder size(String size) {
        pizza.setSize(size);
        return this;
    }

    public PizzaBuilder crust(String crust) {
        pizza.setCrust(crust);
        return this;
    }

    public PizzaBuilder addTopping(String topping) {
        pizza.addTopping(topping);
        return this;
    }

    public PizzaBuilder addToppings(String... toppings) {
        for (String topping : toppings) {
            pizza.addTopping(topping);
        }
        return this;
    }

    public PizzaBuilder extraCheese(boolean extraCheese) {
        pizza.setExtraCheese(extraCheese);
        return this;
    }

    public PizzaBuilder extraSauce(boolean extraSauce) {
        pizza.setExtraSauce(extraSauce);
        return this;
    }

    public PizzaBuilder sauceType(String sauceType) {
        pizza.setSauceType(sauceType);
        return this;
    }

    public PizzaBuilder cheeseType(String cheeseType) {
        pizza.setCheeseType(cheeseType);
        return this;
    }

    public PizzaBuilder stuffedCrust(boolean stuffedCrust) {
        pizza.setStuffedCrust(stuffedCrust);
        return this;
    }

    public Pizza build() {
        // Validation
        if (pizza.getSize() == null) {
            throw new IllegalStateException("Pizza size is required");
        }
        if (pizza.getCrust() == null) {
            throw new IllegalStateException("Pizza crust is required");
        }
        
        // Set defaults
        if (pizza.getSauceType() == null) {
            pizza.setSauceType("Tomato");
        }
        if (pizza.getCheeseType() == null) {
            pizza.setCheeseType("Mozzarella");
        }
        
        return pizza;
    }
} 
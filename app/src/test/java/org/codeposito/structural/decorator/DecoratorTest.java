package org.codeposito.structural.decorator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Decorator pattern implementation.
 * Tests all decorators and their combinations.
 */
public class DecoratorTest {
    
    private Coffee espresso;
    private Coffee americano;
    private Coffee latte;
    
    @BeforeEach
    void setUp() {
        espresso = CoffeeShop.ESPRESSO;
        americano = CoffeeShop.AMERICANO;
        latte = CoffeeShop.LATTE;
    }
    
    @Test
    void testBasicCoffee() {
        assertEquals("Espresso", espresso.getDescription());
        assertEquals(2.50, espresso.getCost(), 0.01);
        assertEquals(3, espresso.getPreparationTime());
        
        assertEquals("Americano", americano.getDescription());
        assertEquals(3.00, americano.getCost(), 0.01);
        assertEquals(4, americano.getPreparationTime());
    }
    
    @Test
    void testMilkDecorator() {
        Coffee coffeeWithMilk = CoffeeShop.withMilk(espresso);
        
        assertEquals("Espresso + Milk", coffeeWithMilk.getDescription());
        assertEquals(3.00, coffeeWithMilk.getCost(), 0.01); // 2.50 + 0.50
        assertEquals(4, coffeeWithMilk.getPreparationTime()); // 3 + 1
    }
    
    @Test
    void testSugarDecorator() {
        Coffee coffeeWithSugar = CoffeeShop.withSugar(americano);
        
        assertEquals("Americano + Sugar", coffeeWithSugar.getDescription());
        assertEquals(3.25, coffeeWithSugar.getCost(), 0.01); // 3.00 + 0.25
        assertEquals(5, coffeeWithSugar.getPreparationTime()); // 4 + 1
    }
    
    @Test
    void testWhippedCreamDecorator() {
        Coffee coffeeWithCream = CoffeeShop.withWhippedCream(latte);
        
        assertEquals("Latte + Whipped Cream", coffeeWithCream.getDescription());
        assertEquals(5.25, coffeeWithCream.getCost(), 0.01); // 4.50 + 0.75
        assertEquals(8, coffeeWithCream.getPreparationTime()); // 6 + 2
    }
    
    @Test
    void testCaramelDecorator() {
        Coffee coffeeWithCaramel = CoffeeShop.withCaramel(espresso);
        
        assertEquals("Espresso + Caramel", coffeeWithCaramel.getDescription());
        assertEquals(3.50, coffeeWithCaramel.getCost(), 0.01); // 2.50 + 1.00
        assertEquals(5, coffeeWithCaramel.getPreparationTime()); // 3 + 2
    }
    
    @Test
    void testMultipleDecorators() {
        Coffee complexCoffee = CoffeeShop.withMilk(
            CoffeeShop.withSugar(
                CoffeeShop.withWhippedCream(espresso)
            )
        );
        
        assertEquals("Espresso + Whipped Cream + Sugar + Milk", complexCoffee.getDescription());
        assertEquals(4.00, complexCoffee.getCost(), 0.01); // 2.50 + 0.75 + 0.25 + 0.50
        assertEquals(7, complexCoffee.getPreparationTime()); // 3 + 2 + 1 + 1
    }
    
    @Test
    void testCustomizeMethod() {
        Coffee customized = CoffeeShop.customize(espresso, true, true, false, true);
        
        assertEquals("Espresso + Milk + Sugar + Caramel", customized.getDescription());
        assertEquals(4.25, customized.getCost(), 0.01); // 2.50 + 0.50 + 0.25 + 1.00
        assertEquals(7, customized.getPreparationTime()); // 3 + 1 + 1 + 2
    }
    
    @Test
    void testCustomizeMethodNoAddons() {
        Coffee customized = CoffeeShop.customize(espresso, false, false, false, false);
        
        assertEquals("Espresso", customized.getDescription());
        assertEquals(2.50, customized.getCost(), 0.01);
        assertEquals(3, customized.getPreparationTime());
    }
    
    @Test
    void testDecoratorChaining() {
        Coffee coffee = espresso;
        
        // Add milk
        coffee = CoffeeShop.withMilk(coffee);
        assertEquals("Espresso + Milk", coffee.getDescription());
        assertEquals(3.00, coffee.getCost(), 0.01);
        
        // Add sugar
        coffee = CoffeeShop.withSugar(coffee);
        assertEquals("Espresso + Milk + Sugar", coffee.getDescription());
        assertEquals(3.25, coffee.getCost(), 0.01);
        
        // Add whipped cream
        coffee = CoffeeShop.withWhippedCream(coffee);
        assertEquals("Espresso + Milk + Sugar + Whipped Cream", coffee.getDescription());
        assertEquals(4.00, coffee.getCost(), 0.01);
        
        // Add caramel
        coffee = CoffeeShop.withCaramel(coffee);
        assertEquals("Espresso + Milk + Sugar + Whipped Cream + Caramel", coffee.getDescription());
        assertEquals(5.00, coffee.getCost(), 0.01);
    }
    
    @Test
    void testDifferentBaseCoffees() {
        // Test with different base coffees
        Coffee[] baseCoffees = {espresso, americano, latte, CoffeeShop.CAPPUCCINO, CoffeeShop.MOCHA};
        
        for (Coffee baseCoffee : baseCoffees) {
            Coffee decorated = CoffeeShop.withMilk(CoffeeShop.withSugar(baseCoffee));
            
            // Verify the decorators are applied correctly
            assertTrue(decorated.getDescription().contains(" + Milk"));
            assertTrue(decorated.getDescription().contains(" + Sugar"));
            assertTrue(decorated.getCost() > baseCoffee.getCost());
            assertTrue(decorated.getPreparationTime() > baseCoffee.getPreparationTime());
        }
    }
    
    @Test
    void testDecoratorTransparency() {
        // Test that decorated objects can be used anywhere a base coffee can be used
        Coffee baseCoffee = espresso;
        Coffee decoratedCoffee = CoffeeShop.withMilk(CoffeeShop.withSugar(baseCoffee));
        
        // Both should implement the Coffee interface
        assertTrue(baseCoffee instanceof Coffee);
        assertTrue(decoratedCoffee instanceof Coffee);
        
        // Both should have the same methods
        assertNotNull(baseCoffee.getDescription());
        assertNotNull(decoratedCoffee.getDescription());
        assertTrue(baseCoffee.getCost() >= 0);
        assertTrue(decoratedCoffee.getCost() >= 0);
        assertTrue(baseCoffee.getPreparationTime() >= 0);
        assertTrue(decoratedCoffee.getPreparationTime() >= 0);
    }
    
    @Test
    void testCostCalculationAccuracy() {
        // Test that cost calculations are accurate
        double baseCost = espresso.getCost();
        
        Coffee withMilk = CoffeeShop.withMilk(espresso);
        assertEquals(baseCost + 0.50, withMilk.getCost(), 0.01);
        
        Coffee withSugar = CoffeeShop.withSugar(espresso);
        assertEquals(baseCost + 0.25, withSugar.getCost(), 0.01);
        
        Coffee withCream = CoffeeShop.withWhippedCream(espresso);
        assertEquals(baseCost + 0.75, withCream.getCost(), 0.01);
        
        Coffee withCaramel = CoffeeShop.withCaramel(espresso);
        assertEquals(baseCost + 1.00, withCaramel.getCost(), 0.01);
    }
    
    @Test
    void testPreparationTimeCalculationAccuracy() {
        // Test that preparation time calculations are accurate
        int baseTime = espresso.getPreparationTime();
        
        Coffee withMilk = CoffeeShop.withMilk(espresso);
        assertEquals(baseTime + 1, withMilk.getPreparationTime());
        
        Coffee withSugar = CoffeeShop.withSugar(espresso);
        assertEquals(baseTime + 1, withSugar.getPreparationTime());
        
        Coffee withCream = CoffeeShop.withWhippedCream(espresso);
        assertEquals(baseTime + 2, withCream.getPreparationTime());
        
        Coffee withCaramel = CoffeeShop.withCaramel(espresso);
        assertEquals(baseTime + 2, withCaramel.getPreparationTime());
    }
} 
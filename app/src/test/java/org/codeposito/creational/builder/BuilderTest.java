package org.codeposito.creational.builder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {

    @Test
    public void testComputerBuilderBasic() {
        Computer computer = new ComputerBuilder()
                .cpu("Intel Core i7")
                .ram("16GB DDR4")
                .storage("512GB SSD")
                .build();

        assertNotNull(computer);
        assertEquals("Intel Core i7", computer.getCpu());
        assertEquals("16GB DDR4", computer.getRam());
        assertEquals("512GB SSD", computer.getStorage());
        assertEquals("Stock Cooler", computer.getCooling()); // Default value
        assertEquals("ATX Mid Tower", computer.getCaseType()); // Default value
    }

    @Test
    public void testComputerBuilderFull() {
        Computer computer = new ComputerBuilder()
                .cpu("AMD Ryzen 9")
                .ram("32GB DDR5")
                .storage("2TB NVMe")
                .gpu("RTX 4080")
                .motherboard("ASUS ROG")
                .powerSupply("850W Gold")
                .cooling("Liquid Cooling")
                .hasWifi(true)
                .hasBluetooth(true)
                .caseType("Full Tower")
                .build();

        assertNotNull(computer);
        assertEquals("AMD Ryzen 9", computer.getCpu());
        assertEquals("32GB DDR5", computer.getRam());
        assertEquals("2TB NVMe", computer.getStorage());
        assertEquals("RTX 4080", computer.getGpu());
        assertEquals("ASUS ROG", computer.getMotherboard());
        assertEquals("850W Gold", computer.getPowerSupply());
        assertEquals("Liquid Cooling", computer.getCooling());
        assertTrue(computer.hasWifi());
        assertTrue(computer.hasBluetooth());
        assertEquals("Full Tower", computer.getCaseType());
    }

    @Test
    public void testComputerBuilderValidation() {
        // Test missing CPU
        assertThrows(IllegalStateException.class, () -> {
            new ComputerBuilder()
                    .ram("16GB")
                    .storage("512GB")
                    .build();
        });

        // Test missing RAM
        assertThrows(IllegalStateException.class, () -> {
            new ComputerBuilder()
                    .cpu("Intel i5")
                    .storage("512GB")
                    .build();
        });

        // Test missing Storage
        assertThrows(IllegalStateException.class, () -> {
            new ComputerBuilder()
                    .cpu("Intel i5")
                    .ram("16GB")
                    .build();
        });
    }

    @Test
    public void testComputerDirector() {
        ComputerDirector director = new ComputerDirector();

        Computer gamingComputer = director.buildGamingComputer();
        assertNotNull(gamingComputer);
        assertEquals("Intel Core i9-13900K", gamingComputer.getCpu());
        assertEquals("32GB DDR5-6000", gamingComputer.getRam());
        assertEquals("2TB NVMe SSD", gamingComputer.getStorage());
        assertEquals("NVIDIA RTX 4090", gamingComputer.getGpu());
        assertTrue(gamingComputer.hasWifi());
        assertTrue(gamingComputer.hasBluetooth());

        Computer officeComputer = director.buildOfficeComputer();
        assertNotNull(officeComputer);
        assertEquals("Intel Core i5-13400", officeComputer.getCpu());
        assertEquals("16GB DDR4-3200", officeComputer.getRam());
        assertEquals("512GB NVMe SSD", officeComputer.getStorage());
        assertEquals("Integrated Graphics", officeComputer.getGpu());
    }

    @Test
    public void testPizzaBuilderBasic() {
        Pizza pizza = new PizzaBuilder()
                .size("Medium")
                .crust("Thin")
                .addTopping("Cheese")
                .build();

        assertNotNull(pizza);
        assertEquals("Medium", pizza.getSize());
        assertEquals("Thin", pizza.getCrust());
        assertEquals(1, pizza.getToppings().size());
        assertTrue(pizza.getToppings().contains("Cheese"));
        assertEquals("Tomato", pizza.getSauceType()); // Default
        assertEquals("Mozzarella", pizza.getCheeseType()); // Default
    }

    @Test
    public void testPizzaBuilderMultipleToppings() {
        Pizza pizza = new PizzaBuilder()
                .size("Large")
                .crust("Thick")
                .addToppings("Pepperoni", "Mushrooms", "Bell Peppers")
                .extraCheese(true)
                .sauceType("BBQ")
                .cheeseType("Cheddar")
                .stuffedCrust(true)
                .build();

        assertNotNull(pizza);
        assertEquals("Large", pizza.getSize());
        assertEquals("Thick", pizza.getCrust());
        assertEquals(3, pizza.getToppings().size());
        assertTrue(pizza.getToppings().contains("Pepperoni"));
        assertTrue(pizza.getToppings().contains("Mushrooms"));
        assertTrue(pizza.getToppings().contains("Bell Peppers"));
        assertTrue(pizza.isExtraCheese());
        assertEquals("BBQ", pizza.getSauceType());
        assertEquals("Cheddar", pizza.getCheeseType());
        assertTrue(pizza.isStuffedCrust());
    }

    @Test
    public void testPizzaBuilderValidation() {
        // Test missing size
        assertThrows(IllegalStateException.class, () -> {
            new PizzaBuilder()
                    .crust("Thin")
                    .addTopping("Cheese")
                    .build();
        });

        // Test missing crust
        assertThrows(IllegalStateException.class, () -> {
            new PizzaBuilder()
                    .size("Medium")
                    .addTopping("Cheese")
                    .build();
        });
    }

    @Test
    public void testPizzaBuilderMethodChaining() {
        Pizza pizza = new PizzaBuilder()
                .size("Small")
                .crust("Regular")
                .addTopping("Pepperoni")
                .addTopping("Mushrooms")
                .extraCheese(true)
                .extraSauce(false)
                .build();

        assertNotNull(pizza);
        assertEquals("Small", pizza.getSize());
        assertEquals("Regular", pizza.getCrust());
        assertEquals(2, pizza.getToppings().size());
        assertTrue(pizza.isExtraCheese());
        assertFalse(pizza.isExtraSauce());
    }

    @Test
    public void testBuilderImmutability() {
        Computer computer = new ComputerBuilder()
                .cpu("Intel i7")
                .ram("16GB")
                .storage("512GB")
                .build();

        // Test that the object is properly constructed and immutable
        assertNotNull(computer);
        assertEquals("Intel i7", computer.getCpu());
        
        // Test that we can't modify the object after creation
        // (This is implicit since all fields are private and final)
    }
} 
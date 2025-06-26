package org.codeposito.creational.builder;

// Step 3: Client class demonstrating Builder pattern usage
public class BuilderClient {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Demo ===\n");
        
        // Method 1: Using Builder directly (Fluent Interface)
        System.out.println("1. Building Computer using Builder directly:");
        Computer customComputer = new ComputerBuilder()
                .cpu("AMD Ryzen 7 7700X")
                .ram("32GB DDR5-5600")
                .storage("1TB NVMe SSD")
                .gpu("NVIDIA RTX 4070")
                .motherboard("MSI MPG B650 Carbon WiFi")
                .powerSupply("750W 80+ Gold")
                .cooling("Noctua NH-D15")
                .hasWifi(true)
                .hasBluetooth(true)
                .caseType("ATX Mid Tower")
                .build();
        
        System.out.println("Custom Computer: " + customComputer);
        
        // Method 2: Using Director for predefined configurations
        System.out.println("\n2. Building predefined configurations using Director:");
        ComputerDirector director = new ComputerDirector();
        
        Computer gamingComputer = director.buildGamingComputer();
        System.out.println("Gaming Computer: " + gamingComputer);
        
        Computer officeComputer = director.buildOfficeComputer();
        System.out.println("Office Computer: " + officeComputer);
        
        Computer budgetComputer = director.buildBudgetComputer();
        System.out.println("Budget Computer: " + budgetComputer);
        
        Computer workstationComputer = director.buildWorkstationComputer();
        System.out.println("Workstation Computer: " + workstationComputer);
        
        // Method 3: Demonstrating validation
        System.out.println("\n3. Demonstrating validation:");
        try {
            Computer invalidComputer = new ComputerBuilder()
                    .cpu("Intel Core i7")
                    // Missing required RAM and Storage
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
        
        // Method 4: Demonstrating optional parameters with defaults
        System.out.println("\n4. Building with minimal parameters (using defaults):");
        Computer minimalComputer = new ComputerBuilder()
                .cpu("Intel Core i3-12100")
                .ram("8GB DDR4")
                .storage("256GB SSD")
                .build();
        
        System.out.println("Minimal Computer: " + minimalComputer);
        
        // Method 5: Demonstrating method chaining
        System.out.println("\n5. Demonstrating method chaining:");
        Computer chainedComputer = new ComputerBuilder()
                .cpu("Intel Core i5-13600K")
                .ram("16GB DDR5")
                .storage("512GB NVMe")
                .gpu("RTX 3060")
                .motherboard("ASUS TUF B760M")
                .powerSupply("650W")
                .hasWifi(true)
                .hasBluetooth(false)
                .caseType("Micro ATX")
                .build();
        
        System.out.println("Chained Computer: " + chainedComputer);
    }
} 
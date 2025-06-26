package org.codeposito.creational.builder;

// Step 2: Director class that uses Builder to create predefined configurations
public class ComputerDirector {
    
    public Computer buildGamingComputer() {
        return new ComputerBuilder()
                .cpu("Intel Core i9-13900K")
                .ram("32GB DDR5-6000")
                .storage("2TB NVMe SSD")
                .gpu("NVIDIA RTX 4090")
                .motherboard("ASUS ROG Maximus Z790 Hero")
                .powerSupply("1000W 80+ Gold")
                .cooling("Liquid Cooling AIO 360mm")
                .hasWifi(true)
                .hasBluetooth(true)
                .caseType("Full Tower ATX")
                .build();
    }
    
    public Computer buildOfficeComputer() {
        return new ComputerBuilder()
                .cpu("Intel Core i5-13400")
                .ram("16GB DDR4-3200")
                .storage("512GB NVMe SSD")
                .gpu("Integrated Graphics")
                .motherboard("MSI B760M-A WiFi")
                .powerSupply("550W 80+ Bronze")
                .hasWifi(true)
                .hasBluetooth(true)
                .caseType("Micro ATX")
                .build();
    }
    
    public Computer buildBudgetComputer() {
        return new ComputerBuilder()
                .cpu("AMD Ryzen 5 5600G")
                .ram("8GB DDR4-3200")
                .storage("256GB SATA SSD")
                .gpu("Integrated Graphics")
                .motherboard("ASRock B550M-HDV")
                .powerSupply("450W 80+ White")
                .caseType("Mini ITX")
                .build();
    }
    
    public Computer buildWorkstationComputer() {
        return new ComputerBuilder()
                .cpu("AMD Ryzen 9 7950X")
                .ram("64GB DDR5-5200")
                .storage("4TB NVMe SSD")
                .gpu("NVIDIA RTX A5000")
                .motherboard("ASUS ProArt X670E-CREATOR")
                .powerSupply("1200W 80+ Platinum")
                .cooling("Custom Liquid Cooling")
                .hasWifi(true)
                .hasBluetooth(true)
                .caseType("Extended ATX")
                .build();
    }
} 
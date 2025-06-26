package org.codeposito.creational.builder;

// Step 2: Separate Builder class for Computer
public class ComputerBuilder {
    private Computer computer;

    public ComputerBuilder() {
        computer = new Computer();
    }

    public ComputerBuilder cpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    public ComputerBuilder ram(String ram) {
        computer.setRam(ram);
        return this;
    }

    public ComputerBuilder storage(String storage) {
        computer.setStorage(storage);
        return this;
    }

    public ComputerBuilder gpu(String gpu) {
        computer.setGpu(gpu);
        return this;
    }

    public ComputerBuilder motherboard(String motherboard) {
        computer.setMotherboard(motherboard);
        return this;
    }

    public ComputerBuilder powerSupply(String powerSupply) {
        computer.setPowerSupply(powerSupply);
        return this;
    }

    public ComputerBuilder cooling(String cooling) {
        computer.setCooling(cooling);
        return this;
    }

    public ComputerBuilder hasWifi(boolean hasWifi) {
        computer.setHasWifi(hasWifi);
        return this;
    }

    public ComputerBuilder hasBluetooth(boolean hasBluetooth) {
        computer.setHasBluetooth(hasBluetooth);
        return this;
    }

    public ComputerBuilder caseType(String caseType) {
        computer.setCaseType(caseType);
        return this;
    }

    public Computer build() {
        // Validation logic
        if (computer.getCpu() == null) {
            throw new IllegalStateException("CPU is required");
        }
        if (computer.getRam() == null) {
            throw new IllegalStateException("RAM is required");
        }
        if (computer.getStorage() == null) {
            throw new IllegalStateException("Storage is required");
        }
        
        // Set defaults for optional fields
        if (computer.getCooling() == null) {
            computer.setCooling("Stock Cooler");
        }
        if (computer.getCaseType() == null) {
            computer.setCaseType("ATX Mid Tower");
        }
        
        return computer;
    }
} 
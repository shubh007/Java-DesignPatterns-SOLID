package org.codeposito.creational.builder;

// Step 1: Complex Object to be built
public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private String motherboard;
    private String powerSupply;
    private String cooling;
    private boolean hasWifi;
    private boolean hasBluetooth;
    private String caseType;

    // Package-private constructor to allow Builder access
    Computer() {}

    // Getters
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGpu() { return gpu; }
    public String getMotherboard() { return motherboard; }
    public String getPowerSupply() { return powerSupply; }
    public String getCooling() { return cooling; }
    public boolean hasWifi() { return hasWifi; }
    public boolean hasBluetooth() { return hasBluetooth; }
    public String getCaseType() { return caseType; }

    // Setters for Builder
    void setCpu(String cpu) { this.cpu = cpu; }
    void setRam(String ram) { this.ram = ram; }
    void setStorage(String storage) { this.storage = storage; }
    void setGpu(String gpu) { this.gpu = gpu; }
    void setMotherboard(String motherboard) { this.motherboard = motherboard; }
    void setPowerSupply(String powerSupply) { this.powerSupply = powerSupply; }
    void setCooling(String cooling) { this.cooling = cooling; }
    void setHasWifi(boolean hasWifi) { this.hasWifi = hasWifi; }
    void setHasBluetooth(boolean hasBluetooth) { this.hasBluetooth = hasBluetooth; }
    void setCaseType(String caseType) { this.caseType = caseType; }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", gpu='" + gpu + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", powerSupply='" + powerSupply + '\'' +
                ", cooling='" + cooling + '\'' +
                ", hasWifi=" + hasWifi +
                ", hasBluetooth=" + hasBluetooth +
                ", caseType='" + caseType + '\'' +
                '}';
    }
} 
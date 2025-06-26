package org.codeposito.creational.builder;

import java.util.ArrayList;
import java.util.List;

// Step 4: Alternative Builder example - Pizza with different approach
public class Pizza {
    private String size;
    private String crust;
    private List<String> toppings;
    private boolean extraCheese;
    private boolean extraSauce;
    private String sauceType;
    private String cheeseType;
    private boolean stuffedCrust;

    // Package-private constructor to allow Builder access
    Pizza() {
        this.toppings = new ArrayList<>();
    }

    // Getters
    public String getSize() { return size; }
    public String getCrust() { return crust; }
    public List<String> getToppings() { return new ArrayList<>(toppings); }
    public boolean isExtraCheese() { return extraCheese; }
    public boolean isExtraSauce() { return extraSauce; }
    public String getSauceType() { return sauceType; }
    public String getCheeseType() { return cheeseType; }
    public boolean isStuffedCrust() { return stuffedCrust; }

    // Setters for Builder
    void setSize(String size) { this.size = size; }
    void setCrust(String crust) { this.crust = crust; }
    void setExtraCheese(boolean extraCheese) { this.extraCheese = extraCheese; }
    void setExtraSauce(boolean extraSauce) { this.extraSauce = extraSauce; }
    void setSauceType(String sauceType) { this.sauceType = sauceType; }
    void setCheeseType(String cheeseType) { this.cheeseType = cheeseType; }
    void setStuffedCrust(boolean stuffedCrust) { this.stuffedCrust = stuffedCrust; }
    
    // Method to add toppings
    void addTopping(String topping) {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", crust='" + crust + '\'' +
                ", toppings=" + toppings +
                ", extraCheese=" + extraCheese +
                ", extraSauce=" + extraSauce +
                ", sauceType='" + sauceType + '\'' +
                ", cheeseType='" + cheeseType + '\'' +
                ", stuffedCrust=" + stuffedCrust +
                '}';
    }
} 
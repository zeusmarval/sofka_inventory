package com.zama.inventarioSofka.Models;

public class Product {

    private String name;
    private int quantity;
    private double basePrice;
    private int wholesaleUnit;

    public Product() {
    }

    public Product(String name, int quantity, double basePrice, int wholesaleUnit) {
        this.name = name;
        this.quantity = quantity;
        this.basePrice = basePrice;
        this.wholesaleUnit = wholesaleUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getWholesaleUnit() {
        return wholesaleUnit;
    }

    public void setWholesaleUnit(int wholesaleUnit) {
        this.wholesaleUnit = wholesaleUnit;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", basePrice=" + basePrice +
                ", wholesaleUnit=" + wholesaleUnit +
                '}';
    }
}

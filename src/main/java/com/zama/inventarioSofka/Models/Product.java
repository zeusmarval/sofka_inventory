package com.zama.inventarioSofka.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", basePrice=" + basePrice +
                ", wholesaleUnit=" + wholesaleUnit +
                '}';
    }
}

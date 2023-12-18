package com.zama.inventarioSofka.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private int quantity;
    private BigDecimal basePrice;
    private int wholesaleUnits;

    public Product() {
    }

    public Product(String name, int quantity, BigDecimal basePrice, int wholesaleUnit) {
        this.name = name;
        this.quantity = quantity;
        this.basePrice = basePrice;
        this.wholesaleUnits = wholesaleUnit;
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

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public int getWholesaleUnits() {
        return wholesaleUnits;
    }

    public void setWholesaleUnits(int wholesaleUnits) {
        this.wholesaleUnits = wholesaleUnits;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", basePrice=" + basePrice +
                ", wholesaleUnit=" + wholesaleUnits +
                '}';
    }
}

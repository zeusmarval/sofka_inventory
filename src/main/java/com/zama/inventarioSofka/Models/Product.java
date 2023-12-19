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

    public BigDecimal calculateTotalWholesale(int quantity) {
        if (quantity >= wholesaleUnits) {
            BigDecimal discountedPrice = applyDiscount(basePrice);
            int unitsForRetail = quantity % wholesaleUnits;
            int unitsForWholesale = quantity - unitsForRetail;

            BigDecimal totalRetail = BigDecimal.valueOf(unitsForRetail).multiply(basePrice);
            BigDecimal totalWholesale = BigDecimal.valueOf(unitsForWholesale).multiply(discountedPrice);

            return totalRetail.add(totalWholesale);
        } else {
            return basePrice.multiply(BigDecimal.valueOf(quantity));
        }
    }

    private BigDecimal applyDiscount(BigDecimal basePrice) {
        BigDecimal discountMultiplier = BigDecimal.valueOf(0.9);
        return basePrice.multiply(discountMultiplier);
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

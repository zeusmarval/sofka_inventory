package com.zama.inventarioSofka.Models.DTO;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductDTO {

    private String name;
    private int quantity;
    private BigDecimal basePrice;
    private int wholesaleUnits;

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public void setWholesaleUnits(int wholesaleUnits) {
        this.wholesaleUnits = wholesaleUnits;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", basePrice=" + basePrice +
                ", wholesaleUnits=" + wholesaleUnits +
                '}';
    }
}

package com.zama.inventarioSofka.Models;

import java.math.BigDecimal;

public class SoldProduct {

    private String productName;
    private int quantity;
    private BigDecimal subtotal;

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "SoldProduct{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }
}

package com.zama.inventarioSofka.Models;

import java.math.BigDecimal;

public class SoldProduct {

    private String productName;
    private int quantity;
    private BigDecimal subtotal;

    public SoldProduct(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public SoldProduct() {

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

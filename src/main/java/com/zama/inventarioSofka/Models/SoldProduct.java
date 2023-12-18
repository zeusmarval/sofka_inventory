package com.zama.inventarioSofka.Models;

public class SoldProduct {

    private Product product;
    private int quantity;
    private double unitPrice;
    private double subtotal;

    public SoldProduct() {
    }

    public SoldProduct(Product product, int quantity, double unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = quantity * unitPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateSubtotal();
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        updateSubtotal();
    }

    public double getSubtotal() {
        return subtotal;
    }

    private void updateSubtotal() {
        this.subtotal = quantity * unitPrice;
    }

    @Override
    public String toString() {
        return "SoldProduct{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subtotal=" + subtotal +
                '}';
    }
}

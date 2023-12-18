package com.zama.inventarioSofka.Models;

import java.time.LocalDateTime;
import java.util.List;

public class Sale {

    private LocalDateTime saleDate;
    private List<SoldProduct> soldProducts;
    private double totalSale;

    // Constructor por defecto
    public Sale() {
    }

    // Constructor con parámetros
    public Sale(LocalDateTime saleDate, List<SoldProduct> soldProducts) {
        this.saleDate = saleDate;
        this.soldProducts = soldProducts;
        calculateTotalSale();
    }

    // Getters y Setters

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public List<SoldProduct> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProduct> soldProducts) {
        this.soldProducts = soldProducts;
        calculateTotalSale();
    }

    public double getTotalSale() {
        return totalSale;
    }

    // Método para calcular el total de la venta
    private void calculateTotalSale() {
        this.totalSale = soldProducts.stream()
                .mapToDouble(SoldProduct::getSubtotal)
                .sum();
    }

    // toString para facilitar la representación en cadena
    @Override
    public String toString() {
        return "Sale{" +
                "saleDate=" + saleDate +
                ", soldProducts=" + soldProducts +
                ", totalSale=" + totalSale +
                '}';
    }
}

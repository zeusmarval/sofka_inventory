package com.zama.inventarioSofka.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "sales")
public class Sale {

    @Id
    private String id;
    private LocalDateTime saleDate;
    private List<SoldProduct> soldProducts;
    private double totalSale;

    public Sale() {
    }

    public Sale(LocalDateTime saleDate, List<SoldProduct> soldProducts) {
        this.saleDate = saleDate;
        this.soldProducts = soldProducts;
        calculateTotalSale();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

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

    private void calculateTotalSale() {
        this.totalSale = soldProducts.stream()
                .mapToDouble(SoldProduct::getSubtotal)
                .sum();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleDate=" + saleDate +
                ", soldProducts=" + soldProducts +
                ", totalSale=" + totalSale +
                '}';
    }
}

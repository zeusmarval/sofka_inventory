package com.zama.inventarioSofka.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "sales")
public class Sale {

    @Id
    private String id;
    private LocalDateTime saleDate = LocalDateTime.now();
    private List<SoldProduct> soldProducts;
    private BigDecimal totalSale;

    public Sale(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    /*public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }*/

    public List<SoldProduct> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProduct> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public BigDecimal getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(BigDecimal totalSale) {
        this.totalSale = totalSale;
    }

    public void calculateTotalSale() {
        this.totalSale = BigDecimal.ZERO;

        for (SoldProduct soldProduct : soldProducts) {
            System.out.println("Productos Vendidos");
            System.out.println(soldProduct);
            //soldProduct.calculateSubtotal();
            //totalSale = totalSale.add(productTotal);
        }
    }

}

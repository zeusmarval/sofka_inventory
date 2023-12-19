package com.zama.inventarioSofka.Models.DTO;

import com.zama.inventarioSofka.Models.SoldProduct;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SaleDTO {

    private String saleDate = LocalDateTime.now().toString();
    private List<SoldProduct> soldProducts;
    private BigDecimal totalSale;
    public SaleDTO() {
    }

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

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "SaleDTO{" +
                "saleDate=" + saleDate +
                ", soldProducts=" + soldProducts +
                ", totalSale=" + totalSale +
                '}';
    }
}

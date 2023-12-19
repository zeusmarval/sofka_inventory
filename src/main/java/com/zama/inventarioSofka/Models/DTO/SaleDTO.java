package com.zama.inventarioSofka.Models.DTO;

import com.zama.inventarioSofka.Models.SoldProduct;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SaleDTO {

    private LocalDateTime saleDate = LocalDateTime.now();
    private List<SoldProduct> soldProducts;
    private BigDecimal totalSale;

    public SaleDTO() {
    }

    public SaleDTO(LocalDateTime saleDate, List<SoldProduct> soldProducts, BigDecimal totalSale) {
        this.saleDate = saleDate;
        this.soldProducts = soldProducts;
        this.totalSale = totalSale;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
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

    @Override
    public String toString() {
        return "SaleDTO{" +
                "saleDate=" + saleDate +
                ", soldProducts=" + soldProducts +
                ", totalSale=" + totalSale +
                '}';
    }
}

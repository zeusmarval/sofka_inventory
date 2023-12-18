package com.zama.inventarioSofka.Models.DTO;

import com.zama.inventarioSofka.Models.SoldProduct;

import java.time.LocalDateTime;
import java.util.List;

public class SaleDTO {

    private LocalDateTime saleDate;
    private List<SoldProduct> soldProducts;

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
    }

    @Override
    public String toString() {
        return "SaleDTO{" +
                "saleDate=" + saleDate +
                ", soldProducts=" + soldProducts +
                '}';
    }
}

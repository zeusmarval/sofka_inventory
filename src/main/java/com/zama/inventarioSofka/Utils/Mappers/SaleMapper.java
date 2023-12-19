package com.zama.inventarioSofka.Utils.Mappers;

import com.zama.inventarioSofka.Models.Sale;
import com.zama.inventarioSofka.Models.DTO.SaleDTO;

import java.time.LocalDateTime;

public class SaleMapper {

    public static SaleDTO toDTO(Sale sale) {
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setSoldProducts(sale.getSoldProducts());
        saleDTO.setTotalSale(sale.getTotalSale());
        saleDTO.setSaleDate(sale.getSaleDate().toString());
        return saleDTO;
    }

    public static Sale toEntity(SaleDTO saleDTO) {
        Sale sale = new Sale();
        sale.setSoldProducts(saleDTO.getSoldProducts());
        sale.setTotalSale(saleDTO.getTotalSale());
        sale.setSaleDate(LocalDateTime.parse(saleDTO.getSaleDate()));
        return sale;
    }
}


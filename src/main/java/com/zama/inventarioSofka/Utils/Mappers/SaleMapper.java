package com.zama.inventarioSofka.Utils.Mappers;

import com.zama.inventarioSofka.Models.Sale;
import com.zama.inventarioSofka.Models.DTO.SaleDTO;

public class SaleMapper {

    public static SaleDTO toDTO(Sale sale) {
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setSoldProducts(sale.getSoldProducts());
        saleDTO.setTotalSale(sale.getTotalSale());
        return saleDTO;
    }

    public static Sale toEntity(SaleDTO saleDTO) {
        Sale sale = new Sale();
        sale.setSoldProducts(saleDTO.getSoldProducts());
        sale.setTotalSale(saleDTO.getTotalSale());
        return sale;
    }
}


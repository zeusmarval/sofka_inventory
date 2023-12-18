package com.zama.inventarioSofka.Utils.Mappers;

import com.zama.inventarioSofka.Models.DTO.ProductDTO;
import com.zama.inventarioSofka.Models.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setName(product.getName());
        dto.setQuantity(product.getQuantity());
        dto.setBasePrice(product.getBasePrice());
        dto.setWholesaleUnits(product.getWholesaleUnits());
        return dto;
    }

    public static Product toProduct(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setBasePrice(dto.getBasePrice());
        product.setWholesaleUnits(dto.getWholesaleUnits());
        return product;
    }

}

package com.zama.inventarioSofka.Utils.Mappers;

import com.zama.inventarioSofka.Models.DTO.ProductDTO;
import com.zama.inventarioSofka.Models.SoldProduct;

public class SoldProductMapper {

    public static ProductDTO toProduct(SoldProduct sold) {
        ProductDTO product = new ProductDTO();
        product.setName(sold.getProductName());
        product.setQuantity(sold.getQuantity());
        product.setSubtotal(sold.getSubtotal());
        return product;
    }

}

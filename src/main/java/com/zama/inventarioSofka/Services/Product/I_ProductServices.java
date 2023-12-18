package com.zama.inventarioSofka.Services.Product;

import com.zama.inventarioSofka.Models.DTO.ProductDTO;
import com.zama.inventarioSofka.Models.Product;
import reactor.core.publisher.Mono;

public interface I_ProductServices {
    public Mono<Product> saveProduct(ProductDTO productDTO);

    public Mono<Void> updateProduct(String productName, int quantity);
}

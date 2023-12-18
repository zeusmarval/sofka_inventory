package com.zama.inventarioSofka.Services.Product;

import com.zama.inventarioSofka.Models.DTO.ProductDTO;
import com.zama.inventarioSofka.Models.Product;
import com.zama.inventarioSofka.Utils.Mappers.ProductMapper;
import com.zama.inventarioSofka.drivenAdapters.repository.Product_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductServices_Imp implements I_ProductServices {

    @Autowired
    Product_Repository productRepository;

    @Override
    public Mono<Product> saveProduct(ProductDTO productDTO) {
        Product product = ProductMapper.toProduct(productDTO);
        return productRepository.save(product);
    }

    @Override
    public Mono<Void> updateProduct(String productName, int quantity) {
        return productRepository.findByName(productName)
                .flatMap(existingProduct -> {

                    existingProduct.setQuantity(existingProduct.getQuantity() - quantity);

                    return productRepository.save(existingProduct);
                })
                .then();
    }

}

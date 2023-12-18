package com.zama.inventarioSofka.UserCases.Product;

import com.zama.inventarioSofka.Models.DTO.ProductDTO;
import com.zama.inventarioSofka.Models.Product;
import com.zama.inventarioSofka.Utils.Mappers.ProductMapper;
import com.zama.inventarioSofka.drivenAdapters.repository.Product_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductResource {

    @Autowired
    private Product_Repository productRepository;

    public Flux<ProductDTO> getAllProductsPaginated(int page, int size) {
        return productRepository.findAll()
                .skip((long) page * size)
                .take(size)
                .map(ProductMapper::toDTO);
    }

    public Mono<ProductDTO> saveProduct(ProductDTO productDTO) {
        Product product = ProductMapper.toProduct(productDTO);

        return productRepository.findByName(product.getName())
                .flatMap(existingProduct -> {
                    existingProduct.setQuantity(product.getQuantity());
                    existingProduct.setBasePrice(product.getBasePrice());
                    existingProduct.setWholesaleUnits(product.getWholesaleUnits());
                    return productRepository.save(existingProduct).map(ProductMapper::toDTO);
                })
                .switchIfEmpty(
                        productRepository.save(product).map(ProductMapper::toDTO)
                );
    }

    public Mono<Void> updateProduct(String productName, int quantity) {
        return productRepository.findByName(productName)
                .flatMap(existingProduct -> {

                    existingProduct.setQuantity(existingProduct.getQuantity() - quantity);

                    return productRepository.save(existingProduct);
                })
                .then();
    }

}

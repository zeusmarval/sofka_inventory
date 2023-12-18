package com.zama.inventarioSofka.drivenAdapters.repository;

import com.zama.inventarioSofka.Models.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface Product_Repository extends ReactiveMongoRepository<Product, String> {
    Mono<Product> save(Mono<Product> product);
    Mono<Product> findByName(String name);

}

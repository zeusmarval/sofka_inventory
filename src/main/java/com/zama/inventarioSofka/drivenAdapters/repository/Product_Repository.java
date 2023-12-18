package com.zama.inventarioSofka.drivenAdapters.repository;

import com.zama.inventarioSofka.Models.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Product_Repository extends ReactiveMongoRepository<Product, String> {
}

package com.zama.inventarioSofka.drivenAdapters.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.zama.inventarioSofka.Models.Sale;

public interface Sale_Repository extends ReactiveMongoRepository<Sale, String> {
}

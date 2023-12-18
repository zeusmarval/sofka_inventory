package com.zama.inventarioSofka.Services.Sale;

import com.zama.inventarioSofka.Models.Sale;
import com.zama.inventarioSofka.Models.SoldProduct;
import com.zama.inventarioSofka.drivenAdapters.repository.Sale_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SaleServices_Imp implements I_SaleServices {

    @Autowired
    Sale_Repository saleRepository;

    public Mono<Sale> SaleProduct(Sale sale) {

        Mono<Sale> Sale = saleRepository.save(sale);

        return Sale.flatMap(savedSale -> {
            for (SoldProduct soldProduct : savedSale.getSoldProducts()) {
                //updateProduct(soldProduct.getProduct(), soldProduct.getQuantity());
            }
            return Mono.just(savedSale);
        });
    }

}

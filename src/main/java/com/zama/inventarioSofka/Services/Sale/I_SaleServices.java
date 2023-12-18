package com.zama.inventarioSofka.Services.Sale;

import com.zama.inventarioSofka.Models.Sale;
import reactor.core.publisher.Mono;

public interface I_SaleServices {

    public Mono<Sale> SaleProduct(Sale sale);

}

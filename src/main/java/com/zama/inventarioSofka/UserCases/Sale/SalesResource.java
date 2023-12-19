package com.zama.inventarioSofka.UserCases.Sale;

import com.zama.inventarioSofka.Models.DTO.SaleDTO;
import com.zama.inventarioSofka.Models.Sale;
import com.zama.inventarioSofka.Utils.Mappers.SaleMapper;
import com.zama.inventarioSofka.drivenAdapters.repository.Product_Repository;
import com.zama.inventarioSofka.drivenAdapters.repository.Sale_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class SalesResource {

    @Autowired
    private Sale_Repository saleRepository;

    @Autowired
    private Product_Repository productRepository;

    public Mono<SaleDTO> saveSaleRetail(SaleDTO saleDTO) {
        Sale sale = SaleMapper.toEntity(saleDTO);

        return calculateTotalSaleWithDiscount(sale, Boolean.FALSE)
                .doOnNext(sale::setTotalSale)
                .then(saleRepository.save(sale).map(SaleMapper::toDTO));
    }

    public Mono<SaleDTO> saveSaleMajor(SaleDTO saleDTO) {
        Sale sale = SaleMapper.toEntity(saleDTO);

        return calculateTotalSaleWithDiscount(sale, Boolean.TRUE)
                .doOnNext(sale::setTotalSale)
                .then(saleRepository.save(sale).map(SaleMapper::toDTO));
    }

    private Mono<BigDecimal> calculateTotalSaleWithDiscount(Sale sale, Boolean major) {
        return Flux.fromIterable(sale.getSoldProducts())
                .flatMap(soldProduct -> {
                    String productName = soldProduct.getProductName();
                    int quantity = soldProduct.getQuantity();

                    return productRepository.findByName(productName)
                            .flatMap(product -> {
                                if (quantity < product.getWholesaleUnits() && major) {
                                    return Mono.error(new RuntimeException("Solo venta al mayor para el producto: " + productName));
                                }
                                BigDecimal productTotal = product.calculateTotalWholesale(quantity);
                                soldProduct.setSubtotal(productTotal);
                                return Mono.just(productTotal);
                            });
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}

package com.zama.inventarioSofka.UserCases.Sale;

import com.zama.inventarioSofka.Models.DTO.SaleDTO;
import com.zama.inventarioSofka.drivenAdapters.bus.PublisherSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class CreateSalesRetail {

    @Autowired
    private SalesResource salesResource;

    @Autowired
    private PublisherSales publisherSales;

    public Mono<ServerResponse> apply(ServerRequest request) {
        Mono<SaleDTO> saleBody = request.bodyToMono(SaleDTO.class);

        return saleBody.flatMap(saleDTO -> salesResource.saveSaleRetail(saleDTO)
                .flatMap(sale -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(sale))
                        .doOnSuccess(success -> publisherSales.publish(sale, Boolean.FALSE))
                )
                .switchIfEmpty(ServerResponse.badRequest().build()))
                .onErrorResume(this::handleError);
    }

    private Mono<ServerResponse> handleError(Throwable error) {
        String messageError = "Error al registrar venta: " + error;
        publisherSales.errors(messageError);
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(messageError));
    }
}

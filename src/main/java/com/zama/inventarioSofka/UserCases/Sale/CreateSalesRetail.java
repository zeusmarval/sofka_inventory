package com.zama.inventarioSofka.UserCases.Sale;

import com.zama.inventarioSofka.Models.DTO.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class CreateSalesRetail {

    @Autowired
    private SalesResource salesResource;

    public Mono<ServerResponse> apply(ServerRequest request) {
        Mono<SaleDTO> saleBody = request.bodyToMono(SaleDTO.class);

        return saleBody.flatMap(saleDTO -> salesResource.saveSaleRetail(saleDTO)
                .flatMap(product -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(product))
                )
                .switchIfEmpty(ServerResponse.badRequest().build()))
                .onErrorResume(this::handleError);
    }

    private Mono<ServerResponse> handleError(Throwable error) {
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("Error al registrar venta: \n" + error));
    }
}

package com.zama.inventarioSofka.UserCases.Product;

import com.zama.inventarioSofka.Models.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class SaveOneProduct {

    @Autowired
    private ProductResource productResource;

    public Mono<ServerResponse> apply(ServerRequest request) {
        Mono<ProductDTO> productBody = request.bodyToMono(ProductDTO.class);

        return productBody
                .flatMap(productDTO -> productResource.saveProduct(productDTO)
                        .flatMap(product -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromValue(product))
                )
                .switchIfEmpty(ServerResponse.badRequest().build()));
    }

    private Mono<ServerResponse> handleError(Throwable error) {
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("Error al registrar inventario: \n" + error));
    }

}

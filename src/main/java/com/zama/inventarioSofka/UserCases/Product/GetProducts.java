package com.zama.inventarioSofka.UserCases.Product;

import com.zama.inventarioSofka.Models.Product;
import com.zama.inventarioSofka.drivenAdapters.bus.PublisherGets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GetProducts {

    @Autowired
    private ProductResource productResource;

    @Autowired
    private PublisherGets publisherGets;

    public Mono<ServerResponse> apply(ServerRequest request) {
        int page = Integer.parseInt(request.queryParam("page").orElse("0"));
        int size = Integer.parseInt(request.queryParam("size").orElse("10"));

        Flux<Product> allProducts = productResource.getAllProductsPaginated(page, size);

        return allProducts.collectList().flatMap(products -> {
            publisherGets.product(products);
            return ServerResponse.ok()
                    .body(allProducts, Product.class)
                    .switchIfEmpty(ServerResponse.notFound().build())
                    .onErrorResume(this::handleError);
        });

    }

    private Mono<ServerResponse> handleError(Throwable error) {
        String messageError = "Error al obtener productos paginados: " + error;
        publisherGets.errors(messageError);
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(messageError));
    }

}

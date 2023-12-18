package com.zama.inventarioSofka.handlers.routes;

import com.zama.inventarioSofka.UserCases.Product.GetProducts;
import com.zama.inventarioSofka.UserCases.Product.SaveManyProduct;
import com.zama.inventarioSofka.UserCases.Product.SaveOneProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Product_Routes {

    @Autowired
    SaveOneProduct saveOneProduct;
    @Autowired
    SaveManyProduct saveManyProduct;

    @Autowired
    GetProducts getProducts;

    @Bean
    public RouterFunction<ServerResponse> ProductRoutes() {
        return RouterFunctions.route()
                .GET("/product/all", accept(MediaType.APPLICATION_JSON), getProducts::apply)
                .POST("/product/save-one", accept(MediaType.APPLICATION_JSON), saveOneProduct::apply)
                .POST("/product/save-many", accept(MediaType.APPLICATION_JSON), saveManyProduct::apply)
                .build();
    }
}

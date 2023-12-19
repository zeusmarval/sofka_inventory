package com.zama.inventarioSofka.handlers.routes;

import com.zama.inventarioSofka.UserCases.Sale.CreateSalesMajor;
import com.zama.inventarioSofka.UserCases.Sale.CreateSalesRetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Sale_Router {

    @Autowired
    private CreateSalesRetail createSalesRetail;
    @Autowired
    private CreateSalesMajor createSalesMajor;

    @Bean
    public RouterFunction<ServerResponse> saleRoutes() {
        return RouterFunctions.route()
                .POST("/sales/retail", accept(MediaType.APPLICATION_JSON), createSalesRetail::apply)
                .POST("/sales/major", accept(MediaType.APPLICATION_JSON), createSalesMajor::apply)
                .build();
    }

}

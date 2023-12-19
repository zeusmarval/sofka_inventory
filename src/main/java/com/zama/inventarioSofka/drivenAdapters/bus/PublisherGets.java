package com.zama.inventarioSofka.drivenAdapters.bus;

import com.google.gson.Gson;
import com.zama.inventarioSofka.Models.DTO.ProductDTO;
import com.zama.inventarioSofka.Models.MessagePublish;
import com.zama.inventarioSofka.Models.Product;
import com.zama.inventarioSofka.RabbitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.OutboundMessage;
import reactor.rabbitmq.Sender;

import java.util.List;

@Component
public class PublisherGets {

    @Autowired
    private Sender sender;

    @Autowired
    private Gson gson;

    public void publish(List<Product> products) {
        MessagePublish message = new MessagePublish(
                "GET", "Product", gson.toJson(products)
        );

        sender
                .send(Mono.just(new OutboundMessage(RabbitConfig.EXCHANGE_NAME,
                        RabbitConfig.ROUTING_KEY_PRODUCT, gson.toJson(message).getBytes()))).subscribe();

    }
}

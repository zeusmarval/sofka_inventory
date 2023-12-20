package com.zama.inventarioSofka.drivenAdapters.bus;

import com.google.gson.Gson;
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

    public void product(List<Product> products) {
        MessagePublish message = new MessagePublish(
                "GET", "Product", gson.toJson(products)
        );

        sender
                .send(Mono.just(new OutboundMessage(RabbitConfig.EXCHANGE_NAME,
                        RabbitConfig.ROUTING_KEY_GETS, gson.toJson(message).getBytes()))).subscribe();

    }

    public void errors(String error){

        MessagePublish message = new MessagePublish(
                "Error", "Product", error
        );

        sender
                .send(Mono.just(new OutboundMessage(RabbitConfig.EXCHANGE_NAME,
                        RabbitConfig.ROUTING_KEY_GETS_ERROR, gson.toJson(message).getBytes()))).subscribe();
    }

}

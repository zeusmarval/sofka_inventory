package com.zama.inventarioSofka.drivenAdapters.bus;

import com.google.gson.Gson;
import com.zama.inventarioSofka.RabbitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.OutboundMessage;
import reactor.rabbitmq.Sender;

public class PublisherProduct {

    @Autowired
    private Sender sender;

    @Autowired
    private Gson gson;

    public void publish(Object object){
        sender
                .send(Mono.just(new OutboundMessage(RabbitConfig.EXCHANGE_NAME,
                        RabbitConfig.ROUTING_KEY_PRODUCT, gson.toJson(object).getBytes()))).subscribe();
    }

}
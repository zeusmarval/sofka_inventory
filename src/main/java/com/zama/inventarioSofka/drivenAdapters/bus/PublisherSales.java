package com.zama.inventarioSofka.drivenAdapters.bus;

import com.google.gson.Gson;
import com.zama.inventarioSofka.Models.DTO.SaleDTO;
import com.zama.inventarioSofka.Models.MessagePublish;
import com.zama.inventarioSofka.RabbitConfig;
import com.zama.inventarioSofka.Utils.Mappers.SoldProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.OutboundMessage;
import reactor.rabbitmq.Sender;

@Component
public class PublisherSales {

    @Autowired
    private Sender sender;

    @Autowired
    private Gson gson;

    public void publish(SaleDTO sale, Boolean major){

        MessagePublish message = new MessagePublish(
                (major) ? "Major":"Retail", "Sale", gson.toJson(sale),
                sale.getSoldProducts().stream().map(SoldProductMapper::toProduct).toList()
        );

        sender
                .send(Mono.just(new OutboundMessage(RabbitConfig.EXCHANGE_NAME,
                        RabbitConfig.ROUTING_KEY_SALES, gson.toJson(message).getBytes()))).subscribe();
    }

    /*public void publishError(Object object){
        sender
                .send(Mono.just(new OutboundMessage(RabbitConfig.EXCHANGE_NAME,
                        RabbitConfig.ROUTING_KEY_SALES_ERROR, gson.toJson(object).getBytes()))).subscribe();
    }*/

}

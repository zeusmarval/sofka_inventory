package com.zama.inventarioSofka;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.rabbitmq.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class RabbitConfig {
    public static final String QUEUE_PRODUCT = "product-queue";
    public static final String QUEUE_SALES = "sales-queue";
    public static final String QUEUE_PRODCUCT_ERRORS = "product-errors-queue";
    public static final String QUEUE_SALES_ERRORS = "sales-errors-queue";
    //public static final String QUEUE_NAME_ERRORS = "errors-queue";
    public static final String EXCHANGE_NAME = "inventory-exchange";
    public static final String ROUTING_KEY_PRODUCT = "product.routing.key";
    public static final String ROUTING_KEY_SALES = "sales.routing.key";
    //public static final String ROUTING_KEY_NAME_ALL = "all.routing.key";
    //public static final String ROUTING_KEY_NAME_ERROR = "errors.routing.key";
    public static final String ROUTING_KEY_PRODUCT_ERROR = "errors.product.routing.key";
    public static final String ROUTING_KEY_SALES_ERROR = "errors.sales.routing.key";
    public static final String URI_NAME = "amqps://xuvssrll:lMktC642iNhZ4wjfudHaET9jwFuJpOZm@cow.rmq2.cloudamqp.com/xuvssrll";

    @Bean
    public AmqpAdmin amqpAdmin() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(URI.create(URI_NAME));
        var amqpAdmin =  new RabbitAdmin(connectionFactory);

        var exchange = new TopicExchange(EXCHANGE_NAME);
        var queue_product = new Queue(QUEUE_PRODUCT, true, false, false);
        var queue_sales = new Queue(QUEUE_SALES, true, false, false);
        var queue_errors_product = new Queue(QUEUE_PRODCUCT_ERRORS, true, false, false);
        var queue_errors_sale = new Queue(QUEUE_SALES_ERRORS, true, false, false);

        amqpAdmin.declareExchange(exchange);
        amqpAdmin.declareQueue(queue_product);
        amqpAdmin.declareQueue(queue_sales);
        amqpAdmin.declareQueue(queue_errors_product);
        amqpAdmin.declareQueue(queue_errors_sale);
        amqpAdmin.declareBinding(BindingBuilder.bind(queue_product).to(exchange).with(ROUTING_KEY_PRODUCT));
        amqpAdmin.declareBinding(BindingBuilder.bind(queue_sales).to(exchange).with(ROUTING_KEY_SALES));
        amqpAdmin.declareBinding(BindingBuilder.bind(queue_errors_product).to(exchange).with(ROUTING_KEY_PRODUCT_ERROR));
        amqpAdmin.declareBinding(BindingBuilder.bind(queue_errors_sale).to(exchange).with(ROUTING_KEY_SALES_ERROR));

        return amqpAdmin;
    }

    @Bean
    public ConnectionFactory connectionFactory() throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.useNio();
        connectionFactory.setUri(URI_NAME);
        return connectionFactory;
    }

    @Bean
    public Mono<Connection> connectionMono(@Value("spring.application.name") String name, ConnectionFactory connectionFactory)  {
        return Mono.fromCallable(() -> connectionFactory.newConnection(name)).cache();
    }

    @Bean
    public SenderOptions senderOptions(Mono<Connection> connectionMono) {
        return new SenderOptions()
                .connectionMono(connectionMono)
                .resourceManagementScheduler(Schedulers.boundedElastic());
    }

    @Bean
    public Sender sender(SenderOptions senderOptions) {
        return RabbitFlux.createSender(senderOptions);
    }

}

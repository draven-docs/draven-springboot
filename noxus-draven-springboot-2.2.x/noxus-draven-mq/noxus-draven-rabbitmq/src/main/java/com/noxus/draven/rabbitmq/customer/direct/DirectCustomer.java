package com.noxus.draven.rabbitmq.customer.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "draven")
public class DirectCustomer {
    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("draven接收到消息:" + message);
    }
}
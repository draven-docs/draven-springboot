package com.noxus.draven.rabbitmq.customer.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "draven3")
public class FanoutCustomer {
    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("draven3接收到消息:" + message);
    }
}

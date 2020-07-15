package com.noxus.draven.rabbitmq.customer.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "draven1")
public class TopCustomerOne {
    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("draven1接收到消息:" + message);
    }
}

package com.noxus.draven.rabbitmq.customer.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "draven2")
public class FanoutCustomerTwo {
    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("draven2接收到消息:" + message);
    }
}

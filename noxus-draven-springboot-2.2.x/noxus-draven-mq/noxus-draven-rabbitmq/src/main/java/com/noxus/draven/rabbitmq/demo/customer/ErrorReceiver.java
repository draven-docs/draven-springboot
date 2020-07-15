package com.noxus.draven.rabbitmq.demo.customer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author draven
 */
@Service
public class ErrorReceiver {
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "${mq.config.queue_name.error}", autoDelete = "true"),
                    exchange = @Exchange(value = "${mq.config.exchange_name}", type = ExchangeTypes.TOPIC),
                    key = "*.log.error"
            )
    )
    public void process(String msg) {
        System.out.println("......Error........receiver: " + msg);
    }
}

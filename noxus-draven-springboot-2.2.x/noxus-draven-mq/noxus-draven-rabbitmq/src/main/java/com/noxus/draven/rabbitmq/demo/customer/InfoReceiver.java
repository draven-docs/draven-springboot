package com.noxus.draven.rabbitmq.demo.customer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @QueueBinding 绑定一个队列
 * @Queue 获取队列 自动新增
 * @Exchange name：交换器名字  key：路由key
 */
@Service
public class InfoReceiver {
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "${mq.config.queue_name.info}", autoDelete = "true"),
                    exchange = @Exchange(value = "${mq.config.exchange_name}", type = ExchangeTypes.TOPIC),
                    key = "*.log.info"
            )
    )
    public void process(String msg) {
        System.out.println("......Info........receiver: " + msg);
    }
}

package com.noxus.draven.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMQApplication.class)
public class MqLogTest {


    @Autowired
    private AmqpTemplate amqpTemplate;

    private static String exchange = "log.topic";

    private static String msg = "log.topic";

    @Test
    public void sendUser() {
        //向消息队列发送消息
        //参数一：交换器名称。
        //参数二：路由键
        //参数三：消息
        this.amqpTemplate.convertAndSend(this.exchange, "order.log.debug", "user.log.debug....." + msg);
        this.amqpTemplate.convertAndSend(this.exchange, "order.log.info", "user.log.info....." + msg);
        this.amqpTemplate.convertAndSend(this.exchange, "order.log.warn", "user.log.warn....." + msg);
        this.amqpTemplate.convertAndSend(this.exchange, "order.log.error", "user.log.error....." + msg);
    }


    @Test
    public void sendProduct() {
        //向消息队列发送消息
        //参数一：交换器名称。
        //参数二：路由键
        //参数三：消息
        this.amqpTemplate.convertAndSend(this.exchange, "product.log.debug", "product.log.debug....." + msg);
        this.amqpTemplate.convertAndSend(this.exchange, "product.log.info", "product.log.info....." + msg);
        this.amqpTemplate.convertAndSend(this.exchange, "product.log.warn", "product.log.warn....." + msg);
        this.amqpTemplate.convertAndSend(this.exchange, "product.log.error", "product.log.error....." + msg);
    }
}


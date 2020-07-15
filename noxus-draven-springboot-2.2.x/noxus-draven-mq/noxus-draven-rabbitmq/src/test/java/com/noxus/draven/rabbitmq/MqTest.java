package com.noxus.draven.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMQApplication.class)
public class MqTest {


    static String one = "log";
    static String two = "two";
    static String three = "three";


    private final static String TopicQueueone = "good." + MqTest.one;
    private final static String TopicQueuetwo = MqTest.two + ".log";
    private final static String TopicQueuethree = "#." + MqTest.three;
    private final static String TopicQueufour = "good." + MqTest.one+".";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 直接模式测试方法
     */
    @Test
    public void testDirectSend() {
        rabbitTemplate.convertAndSend("draven", "直接模式测试");
    }


    /**
     * 分裂模式测试方法
     */
    @Test
    public void testFanoutSend() {
        rabbitTemplate.convertAndSend("draven", "", "分裂模式测试");
    }


    @Test
    public void testTopicSendOne() {
        rabbitTemplate.convertAndSend("topic", TopicQueueone, "主题模式测试");
    }

    @Test
    public void testTopicSendTwo() {
        rabbitTemplate.convertAndSend("topic", TopicQueuetwo, "主题模式测试");
    }

    @Test
    public void testTopicSendThree() {
        rabbitTemplate.convertAndSend("topic", TopicQueufour, "主题模式测试");
    }

}

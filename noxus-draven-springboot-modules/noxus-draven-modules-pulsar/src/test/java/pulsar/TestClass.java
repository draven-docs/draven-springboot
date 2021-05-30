package pulsar;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.pulsar.client.api.*;
import org.apache.pulsar.shade.com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pulsar.plus.entity.TOrder0;
import pulsar.plus.entity.TOrder1;
import pulsar.plus.service.TOrder0Service;
import pulsar.plus.service.TOrder1Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * 〈功能概述〉<br>
 *
 * @className: TestClass
 * @package: pulsar
 * @author: draven
 * @date: 2021/5/27 12:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("pulsar.plus.mapper")
public class TestClass {

    @Autowired
    private TOrder1Service tOrder1Service;

    @Autowired
    private TOrder0Service tOrder0Service;

    @Test
    public void getTOrder1() {
        // List<TOrder0> tOrder0 = tOrder0Service.list();
        QueryWrapper<TOrder0> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("failed", "1");
        List<TOrder0> tOrder0 = tOrder0Service.getBaseMapper().selectList(objectQueryWrapper);


        System.out.println(tOrder0);
    }

    @Test
    //@Scheduled(cron = "0/5 * * * * ?")
    public void sendClient() throws PulsarClientException, JsonProcessingException, com.fasterxml.jackson.core.JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // 获取数据
        //List<TOrder0> tOrder0 = tOrder0Service.list();
        QueryWrapper<TOrder0> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("failed", "1");
        List<TOrder0> tOrder0 = tOrder0Service.getBaseMapper().selectList(objectQueryWrapper);


        String s = mapper.writeValueAsString(tOrder0);

//        PulsarClient client = PulsarClient.builder()
//                .serviceUrl("pulsar://10.211.55.5:6650")
//                .build();
//
//        Producer<byte[]> producer = client.newProducer()
//                .topic("topic3")
//                .create();

        //MessageId send = producer.send(tOrder1.toString().getBytes(StandardCharsets.UTF_8));


//        PulsarClient client1 = PulsarClient.builder()
//                .serviceUrl("pulsar://10.211.55.5:6650")
//                .build();
//        Producer<TOrder1> topic3 = client1.newProducer(Schema.JSON(TOrder1.class))
//                .topic("topic3").create();
//
//        TOrder1 tOrder11 = tOrder1.get(0);
//        topic3.send(tOrder11);


        PulsarClient client1 = PulsarClient.builder()
                .serviceUrl("pulsar://10.211.55.5:6650")
                .build();

//        Producer<TOrder1> topic3 = client1.newProducer(Schema.JSON(TOrder1.class))
//                .topic("topic3").create();
//
//        tOrder1.forEach(tOrder11 -> {
//            try {
//                topic3.newMessage().key(tOrder11.getUserId().toString()).value(tOrder11).send();
//            } catch (PulsarClientException e) {
//                e.printStackTrace();
//            }
//
//        });


        Producer<String> topic3 = client1.newProducer(Schema.STRING)
                .topic("topic4")
                .create();
        topic3.newMessage().key("topic4").value(s).send();

        System.out.println("推送数据 " + s);
//        tOrder1.forEach(tOrder11 -> {
//            try {
//                topic3.newMessage().key(tOrder11.getUserId().toString()).value(tOrder11).send();
//            } catch (PulsarClientException e) {
//                e.printStackTrace();
//            }
//
//        });

//        List<String> of = List.of("hello", "hello");
//        producer.send(of.toString().getBytes(StandardCharsets.UTF_8));
        //TypedMessageBuilder<byte[]> typedMessageBuilder = producer.newMessage();
        //typedMessageBuilder.replicationClusters(of).send();
    }


    @Test
    public void getClient() throws PulsarClientException, UnsupportedEncodingException {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://10.211.55.5:6650")
                .build();

        Consumer consumer = client.newConsumer()
                .topic("topic4")
                .subscriptionName("my-subscription")
                .subscribe();
        while (true) {
            Message msg = consumer.receive();
            byte[] data = msg.getData();
            String secret = new String(data, "utf-8");
            List<Character> list = Arrays.asList(ArrayUtils.toObject(secret.toCharArray()));
            System.out.println(list);
        }

    }

    @Test
    public void getClientList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://10.211.55.5:6650")
                .build();

        Consumer consumer = client.newConsumer(Schema.STRING)
                .topic("topic4")
                .subscriptionName("my-subscription")
                .subscriptionType(SubscriptionType.Exclusive)
                .subscribe();
        while (true) {
            Message receive = consumer.receive();
            /*MessageId messageId = receive.getMessageId();

            consumer.acknowledge(messageId);*/
//
//            TOrder1 value = (TOrder1) receive.getValue();
//            System.out.println(value);

            //String s = new String(receive.getData());

            //System.out.println(s);

            List tOrder1 = mapper.readValue(receive.getData(), List.class);

            System.out.println(tOrder1);
            if (tOrder1.size() > 0) {
                Object o = tOrder1.get(0);

            }



           /* List objects = new ArrayList<>();
            for (int i = 0; i < tOrder1.size(); i++) {
                TOrder1 tOrder12 = new TOrder1();
                TOrder1 tOrder11 = tOrder1.get(i);
                tOrder12.setOrderId(tOrder1.get(i).getOrderId()+1);
                //tOrder12.setUserId(tOrder1.get(i));
                objects.add(tOrder12);
            }*/
           /* tOrder1.forEach(tOrder11 -> {

            });*/


            // 消息确认消费

            try {
                boolean b = tOrder1Service.saveBatch(tOrder1);
                System.out.println(b);
                if (b) {
                    for (int i = 0; i < tOrder1.size(); i++) {
                        TOrder0 tOrder11 = new TOrder0();
                        Map o = (Map) tOrder1.get(i);
                        o.put("failed", "成功");
                        tOrder11.setFailed("成功");
                        tOrder11.getOrderId(Long.valueOf(o.get("orderId") + ""));
                        tOrder11.getUserId(Integer.valueOf(o.get("userId") + ""));

                        UpdateWrapper<TOrder0> objectUpdateWrapper = new UpdateWrapper<>();
                        objectUpdateWrapper.eq("user_id", o.get("userId"));
                        objectUpdateWrapper.eq("order_id", o.get("orderId"));
                        //objectUpdateWrapper.eq("failed","失败");
                        boolean update = tOrder0Service.update(tOrder11, objectUpdateWrapper);
                        System.out.println(update);
                        consumer.negativeAcknowledge(receive);
                       // 11:51:51	update  t_order_0 set failed = '1' where failed != ''	Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.00032 sec
//11:54:57	show variables like ‘SQL_SAFE_UPDATES’	Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '‘SQL_SAFE_UPDATES’' at line 1	0.00027 sec
                        // show variables like 'SQL_SAFE_UPDATES';
                    }
                } else {
                    TOrder0 tOrder11 = new TOrder0();
                    tOrder11.setOrderId(582713382323859457l);
                    tOrder11.setUserId(954);
                    tOrder11.setFailed("失败");
                    UpdateWrapper<TOrder1> objectUpdateWrapper = new UpdateWrapper<>();
                    tOrder0Service.update(tOrder11, new UpdateWrapper<>());
                    consumer.negativeAcknowledge(receive);
                }
                CompletableFuture completableFuture = consumer.acknowledgeAsync(receive);
            } catch (Exception e) {
                for (int i = 0; i < tOrder1.size(); i++) {
                    TOrder0 tOrder11 = new TOrder0();
                    Map o = (Map) tOrder1.get(i);
                    o.put("failed", "失败");
                    tOrder11.setFailed("失败");
                    tOrder11.getOrderId(Long.valueOf(o.get("orderId") + ""));
                    tOrder11.getUserId(Integer.valueOf(o.get("userId") + ""));

                    UpdateWrapper<TOrder0> objectUpdateWrapper = new UpdateWrapper<>();
                    objectUpdateWrapper.eq("user_id", o.get("userId"));
                    objectUpdateWrapper.eq("order_id", o.get("orderId"));
                    //objectUpdateWrapper.eq("failed","失败");
                    boolean update = tOrder0Service.update(tOrder11, objectUpdateWrapper);
                    System.out.println(update);
                    consumer.negativeAcknowledge(receive);

                }
                ;

            }

        }

    }

    @Test
    public void getClientLists() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://10.211.55.5:6650")
                .build();

        Consumer consumer = client.newConsumer(Schema.STRING)
                .topic("topic4")
                .subscriptionName("my-subscription")
                .subscriptionType(SubscriptionType.Exclusive)
                .subscribe();
        while (true) {
            Message receive = consumer.receive();

            List tOrder1 = mapper.readValue(receive.getData(), List.class);
            CompletableFuture completableFuture = consumer.acknowledgeAsync(receive);
        }

    }

}




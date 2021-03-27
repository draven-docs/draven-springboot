package com.noxus.draven.sharding;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
@Rollback(true)
public class DistributedShardingApplicationTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void insert() {
        for (int i = 0; i < 20; i++) {
            OrderEntity orderEntity = new OrderEntity();
//            orderEntity.setOrderId(System.currentTimeMillis());
            orderEntity.setUserId(new Random().nextInt(999));
            orderDao.save(orderEntity);
        }
    }

    @Test
    public void findByOrderId() {
        //从主库查数据
        HintManager.getInstance().setPrimaryRouteOnly();
        OrderEntity byOrderId = orderDao.findByOrderId(582713382575517696L);
        log.info("byOrderId={}", byOrderId);
    }

    @Test
    public void findByUserId() {
        List<OrderEntity> byUserId = orderDao.findByUserId(630);
        log.info("byUserId={}", byUserId);
    }

    @Test
    @Transactional
    public void update() {
        OrderEntity byOrderId = orderDao.findByOrderId(582713382575517696L);
        log.info("byOrderId={}", byOrderId);
        byOrderId.setUserId(996);
        orderDao.save(byOrderId);
    }

}

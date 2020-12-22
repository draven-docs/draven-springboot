package com.noxus.draven.caching.rediss.service;

import com.noxus.draven.caching.rediss.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 〈功能概述〉<br>
 *
 * @className: RedisService
 * @package: com.noxus.draven.caching.rediss.service
 * @author: draven
 * @date: 2020/12/22 14:32
 */
@Service
@Slf4j
public class RedisService {
    public User getUser(int userId) {
        System.out.println("执行此方法，说明没有缓存，如果没有走到这里，就说明缓存成功了");
        User user = new User(userId, "没有缓存_" + userId, "password_" + userId);
        return user;
    }

    public User getUser2(int userId) {
        System.out.println("执行此方法，说明没有缓存，如果没有走到这里，就说明缓存成功了");
        User user = new User(userId, "name_nocache" + userId, "nocache");
        return user;
    }
}

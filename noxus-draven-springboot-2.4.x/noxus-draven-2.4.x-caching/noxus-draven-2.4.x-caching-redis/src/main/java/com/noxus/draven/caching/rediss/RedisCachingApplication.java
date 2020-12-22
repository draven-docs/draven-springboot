package com.noxus.draven.caching.rediss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 〈功能概述〉<br>
 *
 * @className: RedisCachingApplication
 * @package: com.noxus.draven.caching.rediss
 * @author: draven
 * @date: 2020/12/22 14:21
 */
@SpringBootApplication
@EnableCaching
public class RedisCachingApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisCachingApplication.class, args);
    }
}

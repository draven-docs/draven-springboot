package com.noxus.draven.caching.caffeine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 〈功能概述〉<br>
 *
 * @className: CaffeineApplication
 * @package: com.noxus.draven.caching.caffeine
 * @author: draven
 * @date: 2020/11/16 14:09
 * 不是分布式缓存
 */

@SpringBootApplication
@EnableCaching
public class CaffeineApplication {
    public static void main(String[] args) {
        SpringApplication.run(CaffeineApplication.class, args);
    }
}

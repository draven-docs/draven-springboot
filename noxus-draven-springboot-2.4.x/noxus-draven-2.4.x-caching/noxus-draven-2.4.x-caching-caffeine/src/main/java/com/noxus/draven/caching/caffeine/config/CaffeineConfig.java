/*
package com.noxus.draven.caching.caffeine.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

*/
/**
 * 〈功能概述〉<br>
 *
 * @className: CaffeineConfig
 * @package: com.noxus.draven.caching.caffeine.config
 * @author: draven
 * @date: 2020/12/21 14:40
 *//*

@Slf4j
@Configuration
public class CaffeineConfig {

    @Value("${spring.cache.caffeine.spec}")
    private String caffeineSpec;

    //@Autowired
    //private CacheLoader cacheLoader;

    */
/**
     * 用来加载数据
     * *//*

//    @Bean(name = "LoadingCache")
//    public LoadingCache cacheManagerWithAsyncCacheLoader(){
//        log.info("cacheManagerWithCacheLoading" );
//        LoadingCache loadingCache = Caffeine.newBuilder()
//                .recordStats()
//                .build(cacheLoader);
//        return loadingCache;
//    }

    @Bean
    public CacheManager cacheManagerWithCacheLoading() {
        log.info("cacheManagerWithCacheLoading");
        Caffeine caffeine = Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(1000)
//                .refreshAfterWrite(5,TimeUnit.SECONDS)
                .expireAfterWrite(50, TimeUnit.SECONDS);

        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setAllowNullValues(true);
        cacheManager.setCaffeine(caffeine);
//        cacheManager.setCacheLoader(cacheLoader);
        cacheManager.setCacheNames(getNames());
        return cacheManager;
    }


    @Bean(name = "caffeine")
    @Primary
    public CacheManager cacheManagerWithCaffeine() {
        log.info("This is cacheManagerWithCaffeine");
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        Caffeine caffeine = Caffeine.newBuilder()
                //cache的初始容量值
                .initialCapacity(100)
                //maximumSize用来控制cache的最大缓存数量，maximumSize和maximumWeight不可以同时使用，
                .maximumSize(1000);
        //控制最大权重
//                .maximumWeight(100);
//                .expireAfter();
        //使用refreshAfterWrite必须要设置cacheLoader
//                .refreshAfterWrite(5,TimeUnit.SECONDS);
        cacheManager.setCaffeine(caffeine);
//        cacheManager.setCacheLoader(cacheLoader);
        cacheManager.setCacheNames(getNames());
//        cacheManager.setAllowNullValues(false);
        return cacheManager;
    }

    @Bean(name = "caffeineSpec")
    public CacheManager cacheManagerWithCaffeineFromSpec() {
        CaffeineSpec spec = CaffeineSpec.parse(caffeineSpec);
        Caffeine caffeine = Caffeine.from(spec);
        //此方法等同于上面from(spec)
//        Caffeine caffeine = Caffeine.from(caffeineSpec);

        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeine);
        cacheManager.setCacheNames(getNames());
        return cacheManager;
    }

    private static List<String> getNames() {
        List<String> names = new ArrayList<>(2);
        names.add("outLimit");
        names.add("notOutLimit");
        return names;
    }
}
*/

package com.noxus.draven.caching.caffeine.config;

/**
 *
 */
//@Configuration
//public class CaffeineConfigSingle {

//    @Bean
//    public Cache<String, Object> caffeineCache() {
//        return Caffeine.newBuilder()
//                // 设置最后一次写入或访问后经过固定时间过期
//                .expireAfterWrite(10, TimeUnit.SECONDS)
//                // 初始的缓存空间大小
//                .initialCapacity(100)
//                // 缓存的最大条数
//                .maximumSize(1000)
//                .build();
//    }

    /**
     * 配置缓存管理器
     *
     * @return 缓存管理器
     */
    /*@Bean("caffeineCacheManager")
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterAccess(60, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(1000));
       return cacheManager;
}*/


/*
    @Bean
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        List<CaffeineCache> caffeineCaches = new ArrayList<>();

        for (CacheType cacheType : CacheType.values()) {
            caffeineCaches.add(new CaffeineCache(cacheType.name(),
                    Caffeine.newBuilder()
                            .expireAfterWrite(2, TimeUnit.SECONDS)
                            .build()));
        }

        cacheManager.setCaches(caffeineCaches);

        return cacheManager;
    }*/
//}


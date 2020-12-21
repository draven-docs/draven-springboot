package com.noxus.draven.caching.ehcache.based;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author draven
 */
@SpringBootApplication
@EnableCaching
@Slf4j
public class EhcacheCacheApplication {

    public static void main(String[] args) {
        String tmpDir = System.getProperty("java.io.tmpdir");
        log.info("临时路径：" + tmpDir);
        SpringApplication.run(EhcacheCacheApplication.class, args);
    }

}

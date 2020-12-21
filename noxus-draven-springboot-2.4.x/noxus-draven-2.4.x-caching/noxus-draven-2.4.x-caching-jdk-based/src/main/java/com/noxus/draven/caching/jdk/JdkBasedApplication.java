package com.noxus.draven.caching.jdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JdkBasedApplication {
    public static void main(String[] args) {
        SpringApplication.run(JdkBasedApplication.class, args);
    }
}

package com.noxus.draven.caching.jsr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JSR107Application {
    public static void main(String[] args) {
        SpringApplication.run(JSR107Application.class, args);
    }
}

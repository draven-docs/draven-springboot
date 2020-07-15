package com.noxus.draven.router;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class RouterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouterApplication.class, args);
    }
}

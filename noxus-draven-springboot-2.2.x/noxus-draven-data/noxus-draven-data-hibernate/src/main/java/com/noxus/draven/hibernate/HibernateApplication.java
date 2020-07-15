package com.noxus.draven.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.noxus.draven.hibernate.entity")
public class HibernateApplication {
    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

}

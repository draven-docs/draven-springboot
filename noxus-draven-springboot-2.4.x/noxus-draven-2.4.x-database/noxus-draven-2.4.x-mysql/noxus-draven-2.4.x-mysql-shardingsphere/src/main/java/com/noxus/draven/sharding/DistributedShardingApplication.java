package com.noxus.draven.sharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author draven
 */
@SpringBootApplication(exclude = {
       // DataSourceAutoConfiguration.class,
        //SpringBootConfiguration.class, // ShardingSphereDataSourceAutoConfiguration
        //RabbitAutoConfiguration.class
})
public class DistributedShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedShardingApplication.class, args);
    }
}

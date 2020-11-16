package com.noxus.draven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 〈功能概述〉<br>
 *
 * @className: ConfigApplication
 * @package: com.noxus.draven.config
 * @author: draven
 * @date: 2020/11/11 11:05
 */
//@EnableConfigurationProperties
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(ConfigApplication.class, args);


    }
}

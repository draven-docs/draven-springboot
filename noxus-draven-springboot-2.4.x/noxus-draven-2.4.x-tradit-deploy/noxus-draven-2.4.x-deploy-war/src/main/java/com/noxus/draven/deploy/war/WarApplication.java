package com.noxus.draven.deploy.war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 〈功能概述〉<br>
 *
 * @className: WarApplication
 * @package: com.noxus.draven.deploy.war
 * @author: draven
 * @date: 2020/12/22 17:50
 */

@SpringBootApplication
public class WarApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WarApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WarApplication.class, args);
    }
}

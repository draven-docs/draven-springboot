package com.noxus.draven.deploy.jndi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * 〈功能概述〉<br>
 *
 * @className: JNDIApplication
 * @package: com.noxus.draven.deploy.jndi
 * @author: draven
 * @date: 2020/12/22 22:42
 */
@SpringBootApplication
public class JNDIApplication extends SpringBootServletInitializer implements
        WebApplicationInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JNDIApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JNDIApplication.class, args);
    }
}

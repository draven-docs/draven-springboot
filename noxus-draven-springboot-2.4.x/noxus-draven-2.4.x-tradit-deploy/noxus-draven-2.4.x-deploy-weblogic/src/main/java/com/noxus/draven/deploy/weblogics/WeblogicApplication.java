package com.noxus.draven.deploy.weblogics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * 〈功能概述〉<br>
 *
 * @className: WeblogicApplication
 * @package: com.noxus.draven.deploy.weblogics
 * @author: draven
 * @date: 2020/12/22 18:09
 */
@SpringBootApplication
public class WeblogicApplication extends SpringBootServletInitializer implements
        WebApplicationInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WeblogicApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(WeblogicApplication.class, args);
    }
}

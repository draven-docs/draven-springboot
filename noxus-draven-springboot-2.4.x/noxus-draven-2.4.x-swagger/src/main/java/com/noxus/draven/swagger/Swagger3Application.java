package com.noxus.draven.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 〈功能概述〉<br>
 *
 * @className: Swagger3Application
 * @package: com.noxus.draven.swagger
 * @author: draven
 * @date: 2020/12/23 09:06
 */
@EnableOpenApi
@SpringBootApplication
public class Swagger3Application {
    public static void main(String[] args) {
        SpringApplication.run(Swagger3Application.class, args);
    }

}

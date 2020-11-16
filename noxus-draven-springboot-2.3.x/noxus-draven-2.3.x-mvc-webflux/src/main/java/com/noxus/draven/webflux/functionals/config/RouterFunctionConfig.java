package com.noxus.draven.webflux.functionals.config;

import com.noxus.draven.webflux.functionals.handles.MonoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

/**
 * 〈功能概述〉<br>
 *
 * @className: config
 * @package: com.noxus.draven.webflux.functionals
 * @author: draven
 * @date: 2020/11/13 10:55
 */
@Configuration
public class RouterFunctionConfig {

    private final MonoHandler monoHandler;

    public RouterFunctionConfig(MonoHandler monoHandler) {
        this.monoHandler = monoHandler;
    }


    @Bean
    public RouterFunction<ServerResponse> routMono() {
        RouterFunction<ServerResponse> route = RouterFunctions
                .route(RequestPredicates.GET("/listPeople"), monoHandler::listPeople);


        return route;
    }


}

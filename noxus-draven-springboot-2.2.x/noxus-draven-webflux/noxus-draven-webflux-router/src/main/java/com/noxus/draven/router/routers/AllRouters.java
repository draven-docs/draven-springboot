package com.noxus.draven.router.routers;


import com.noxus.draven.router.handlers.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AllRouters {

    private final UserHandler userHandler;

    public AllRouters(UserHandler userHandler) {
        this.userHandler = userHandler;
    }


    @Bean
    RouterFunction<ServerResponse> userRouter() {
        return RouterFunctions.nest(
                RequestPredicates.path("/user"),
                RouterFunctions.route(RequestPredicates.GET("/"),
                        userHandler::getAll)
                        .andRoute(RequestPredicates.POST("/save").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)),
                                userHandler::createUser)
                        .andRoute(RequestPredicates.DELETE("/{id}"), userHandler::deleteUserById));
    }
}

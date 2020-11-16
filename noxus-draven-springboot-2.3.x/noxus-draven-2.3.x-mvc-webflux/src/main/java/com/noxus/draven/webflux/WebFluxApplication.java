package com.noxus.draven.webflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

/**
 * 〈功能概述〉<br>
 *
 * @className: ReactorApplication
 * @package: com.noxus.draven.reactor
 * @author: draven
 * @date: 2020/11/12 14:03
 */
@SpringBootApplication
@Slf4j
public class WebFluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class, args);
    }


   /* @Bean
    public RouterFunction<ServerResponse> rounterFunction() {

        return RouterFunctions.route(
                request -> {
                    URI uri = request.uri();
                    log.info("{}", "/hello-word".equals(uri.getPath()));
                    return "/hello-word".equals(uri.getPath());

                }, serverRequest -> {
                    Mono<ServerResponse> mono = ServerResponse.status(HttpStatus.OK)
                            .body(Mono.just("Hello Word"), String.class);
                    log.info("{}", mono);

                    return mono;
                }
        );

    }*/

    @Bean
    public RouterFunction<ServerResponse> rounterFunction() {

        return RouterFunctions.route(GET("/hello-word"), this::helloword);
    }


    public Mono<ServerResponse> helloword(ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just("Hello Word"), String.class);

    }

}

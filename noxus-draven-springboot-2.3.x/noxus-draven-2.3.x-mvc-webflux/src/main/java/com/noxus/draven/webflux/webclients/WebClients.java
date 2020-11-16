package com.noxus.draven.webflux.webclients;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 〈功能概述〉<br>
 *
 * @className: WebClients
 * @package: com.noxus.draven.webflux.webclients
 * @author: draven
 * @date: 2020/11/12 16:56
 */
@Controller
@RequestMapping
public class WebClients {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create();
        Mono<String> mono = webClient.get().uri("https://www.baidu.com").retrieve().bodyToMono(String.class);
        System.out.println(mono.block());
    }


    @GetMapping("webClientsMono")
    public Flux<String> webClientsMono() {
        WebClient webClient = WebClient.create();
        Mono<String> mono = webClient.get().uri("https://www.baidu.com").retrieve().bodyToMono(String.class);
        //System.out.println(mono.block());
        return Flux.concat(mono);
    }
}

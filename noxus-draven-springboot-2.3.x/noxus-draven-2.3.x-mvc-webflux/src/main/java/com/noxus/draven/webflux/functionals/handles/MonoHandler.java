package com.noxus.draven.webflux.functionals.handles;

import com.noxus.draven.webflux.functionals.bean.People;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * 〈功能概述〉<br>
 *
 * @className: MonoHandler
 * @package: com.noxus.draven.webflux.functionals.handles
 * @author: draven
 * @date: 2020/11/13 10:57
 */
@Component
public class MonoHandler {

    public Mono<ServerResponse> listPeople(ServerRequest request) {
        People people = new People("name1", "meil1");
        Mono<People> peopleMono = request.bodyToMono(People.class);
        Mono<People> just = Mono.just(people);
        return ServerResponse.ok().body(just, People.class);
    }


}

package com.noxus.draven.config.values.random;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 〈功能概述〉<br>
 *
 * @className: RandomValue
 * @package: com.noxus.draven.config.valuse.random
 * @author: draven
 * @date: 2020/11/11 11:04
 */
@RequestMapping
@RestController
@Slf4j
public class RandomValue {

    @Value("${server.port}")
    private String redisName;

    @Value("${my.secret}")
    private String mySecret;

//    @Value("#{${lll.hah}}")
//    private List<String> mySecrets;

    @GetMapping("RandomMono")
    public Mono RandomMono() {
        //redisName
        log.info("{}", redisName);
        //return Mono.just(redisName + "" + mySecret + "" + mySecrets);
        return Mono.just(redisName + "" + mySecret);
    }
}

package com.noxus.draven.gracefuls.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 〈功能概述〉<br>
 *
 * @className: GracefulController
 * @package: com.noxus.draven.gracefuls.controller
 * @author: draven
 * @date: 2020/11/16 09:31
 */
@RestController
@RequestMapping
@Slf4j
public class GracefulController {

    @GetMapping("gracefulMono")
    public Mono gracefulMono() throws InterruptedException {

        Thread.sleep(10000);
        log.info("{}", "我的心在等待");
        log.info("{}", Thread.currentThread().getName());
        return Mono.just("哇哈哈");
    }
}

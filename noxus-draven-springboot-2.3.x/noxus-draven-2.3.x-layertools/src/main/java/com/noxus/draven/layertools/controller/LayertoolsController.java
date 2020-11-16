package com.noxus.draven.layertools.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 〈功能概述〉<br>
 *
 * @className: LayertoolsController
 * @package: com.noxus.draven.layertools.controller
 * @author: draven
 * @date: 2020/11/16 09:57
 */

@RestController
@RequestMapping
@Slf4j
public class LayertoolsController {

    @GetMapping("layertoolsMono")
    public Mono gracefulMono() throws InterruptedException {

        log.info("{}", "我的心在等待");
        log.info("{}", Thread.currentThread().getName());
        return Mono.just("哇哈哈");
    }
}

package com.noxus.draven.caching.ehcache.based.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: HelloApi
 * @package: com.noxus.draven.caching.ehcache.based.controller
 * @author: draven
 * @date: 2020/12/21 16:27
 */
@RestController
public class HelloApi {

    @GetMapping("hello")
    public String hello() {
        return "Hello Spring Boot";
    }
}

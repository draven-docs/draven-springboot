package com.noxus.draven.deploy.war.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: HelloController
 * @package: com.noxus.draven.deploy.war.controller
 * @author: draven
 * @date: 2020/12/22 17:53
 */

@RequestMapping
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String port) {
        return port;
    }
}

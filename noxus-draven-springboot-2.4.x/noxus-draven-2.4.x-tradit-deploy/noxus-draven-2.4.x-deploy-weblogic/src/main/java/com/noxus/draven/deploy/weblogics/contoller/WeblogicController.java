package com.noxus.draven.deploy.weblogics.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: WeblogicController
 * @package: com.noxus.draven.deploy.weblogics.contoller
 * @author: draven
 * @date: 2020/12/22 18:15
 */

@RequestMapping
@RestController
@Slf4j
public class WeblogicController {

    @RequestMapping("/hello")
    public String hello(String port) {
        log.info("{}", port);
        return port;
    }
}

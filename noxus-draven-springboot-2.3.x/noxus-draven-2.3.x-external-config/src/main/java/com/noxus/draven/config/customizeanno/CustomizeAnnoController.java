package com.noxus.draven.config.customizeanno;

import com.noxus.draven.config.customizeanno.anno.CustomizeAnno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: CustomizeAnnoController
 * @package: com.noxus.draven.config.customizeanno
 * @author: draven
 * @date: 2021/7/15 15:30
 */
@RequestMapping
@RestController
@Slf4j
public class CustomizeAnnoController {

    @LocalServerPort
    int ports;

    @CustomizeAnno
    Long customizeAnno;


    @RequestMapping("/customizeAnno")
    public String hello(String port) {
        log.info("port {}", port);
        log.info("customizeAnno {}", customizeAnno);
        return ports + customizeAnno + "";
    }
}

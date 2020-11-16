package com.noxus.draven.logbacks.controlller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: LogbackController
 * @package: com.noxus.draven.logbacks.controlller
 * @author: draven
 * @date: 2020/11/13 17:56
 */
@RestController
@RequestMapping
@Slf4j
public class LogbackController {
    protected static final Logger logger = LoggerFactory.getLogger(LogbackController.class);

    @GetMapping("logbacks")
    public String logbacks() {
        String demo = "demo";
        log.info("{}", demo);
        log.debug("{}", demo);
        log.warn("{}", demo);

        logger.info("{}", demo);
        logger.debug("{}", demo);
        logger.warn("{}", demo);
        return demo;
    }
}

package com.noxus.draven.profiles.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: YamlController
 * @package: com.noxus.draven.profiles.controller
 * @author: draven
 * @date: 2020/11/13 14:05
 */
@RestController
@RequestMapping
public class YamlController {

    @Value("${demo}")
    String demo;

    @GetMapping("testProfilePro")
    public String testProfilePro() {
        return demo;
    }
}

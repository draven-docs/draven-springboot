package com.noxus.draven.profiles.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: PropertiesController
 * @package: com.noxus.draven.profiles.controller
 * @author: draven
 * @date: 2020/11/13 13:44
 */
@RestController
@RequestMapping
public class PropertiesController {

    @Value("${demo}")
    String demo;

    @GetMapping("testProfilePro")
    public String testProfilePro() {
        return demo;
    }
}
